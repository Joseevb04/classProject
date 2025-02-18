package es.dws.classProject.mappers;

import org.mapstruct.Mapper;

import es.dws.classProject.domain.dtos.UserDTO;
import es.dws.classProject.domain.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(UserEntity userEntity);

}
