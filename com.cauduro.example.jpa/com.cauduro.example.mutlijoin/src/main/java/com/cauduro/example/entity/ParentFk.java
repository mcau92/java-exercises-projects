package com.cauduro.example.entity;

import java.io.Serializable;

public class ParentFk implements Serializable {

  /** */
  private static final long serialVersionUID = 1L;

  private Integer pid;

  private Integer gid;

  private String fk2;

  public ParentFk() {}

  public ParentFk(Integer pid, Integer gid, String fk2) {
    this.pid = pid;
    this.gid = gid;
    this.fk2 = fk2;
  }

  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public Integer getGid() {
    return gid;
  }

  public void setGid(Integer gid) {
    this.gid = gid;
  }

  public String getFk2() {
    return fk2;
  }

  public void setFk2(String fk2) {
    this.fk2 = fk2;
  }
}
