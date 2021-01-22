package com.cauduro.performer.nandi.mapping;

import java.sql.SQLException;
import java.util.Base64;
import java.util.Objects;
import org.mapstruct.Mapper;
import com.cauduro.performer.nandi.entity.UserEntity;
import com.cauduro.performer.nandi.models.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapping {

  UserModel toModel(UserEntity user);

  UserEntity toEntity(UserModel user);

  public static byte[] toBlob(String s) {
    if (Objects.nonNull(s)) {
      if (s.contains("data:image/jpeg;base64,")) {
        s = s.replace("data:image/jpeg;base64,", "");
      }
      return s.getBytes();
    } else return null;
  }

  public static String toString(byte[] b) throws SQLException {
    if (Objects.nonNull(b)) {
      return Base64.getEncoder().encodeToString(b);
    } else return null;
  }
}
