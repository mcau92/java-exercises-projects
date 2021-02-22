package com.cauduro.example.entity;

import java.io.Serializable;

public class ParentFk implements Serializable {

  /** */
  private static final long serialVersionUID = 1L;

  private Integer pid;

  private GrandParent grandparent;

  private String fk2;

  public ParentFk() {}

  public ParentFk(Integer pid, GrandParent grandparent, String fk2) {
    this.pid = pid;
    this.grandparent = grandparent;
    this.fk2 = fk2;
  }

  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public GrandParent getGrandparent() {
    return grandparent;
  }

  public void setGrandparent(GrandParent grandparent) {
    this.grandparent = grandparent;
  }

  public String getFk2() {
    return fk2;
  }

  public void setFk2(String fk2) {
    this.fk2 = fk2;
  }
}
