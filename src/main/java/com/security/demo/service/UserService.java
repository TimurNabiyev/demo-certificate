package com.security.demo.service;

import com.security.demo.model.dto.UserDto;

public interface UserService {
    UserDto create(UserDto userDto);
    UserDto getOne(Long id);
}
