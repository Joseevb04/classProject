package es.dws.classProject.services;

import es.dws.classProject.domain.dtos.UserDTO;
import es.dws.classProject.domain.entities.UserEntity;

public interface UserService {

    UserDTO getUserById(Long id);

    UserEntity getUserEntityById(Long id);

}
