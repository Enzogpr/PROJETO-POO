package com.fag.service;

import java.util.UUID;

import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserInterface;
import com.fag.domain.repositories.IUserRepository;

public class UserService {
    
    private IUserInterface userInterface;

    private IUserRepository userRepository;

    public UserService(IUserInterface userInterface, IUserRepository userRepository) {
        this.userInterface = userInterface;
        this.userRepository = userRepository;
    }


}
