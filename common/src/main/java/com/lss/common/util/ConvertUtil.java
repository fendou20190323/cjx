/**
 * @Project: lssplatform
 * @Title: ConvertUtil.java
 */
package com.lss.common.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.UUID;

/**
 * @ClassName: ConvertUtil
 * @Description: 转换工具类
 */
public class ConvertUtil {
    /**
     * 将字节数组转化为十六进制字符串
     *
     * @param data 字节数组
     * @return 十六进制字符串
     */
    public static String bytes2HexString(byte[] data) {
        return Hex.encodeHexString(data);
    }

    /**
     * 将十六进制字符串转化为字节数组
     *
     * @param hexString 十六进制字符串
     * @return 字节数组
     * @throws DecoderException
     */
    public static byte[] hexString2Bytes(String hexString) throws DecoderException {
        return Hex.decodeHex(hexString.toCharArray());
    }

    /**
     * 将字节数组转换为Base64字符串
     *
     * @param input 字节数组
     * @return Base64字符串
     */
    public static String bytes2Base64String(final byte[] input) {
        return Base64.encodeBase64String(input);
    }

    /**
     * 将Base64字符串转换为字节数组
     *
     * @param input Base64字符串
     * @return 字节数组
     */
    public static byte[] base64String2Bytes(final String input) throws IOException {
        return Base64.decodeBase64(input);
    }

    /**
     * 将字节数组（16位）转换为UUID
     *
     * @param bytes 字节数组
     * @return UUID
     */
    public static UUID bytes2Uuid(byte[] bytes) {
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        long firstLong = bb.getLong();
        long secondLong = bb.getLong();
        return new UUID(firstLong, secondLong);
    }

    /**
     * 将UUID转换为字节数组（16位）
     *
     * @param uuid UUID对象
     * @return 字节数组
     */
    public static byte[] uuid2Bytes(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    public static void main(String[] args) throws Exception {
        String plaintext = "001002999900002100090920140507094410800000000000中国";
        byte[] bytes = plaintext.getBytes("UTF-8");
        System.out.println("plainText=      " + plaintext);
        String hexString = bytes2HexString(bytes);
        System.out.println("HexString=     " + hexString);
        System.out.println("from Hex=     " + new String(hexString2Bytes(hexString)));
        String base64 = bytes2Base64String(bytes);
        System.out.println("base64String=" + base64);
        String s = new String(base64String2Bytes(base64));
        System.out.println("from Base64= " + s);

        byte[] bytesUuid = uuid2Bytes(UUID.randomUUID());
        String hexStringUuid = bytes2HexString(bytesUuid);
        System.out.println("hexStringUuid=     " + hexStringUuid);
        System.out.println("UUID=                   " + bytes2Uuid(hexString2Bytes(hexStringUuid)));
    }

    public static HashMap<String, Object> convertBean2M1ap(Object bean) throws IllegalArgumentException, IllegalAccessException {
        Field[] fields = bean.getClass().getDeclaredFields();
        HashMap<String, Object> hashMap = new HashMap<>();
        if (fields != null) {
            //获取Bean属性和值
            for (Field field : fields) {
                field.setAccessible(true);
                hashMap.put(field.getName(), field.get(bean));
            }
        }
        return hashMap;
    }

    /**
     * 将JavaBean的实例化对象转成Map<Object, Object>
     *
     * @param bean
     * @return
     * @throws Exception
     */
    public static HashMap<String, Object> convertBean2Map(Object bean) throws Exception {
        Class<? extends Object> type = bean.getClass();
        HashMap<String, Object> returnMap = new HashMap<>(10);
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0, n = propertyDescriptors.length; i < n; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                if (readMethod == null && descriptor.getPropertyType().equals(Boolean.class)) {
                    String booleanGetter = "is" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                    for (Method method : bean.getClass().getDeclaredMethods()) {
                        if (method.getName().equals(booleanGetter)) {
                            if (method.getName().equals(getBooleanGetterName4Property(propertyName))) {
                                try {
                                    readMethod = method;
                                    descriptor.setReadMethod(method);
                                } catch (IntrospectionException e) {
                                    throw new IllegalStateException("Cannot set read method" + e);
                                }
                            }
                        }
                    }
                }
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, null);
                }

            }
        }
        return returnMap;
    }

    private static String getBooleanGetterName4Property(String propertyName) {
        if (propertyName == null || propertyName.length() == 0) {
            return null;
        }
        return "is" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
    }

}
