package com.lss.common.util.code;

import java.util.LinkedList;

public interface SerialNumberInterface {

  /***
   *
   * @param serialNumberKey
   * @return id 和 serialNum
   */
  LinkedList<String> findBykey(String serialNumberKey);

  /**
   *
   * @param serial
   */
  void save(Serial serial);

}
