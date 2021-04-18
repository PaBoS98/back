package com.intensive.Repository;

import com.intensive.dto.UserDto;
import com.intensive.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
