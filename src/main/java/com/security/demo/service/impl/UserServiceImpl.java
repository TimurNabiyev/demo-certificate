package com.security.demo.service.impl;

import com.security.demo.mapper.UserMapper;
import com.security.demo.model.dto.UserDto;
import com.security.demo.model.entity.User;
import com.security.demo.repository.UserRepository;
import com.security.demo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto create(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);

        return userMapper.toDto(user);
    }

    @Override
    public UserDto getOne(Long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }
}
