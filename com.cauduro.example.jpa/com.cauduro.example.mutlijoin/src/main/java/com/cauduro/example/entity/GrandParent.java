package com.cauduro.example.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GrandParent implements Serializable {

  /** */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer gid;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "grandparent")
  private Set<Parent> parents;

  public Integer getGid() {
    return gid;
  }

  public void setGid(Integer gid) {
    this.gid = gid;
  }

  public Set<Parent> getParents() {
    return parents;
  }

  public void setParents(Set<Parent> parents) {
    this.parents = parents;

    if (this.parents == null) {
      this.parents = new HashSet<>();
    }
    if (parents != null) {
      this.parents.addAll(parents);
      // set bidirectional association
      for (Parent parent : this.parents) {
        parent.setGrandparent(this);
      }
    }
  }
}
