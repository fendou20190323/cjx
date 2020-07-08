package com.lss.common.util.code;

import java.util.Date;

public class Serial {

  private String id;
  private String serialNumberKey;
  private String serialNum;
  private Date updateTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSerialNumberKey() {
    return serialNumberKey;
  }

  public void setSerialNumberKey(String serialNumberKey) {
    this.serialNumberKey = serialNumberKey;
  }

  public String getSerialNum() {
    return serialNum;
  }

  public void setSerialNum(String serialNum) {
    this.serialNum = serialNum;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}
