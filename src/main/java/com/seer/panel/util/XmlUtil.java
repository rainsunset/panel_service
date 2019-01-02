package com.seer.panel.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.dom.DOMDocument;
import org.dom4j.dom.DOMElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * XML 相关工具方法
 * @author : ligangwei / ligangwei@seerbigdata.com
 * @version : 1.0
 */
public class XmlUtil {
    //region 解析XML
    /**
     * XML字符串转换成Document对象
     * @param xml XML字符串
     * @return Document
     */
    public static Document parseXMLToDocument(String xml) {
        if (xml == null || "".equals(xml)){
            return null;
        }
        Document document = null;
        try {
            document = DocumentHelper.parseText(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

    /**
     * XML字符串转对象(解析根节点标签，名称为对象类型名称)
     * @param xml XML字符串
     * @param clazz 目标对象类型
     * @return Object
     */
    public static <T> T parseXMLToObject(String xml, Class<T> clazz){
        Document doc = parseXMLToDocument(xml);
        if (doc == null)
            return null;
        try{
            Element root = doc.getRootElement();
            Iterator iterator = root.elementIterator();
            return (T) parseXMLChildToObject(iterator,clazz);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * XML字符串转对象(不解析根节点标签)
     * @param xml XML字符串
     * @param clazz 目标对象类型
     * @return Object
     */
    public static <T> T parseXMLToObjectWithoutRoot(String xml, Class<T> clazz){
        Document doc = parseXMLToDocument(xml);
        if (doc == null)
            return null;
        Element element = doc.getRootElement();
        String elementText;
        try {
            if (element != null) {
                Object object = clazz.newInstance();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (isSimpleType(field.getType())) {
                        elementText = element.elementText(field.getName());
                        if (elementText == null)
                            continue;
                        setter(object, firstLetterToUpper(field.getName()), elementText, field.getType());
                    } else if (List.class == field.getType()) {
                        ParameterizedType pt = (ParameterizedType) field.getGenericType();
                        Class<?> listElementClazz = (Class<?>) pt.getActualTypeArguments()[0];
                        Iterator childIterator = element.elementIterator();
                        Object obj = parseXMLChildToList(childIterator, listElementClazz);
                        setter(object, firstLetterToUpper(field.getName()), obj, field.getType());
                    } else {
                        Iterator childIterator = element.elementIterator();
                        System.out.println(field.getType().getCanonicalName());
                        Object obj = parseXMLChildToObject(childIterator, field.getType());
                        setter(object, firstLetterToUpper(field.getName()), obj, field.getType());
                    }
                }
                return (T) object;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * XML字符串解析为Map
     * @param xml XML字符串
     * @return Map
     */
    public static Map<String, String> parseXMLToMap(String xml){
        Document doc = parseXMLToDocument(xml);
        if (doc == null)
            return null;
        Element root = doc.getRootElement();
        if (root == null)
            return null;
        Iterator<Element> iterator = root.elementIterator();
        Map<String, String> dataMap = new HashMap<>();
        while (iterator.hasNext()){
            Element element = iterator.next();
            if (element != null){
                dataMap.put(element.getName(),element.getText());
            }
        }
        return dataMap;
    }

    /**
     * XML字符串转集合
     * @param xml XML字符串
     * @param clazz list中对象类型
     * @return List
     */
    public static <T> List<T> parseXMLToList(String xml, Class<T> clazz){
        Document doc = parseXMLToDocument(xml);
        try{
            Element root = doc.getRootElement();
            Iterator iterator = root.elementIterator();
            return (List<T>) parseXMLChildToList(iterator,clazz);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 递归解析子节点，节点为Object
     * @param iterator 子节点迭代器
     * @param clazz 子节点类型
     * @return Object
     */
    private static Object parseXMLChildToObject(Iterator<Element> iterator, Class<?> clazz) {
        String elementText;
        try {
            Object object = clazz.newInstance();
            if (iterator.hasNext()) {
                Element element = iterator.next();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (isSimpleType(field.getType())) {
                        elementText = element.elementText(field.getName());
                        if (elementText == null)
                            continue;
                        setter(object, firstLetterToUpper(field.getName()), elementText, field.getType());
                    } else if (List.class == field.getType()) {
                        ParameterizedType pt = (ParameterizedType) field.getGenericType();
                        Class<?> listElementClazz = (Class<?>) pt.getActualTypeArguments()[0];
                        Iterator childIterator = element.elementIterator();
                        Object obj = parseXMLChildToList(childIterator, listElementClazz);
                        setter(object, firstLetterToUpper(field.getName()), obj, field.getType());
                    } else {
                        Iterator childIterator = element.elementIterator();
                        System.out.println(field.getType().getCanonicalName());
                        Object obj = parseXMLChildToObject(childIterator, field.getType());
                        setter(object, firstLetterToUpper(field.getName()), obj, field.getType());
                    }
                }
                return object;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 递归解析子节点，节点为List
     * @param iterator 子节点迭代器
     * @param clazz 子节点类型
     * @return List
     */
    private static List<Object> parseXMLChildToList(Iterator<Element> iterator, Class<?> clazz) {
        List<Object> list = new ArrayList<>();
        String elementText;
        try {
            while (iterator.hasNext()) {
                Object object = clazz.newInstance();
                Element element = iterator.next();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (isSimpleType(field.getType())) {
                        elementText = element.elementText(field.getName());
                        if (elementText == null)
                            continue;
                        setter(object, firstLetterToUpper(field.getName()), elementText, field.getType());
                    } else if (List.class == field.getType()) {
                        ParameterizedType pt = (ParameterizedType) field.getGenericType();
                        Class<?> listChildClazz = (Class<?>) pt.getActualTypeArguments()[0];
                        Iterator childIterator = element.elementIterator();
                        Object obj = parseXMLChildToList(childIterator, listChildClazz);
                        setter(object, firstLetterToUpper(field.getName()), obj, field.getType());
                    } else {
                        Iterator children = element.elementIterator();
                        Object obj = parseXMLChildToObject(children, field.getType());
                        setter(object, firstLetterToUpper(field.getName()), obj, field.getType());
                    }
                }
                list.add(object);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //endregion

    //region 生成XML
    /**
     * 对象转XML字符串
     * @param object 对象
     * @param rootName 根节点名称
     * @return String
     */
    public static String createXMLStringByObject(Object object, String rootName){
        Document doc = createXmlDocumentByObject(object, rootName);
        return doc == null ? null : doc.asXML().replaceFirst("\\s*<[^<>]+>\\s*", "");
    }

    /**
     * 对象转Document
     * @param object 对象
     * @param rootName 根节点名称
     * @return Document
     */
    public static Document createXmlDocumentByObject(Object object, String rootName) {
        if (object == null)
            return null;
        else {
            Document doc = new DOMDocument();
            if (object instanceof List) {
                for (Object obj : (List<?>) object) {
                    createXMLChildByObject(doc, obj, rootName);
                }
            } else if (object instanceof Set) {
                for (Object obj : (Set) object) {
                    createXMLChildByObject(doc, obj, rootName);
                }
            } else {
                createXMLChildByObject(doc, object, rootName);
            }
            return doc;
        }
    }


    /**
     * Map转Document
     * @param dataMap dataMap
     * @param rootName 根节点名称
     * @return String
     */
    public static String createXMLStringByMap(Map<String, String> dataMap, String rootName){
        Document doc = createXMLDocumentByMap(dataMap, rootName);
        return doc == null ? null : doc.asXML().replaceFirst("\\s*<[^<>]+>\\s*", "");
    }

    /**
     * Map转Document
     * @param dataMap dataMap
     * @param rootName 根节点名称
     * @return Document
     */
    public static Document createXMLDocumentByMap(Map<String, String> dataMap, String rootName) {
        if (rootName == null || "".equals(rootName)
                || dataMap == null || dataMap.size() == 0) {
            return null;
        }
        Document doc = new DOMDocument();
        Element root = new DOMElement(rootName);
        doc.add(root);
        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            if (entry.getValue() != null && !entry.getValue().equals("")){
                root.addElement(entry.getKey()).setText(entry.getValue());
            }
        }
        return doc;
    }

    /**
     * 根据Bean向Document中添加节点
     * @param root Document
     * @param object 对象
     * @param rootName 根节点名称
     */
    private static void createXMLChildByObject(Document root, Object object, String rootName) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Element element = new DOMElement((rootName == null || "".equals(rootName) ? clazz.getSimpleName() : rootName));
        for (Field field : fields) {
            createXMLByField(field, element, object);
        }
        root.add(element);
    }

    /**
     * 递归向Document中添加子节点
     * @param field 对象属性
     * @param element 子节点
     * @param object 对象
     */
    private static void createXMLByField(Field field, Element element, Object object) {
        Class<?> type = field.getType();
        if (isSimpleType(type)) {
            try {
                String elementText = toString(getter(object, firstLetterToUpper(field.getName())));
                if(elementText != null && !elementText.equals("")){
                    element.addElement(field.getName())
                            .setText(toString(getter(object, firstLetterToUpper(field.getName()))));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                Object child = getter(object, firstLetterToUpper(field.getName()));
                if (child instanceof List) {
                    for (Object obj : (List<?>) child) {
                        Element chidElelment = new DOMElement(obj.getClass().getSimpleName());
                        Field[] fields = obj.getClass().getDeclaredFields();
                        for (Field chidField : fields) {
                            createXMLByField(chidField, chidElelment, obj);
                        }
                        element.add(chidElelment);
                    }
                } else {
                    if (child != null) {
                        Element chidElelment = new DOMElement(child.getClass().getSimpleName());
                        Field[] chidFields = child.getClass().getDeclaredFields();
                        for (Field chidField : chidFields)
                            createXMLByField(chidField, chidElelment, child);
                        element.add(chidElelment);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //endregion

    //region Common functions
    /**
     * 简单数据类型判断
     * @param type 数据类型
     * @return boolean
     */
    private static boolean isSimpleType(Class<?> type){
        if (type == String.class
                || type == int.class || type == Integer.class
                || type == double.class || type == Double.class
                || type == char.class || type == Character.class
                || type == long.class || type == Long.class
                || type == float.class || type == Float.class
                || type == byte.class || type == Byte.class
                || type == boolean.class || type == Boolean.class
                || type == short.class || type == Short.class
                || type==Date.class) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * 调用对象的属性get方法
     * @param obj 对象
     * @param att 对象属性
     * @return Object
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private static Object getter(Object obj, String att) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        Method method = obj.getClass().getMethod("get" + att);
        return method.invoke(obj);
    }

    /**
     * 调用对象属性的set方法
     * @param obj 对象
     * @param att 对象属性
     * @param value 属性值
     * @param type 属性类型
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws ParseException
     */
    private static void setter(Object obj, String att, Object value, Class<?> type) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");

            Method method = obj.getClass().getMethod("set" + att, type);
            if (type == String.class)
                method.invoke(obj, toString(value));
            else if (type == Integer.class || type == int.class)
                method.invoke(obj, toInteger(value));
            else if (type == double.class || type == Double.class)
                method.invoke(obj, toDouble(value));
            else if(type == char.class || type == Character.class)
                method.invoke(obj,toCharacter(value));
            else if(type == long.class || type == Long.class)
                method.invoke(obj,toLong(value));
            else if(type == float.class || type == Float.class)
                method.invoke(obj,toFloat(value));
            else if(type == byte.class || type == Byte.class)
                method.invoke(obj,toByte(value));
            else if(type == boolean.class || type == Boolean.class)
                method.invoke(obj,toBoolean(value));
            else if(type == short.class || type == Short.class)
                method.invoke(obj,toShort(value));
            else if(type == java.util.Date.class){
                method.invoke(obj, df.parse(String.valueOf(value)));
            }
            else
                method.invoke(obj,value);

    }

    /**
     * 首字母大写
     * @param str 字符串
     * @return String
     */
    private static String firstLetterToUpper(String str) {
        char[] array = str.toCharArray();
        array[0] -= 32;
        return String.valueOf(array);
    }

    /**
     * 首字母小写
     * @param str 字符串
     * @return String
     */
    private static String firstUpperToLetter(String str) {
        char[] array = str.toCharArray();
        array[0] += 32;
        return String.valueOf(array);
    }

    /**
     * 对象转换成字符串
     * @param object 对象
     * @return String
     */
    private static String toString(Object object) {
        if (object == null)
            return "";
        else
            return object.toString();
    }

    /**
     * 对象转换成整形
     * @param object 对象
     * @return Integer
     */
    private static Integer toInteger(Object object) {
        String str = toString(object);
        if ("".equals(str))
            return 0;
        else
            return Integer.parseInt(str);
    }

    /**
     * 对象转换成double
     * @param object 对象
     * @return Double
     */
    private static Double toDouble(Object object){
        String str = toString(object);
        if("".equals(str))
            return 0.0;
        else
            return Double.parseDouble(str);
    }

    /**
     * 对象转换成float
     * @param object 对象
     * @return Float
     */
    private static Float toFloat(Object object){
        String str = toString(object);
        if("".equals(str))
            return 0.0f;
        else
            return Float.parseFloat(str);
    }

    /**
     * 对象转换成long
     * @param object 对象
     * @return Long
     */
    private static Long toLong(Object object){
        String str = toString(object);
        if("".equals(str))
            return 0L;
        else
            return Long.parseLong(str);
    }

    /**
     * 对象转换成booean
     * @param object 对象
     * @return Boolean
     */
    private static Boolean toBoolean(Object object){
        String str = toString(object);
        if ("".equals(str))
            return true;
        else
            return Boolean.parseBoolean(str);
    }

    /**
     * 对象转换成short
     * @param object 对象
     * @return Short
     */
    private static Short toShort(Object object){
        String str = toString(object);
        if("".equals(str))
            return 0;
        else
            return Short.parseShort(str);
    }

    /**
     * 对象转换成byte
     * @param object 对象
     * @return Byte
     */
    private static Byte toByte(Object object){
        String str = toString(object);
        if("".equals(str))
            return 0;
        else
            return Byte.parseByte(str);
    }

    /**
     * 对象转换成char
     * @param object 对象
     * @return Character
     */
    private static Character toCharacter(Object object){
        if (object == null)
            return '\u0beb';
        else
            return (Character) object;
    }
    //endregion
}
