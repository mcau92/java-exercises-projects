package com.cauduro.example.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@IdClass(ParentFk.class)
public class Parent implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer pid;

  @Id
  @ManyToOne
  @JoinColumn(name = "gid", referencedColumnName = "gid")
  private GrandParent grandparent;

  @Id
  @Column(name = "fk2")
  private String fk2;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "parent")
  private Set<Child> childs;

  // ---------------------//
  public void setChilds(Set<Child> childs) {
    if (this.childs == null) {
      this.childs = new HashSet<>();
    }
    if (childs != null) {
      this.childs.addAll(childs);
      // set bidirectional association
      for (Child child : this.childs) {
        child.setParent(this);
      }
    }
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

  public Set<Child> getChilds() {
    return childs;
  }

  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }
}
