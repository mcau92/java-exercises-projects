package com.cauduro.performer.nandi.models;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

	
	private String userId;
	@NonNull
	private String name;
	@NonNull
	private String surname;
	private String cf;
	private LocalDate dateOfBirth;
	private String placeOfBirth;
	
	
	
}
