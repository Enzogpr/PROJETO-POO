package com.fag.infra.testdb;

import java.util.ArrayList;
import java.util.List;

import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserRepository;

public class UserTestDBRepository implements IUserRepository {

    List<UserAccountDTO> userAccounts = new ArrayList<>();

    @Override
    public UserAccountDTO createUser(UserAccountDTO dto) {
        userAccounts.add(dto);

        return dto;
    }

    @Override
    public UserAccountDTO findUserBy(String document) {
        for(UserAccountDTO user : userAccounts){
        if (user.getDocument().equals(document)){
            return user;
        }
        }
        return null;
    }

}
