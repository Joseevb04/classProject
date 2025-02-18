package es.dws.classProject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.dws.classProject.domain.dtos.UserDTO;
import es.dws.classProject.domain.entities.UserEntity;
import es.dws.classProject.mappers.UserMapper;
import es.dws.classProject.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Could not find User by the ID: %d".formatted(id)));
    }

    @Override
    public UserEntity getUserEntityById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not find User by the ID: %d".formatted(id)));
    }

}
