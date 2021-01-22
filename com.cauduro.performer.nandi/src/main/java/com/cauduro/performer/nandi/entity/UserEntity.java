package com.cauduro.performer.nandi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER_NANDI")
@Getter
@Setter
public class UserEntity {

  @Id
  @GeneratedValue
  @Column(name = "USERID")
  private Integer userId;

  @Column(name = "NAME")
  private String name;

  @Column(name = "SURNAME")
  private String surname;

  @Column(name = "CF")
  private String cf;

  @Lob
  @Column(name = "IMAGEMODEL")
  private byte[] imageModel;
}
