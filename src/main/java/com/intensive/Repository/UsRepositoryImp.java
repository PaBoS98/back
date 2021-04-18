package com.intensive.Repository;

import com.intensive.dto.UserDto;
import com.intensive.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsRepositoryImp implements UsRepository {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity addToDB(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
