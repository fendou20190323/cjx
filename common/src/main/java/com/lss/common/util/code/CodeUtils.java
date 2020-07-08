package com.lss.common.util.code;

import com.google.common.base.Strings;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类型 + 时间 + id/随机数
 */
public class CodeUtils {


  private static final ReentrantLock reentrantLock = new ReentrantLock();



  /**
   * 生成时间信息
   *
   * @return
   */
  public static String getDateTime(Date date) {
    DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
    return format.format(date);
  }
/**
   * 生成时间信息到毫秒
   *
   * @returns
   */
  public static String getDateMilliscond(Date date) {
    DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    return format.format(date);
  }

  /**
   * 生成时间信息带毫秒数
   *
   * @return
   */
  public static String getDateTimeInMillis(Date date) {
    DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssS");
    return format.format(date);
  }


  /**
   * 生成固定长度的随机码
   * @param n 长度
   * @return
   */
  private static String getRandom2(int n) {
    return RandomStringUtils.random(n);
  }

  /**
   * 生成固定长度的随机字母
   * @param n
   * @return
   */
  public static String getRandomLetter(int n){
    return RandomStringUtils.random(n,true,false);
  }

  /**
   * 生成固定长度的随机数字
   * @param n
   * @return
   */
  public static String getRandomInt(int n){
    return RandomStringUtils.random(n,false,true);
  }


  /**
   * 用户code
   * @param userId
   * @param date
   * @return
   */
  public static String getUserCode(String userId,Date date) {
    StringBuilder string = new StringBuilder();
    string.append(getDateTime(date));
    string.append(userId.replaceAll("-", "").substring(0, 12));
    string.append(getRandom2(7));
    return string.toString().toUpperCase();
  }


  /**
   * 生成code
   * @param typeCode 规则
   * @param id
   * @param date 时间
   * @return
   */
  public static String getCode(String typeCode,String id,Date date){
    StringBuilder string = new StringBuilder();
    string.append(typeCode);
    string.append(getDateTime(date));
    if(Strings.isNullOrEmpty(id)){
      string.append(getRandom2(19-typeCode.length()));
    }else {
      string.append(id.replaceAll("-", "").substring(0, 12-typeCode.length()));
      string.append(getRandom2(7));
    }
    return string.toString();
  }


  /****
   *
   * @param types 按顺序排列规则
   * @param dateFormat 时间格式 没有空格和特殊符号
   * @return
   */
  public static String getCodeByRule(LinkedList<String> types, String dateFormat, SerialNumberInterface serialNumberReositores){
    StringBuffer string = new StringBuffer();
    Date date = new Date();
    types.forEach(t ->{
      string.append(t);
    });
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
    string.append(simpleDateFormat.format(date));
       /**防止流水号重复添加锁*/
    reentrantLock.lock();
    try {
      /**用string.tostring从mongodb中获取值*/
      LinkedList<String> list = serialNumberReositores.findBykey(string.toString());
      String value = "0";
      String id = null;
      if(list != null && !list.isEmpty()){
        id = list.get(0);
        value = list.get(1);
      }

      /**获取v的整数类型并且+1*/
      Integer v = Integer.parseInt(value) + 1;
      /**流水号格式化值*/
      String format = String.format("%05d",v);

      
      Serial serial = new Serial();
      serial.setId(id);
      serial.setSerialNum(format);
      serial.setSerialNumberKey(string.toString());
      serial.setUpdateTime(new Date());
      serialNumberReositores.save(serial);
      /**拼装参数*/
      string.append(format);
    }finally {
      reentrantLock.unlock();
    }

    return string.toString();
  }










}
