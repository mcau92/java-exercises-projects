package com.cauduro.performer.nandi.models;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

  private Integer userId;
  private String name;
  private String surname;
  private String cf;
  private LocalDate dateOfBirth;
  private String placeOfBirth;
}
