package com.fendou.module.main;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlGenerator {
    private static final Logger logger = LoggerFactory.getLogger(SqlGenerator.class);
    public static final Map<String, String> typeMap = new HashMap<String, String>();


    public static void main(String[] args) {
        //实体类所在的package在磁盘上的绝对路径
        String packageName = "E:\\ideawork\\cjx0323\\springtest\\src\\main\\java\\com\\fendou\\module\\generateSqlModel";
        //生成sql的文件夹
        String filePath = "E:\\create\\";
        //项目中实体类的路径
        String prefix = "com.fendou.module.generateSqlModel.";
        String className = "";

        StringBuffer sqls = new StringBuffer();
        //获取包下的所有类名称
        List<String> list = getAllClasses(packageName);
        for (String str : list) {
            className = prefix + str.substring(0, str.lastIndexOf("."));
            String sql = generateSql(className, filePath);
            sqls.append(sql);
        }
        System.out.println(sqls.toString());
        StringToSql(sqls.toString(), filePath + "report.sql");

    }

    /**
     * 根据实体类生成建表语句
     *
     * @param className 全类名
     * @param filePath  磁盘路径  如 : d:/workspace/
     * @author
     * @date 2018年4月11日
     */
    public static String generateSql(String className, String filePath) {
        try {
            Class<?> clz = Class.forName(className);
            ApiModel ann = clz.getAnnotation(ApiModel.class);
            className = clz.getSimpleName();
            String tableName = generatorTableName(className);
            Field[] fields = clz.getDeclaredFields();
            StringBuffer column = new StringBuffer();
            String postSql = "";
            for (Field f : fields) {
                String fileComment = "'" + f.getAnnotation(ApiModelProperty.class).value() + "',";
                String type = f.getGenericType().getTypeName();
                switch (type) {
                    case "java.lang.String":
                        if (f.getName().equals("id")) {
                            postSql = "varchar(36) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT " + fileComment;
                        } else if (f.getName().toLowerCase().contains("id")&&f.getName().length()>2){
                            postSql = "varchar(36) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT" + fileComment;
                        }else {
                            postSql = "varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT" + fileComment;
                        }
                        break;
                    case "java.sql.Timestamp":
                        postSql = "timestamp NULL DEFAULT NULL COMMENT " + fileComment;
                        break;
                    case "java.lang.Integer":
                        postSql = " int(11) DEFAULT NULL COMMENT " + fileComment;
                        break;
                    case "java.lang.Boolean":
                        postSql = "tinyint(1) DEFAULT NULL COMMENT" + fileComment;
                        break;
                    case "java.util.Date":
                        postSql = "datetime DEFAULT NULL COMMENT" + fileComment;
                        break;
                    case "java.math.BigDecimal":
                        postSql = "decimal(10,2) DEFAULT NULL COMMENT" + fileComment;
                        break;
                    default:
                        break;
                }
                column.append(" \n `" + f.getName() + "`").append(postSql);
            }
            StringBuffer sql = new StringBuffer();
            sql
//                 .append("\n DROP TABLE IF EXISTS `"+tableName+"`; ")
                    .append(" \n CREATE TABLE `" + tableName + "`  (")
//            .append(" \n `id` int(11) NOT NULL AUTO_INCREMENT,")
                    .append(" \n " + column)
                    .append(" \n PRIMARY KEY (`id`) USING BTREE")
//            .append("\n INDEX `id`(`id`) USING BTREE")
                    .append(" \n ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='" + ann.description() + "';");
            return sql.toString();
        } catch (ClassNotFoundException e) {
            logger.debug("该类未找到！");
            return null;
        }

    }

    /**
     * 获取包下的所有类名称,获取的结果类似于 XXX.java
     *
     * @param packageName
     * @return
     * @author
     * @date 2018年4月11日
     */
    public static List<String> getAllClasses(String packageName) {
        List<String> classList = new ArrayList<String>();
        String className = "";
        File f = new File(packageName);
        if (f.exists() && f.isDirectory()) {
            File[] files = f.listFiles();
            for (File file : files) {
                className = file.getName();
                classList.add(className);
            }
            return classList;
        } else {
            logger.debug("包路径未找到！");
            return null;
        }
    }

    /**
     * 将string 写入sql文件
     *
     * @param str
     * @param path
     * @author
     * @date 2018年4月11日
     */
    public static void StringToSql(String str, String path) {
        byte[] sourceByte = str.getBytes();
        if (null != sourceByte) {
            try {
                File file = new File(path);     //文件路径（路径+文件名）
                if (!file.exists()) {   //文件不存在则创建文件，先创建目录
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                FileOutputStream outStream = new FileOutputStream(file);    //文件输出流用于将数据写入文件
                outStream.write(sourceByte);
                outStream.flush();
                outStream.close();  //关闭文件输出流
                System.out.println("生成成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String generatorTableName(String className) {
        StringBuilder sb = new StringBuilder();
        char[] chars = className.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                if (i > 0) {
                    sb.append("_");
                }
                chars[i] += 32;
            }

            sb.append(String.valueOf(chars[i]));
        }
        return sb.toString();
    }
}