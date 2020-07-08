package com.lss.common.util;


import com.lss.common.annotation.CSVTimestampMark;
import com.lss.common.annotation.CsvVOAttribute;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 导出CSV 工具类
 *
 * @date 2019/5/6
 */

public class CSVUtil<T> {
    Class<T> clazz;

    public CSVUtil(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * CSV文件列分隔符
     */
    private static final String CSV_COLUMN_SEPARATOR = ",";

    /**
     * CSV文件列分隔符
     */
    private static final String CSV_RN = "\r\n";


    /**
     * 数据初始化
     *
     * @param data            数据库查出来的数据
     * @param displayColNames csv表头
     * @param matchColNames   data中的key ，可以说是数据库字段了,原本为”0001”类型的数据在excel中打开会被默认改变为”1”的数据。 解决方法 :key前加"'"用于特殊处理；
     *                        例如 输入列名为"num"数字为 001，则传入的key值为"-num",保证输出为字符串
     * @return
     */
    public static String formatCsvData(List<Map<String, Object>> data,
                                       String displayColNames, String matchColNames) {

        StringBuilder builder = new StringBuilder();

        String[] displayColNamesArr;
        String[] matchColNamesMapArr;

        displayColNamesArr = displayColNames.split(",");
        matchColNamesMapArr = matchColNames.split(",");

        // 输出列头
        for (String s : displayColNamesArr) {
            builder.append(s).append(CSV_COLUMN_SEPARATOR);
        }
        builder.append(CSV_RN);

        if (null != data) {
            // 输出数据
            for (Map<String, Object> datum : data) {

                for (String s : matchColNamesMapArr) {
                    //处理list<Map>中 value=null的数据
                    Object object = datum.get(s);
                    if (object == null) {
                        object = datum.get(s.substring(1));
                    }
                    if (object == null) {
                        builder.append(CSV_COLUMN_SEPARATOR);
                    } else {
                        if (s.startsWith("-")) {
                            builder.append("\t").append(object.toString()).append(CSV_COLUMN_SEPARATOR);
                        } else {
                            builder.append(object).append(CSV_COLUMN_SEPARATOR);
                        }
                    }
                }
                builder.append(CSV_RN);
            }
        }
        return builder.toString();
    }

    /**
     * @param data 查询数据
     * @return 格式化后的数据
     * @description 格式化数据
     */
    public String formatCsvData(List<T> data) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Map<String, List<String>> map = getCsvVOAttributeAttr();

        StringBuilder builder = new StringBuilder();

        List<String> displayColNamesList = map.get("displayColNamesList");
        List<String> matchColNamesMapList = map.get("matchColNamesMapList");


        // 输出列头
        for (String s : displayColNamesList) {
            builder.append(s).append(CSV_COLUMN_SEPARATOR);
        }
        builder.append(CSV_RN);

        if (null != data) {
            // 输出数据
            for (T t : data) {
                for (String s : matchColNamesMapList) {
                    //处理list<Map>中 value=null的数据
                    Method method = clazz.getMethod("get" + s.substring(0, 1).toUpperCase() + s.substring(1));
                    Object object = method.invoke(t);
                    if (object == null) {
                        builder.append(CSV_COLUMN_SEPARATOR);
                    } else {
                        if (s.startsWith("-")) {
                            builder.append("\t").append(object.toString()).append(CSV_COLUMN_SEPARATOR);
                        } else {
                            boolean flag = method.isAnnotationPresent(CSVTimestampMark.class);
                            if (flag) {
                                Timestamp obj = (Timestamp) object;
                                String format = new SimpleDateFormat("yyyy-MM-dd hh;mm;ss").format(obj);
                                builder.append(format).append(CSV_COLUMN_SEPARATOR);
                            } else {
                                builder.append(object).append(CSV_COLUMN_SEPARATOR);
                            }
                        }
                    }
                }
                builder.append(CSV_RN);
            }
        }
        return builder.toString();
    }

    /**
     * 导出
     *
     * @param content 内容
     * @throws IOException
     */
    public void exportCsv(String content,
                          ServletOutputStream os) throws IOException {

        // 读取字符编码
        String csvEncoding = StandardCharsets.UTF_8.toString();

        // 写出响应
        byte[] uft8bom = {(byte) 0xef, (byte) 0xbb, (byte) 0xbf};
        os.write(uft8bom);
        os.write(content.getBytes(csvEncoding));
        os.flush();
        os.close();
    }

    private Map<String, List<String>> getCsvVOAttributeAttr() {
        Map<String, List<String>> map = new HashMap<>();
        List<String> displayColNameList = new LinkedList<>();
        List<String> matchColNameList = new LinkedList<>();
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length > 0) {
            for (Field field : fields) {
                if (field.isAnnotationPresent(CsvVOAttribute.class)) {
                    CsvVOAttribute annotation = field.getAnnotation(CsvVOAttribute.class);
                    String displayColName = annotation.name();
                    displayColNameList.add(displayColName);
                    String matchColName = field.getName();
                    matchColNameList.add(matchColName);
                }
            }
        }
        map.put("displayColNamesList", displayColNameList);
        map.put("matchColNamesMapList", matchColNameList);
        return map;
    }

    /**
     * 导入
     *
     * @param inputStream csv文件(流)
     * @return
     */
    public Map<String, Object> importCsv(InputStream inputStream) throws IOException, IllegalAccessException, InstantiationException, ParseException {
        Scanner scanner = new Scanner(inputStream, "GBK").useDelimiter("\r\n");
        List<String> names = Arrays.asList(scanner.next().split(","));
        List<String> colNames =new LinkedList<>();
        names.stream().forEach(c->{
            String name = c.trim();
            colNames.add(name);
        });
        List<T> dataList = new LinkedList<>();
        Field[] fields = clazz.getDeclaredFields();
        List<Field> fieldList = Arrays.asList(fields);
        List<Field> filterFileds = fieldList.stream().filter(f -> f.isAnnotationPresent(CsvVOAttribute.class)).collect(Collectors.toList());
        if (filterFileds.size() > 0) {
            while (scanner.hasNext()) {
                String next = scanner.next();
                List<String> datas = Arrays.asList(next.split(","));
                List<String> dataLineList=new LinkedList<>();
                //值进行trim
                datas.stream().forEach(d->{
                    String trim = d.trim();
                    dataLineList.add(trim);
                });
                String nextReplace = next.replace(",", "").trim();
                if (nextReplace.equals("")){
                    continue;
                }
                T entity = clazz.newInstance();
                for (Field field : filterFileds) {
                    CsvVOAttribute arr = field.getAnnotation(CsvVOAttribute.class);
                    String column = arr.column();
                    int col = getExcelCol(column);
                    String value = dataLineList.get(col);
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType();

                    if (value.contains("%")) {
                        value = value.replaceAll("%", "");
                    }
                    if (String.class == fieldType) {
                        field.set(entity, String.valueOf(value));
                    } else if ((Integer.TYPE == fieldType)
                            || (Integer.class == fieldType)) {
                        field.set(entity, Integer.parseInt(value));
                    } else if ((Long.TYPE == fieldType)
                            || (Long.class == fieldType)) {
                        field.set(entity, Long.valueOf(value));
                    } else if ((Float.TYPE == fieldType)
                            || (Float.class == fieldType)) {
                        field.set(entity, Float.valueOf(value));
                    } else if ((Short.TYPE == fieldType)
                            || (Short.class == fieldType)) {
                        field.set(entity, Short.valueOf(value));
                    } else if ((Double.TYPE == fieldType)
                            || (Double.class == fieldType)) {
                        field.set(entity, Double.valueOf(value));
                    } else if (Character.TYPE == fieldType) {
                        if ((value != null) && (value.length() > 0)) {
                            field.set(entity, Character
                                    .valueOf(value.charAt(0)));
                        }
                    } else if (BigDecimal.class == fieldType) {
                        if ((value != null) && (value.trim().length() > 0)) {
                            field.set(entity, new BigDecimal(value));
                        }
                    } else if (Date.class == fieldType) {
                        if ((value != null) && (value.trim().length() > 0)) {
                            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                            field.set(entity, format.parse(value));
                        }
                    }
                }
                dataList.add(entity);
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("colNames", colNames);
        map.put("dataList", dataList);
        return map;
    }

    /**
     * 将csv中A,B,C,D,E列映射成0,1,2,3
     *
     * @param col
     */
    public static int getExcelCol(String col) {
        col = col.toUpperCase();
        // 从-1开始计算,字母重1开始运算。这种总数下来算数正好相同。
        int count = -1;
        char[] cs = col.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            count += (cs[i] - 64) * Math.pow(26, cs.length - 1 - i);
        }
        return count;
    }
}

