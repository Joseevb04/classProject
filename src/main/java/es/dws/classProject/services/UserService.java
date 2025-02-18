package es.dws.classProject.services;

import java.util.List;

import es.dws.classProject.domain.dtos.UserDTO;
import es.dws.classProject.domain.entities.UserEntity;

public interface UserService {

    List<UserDTO> getUsers();

    UserDTO getUserById(Long id);

    UserEntity getUserEntityById(Long id);

}
