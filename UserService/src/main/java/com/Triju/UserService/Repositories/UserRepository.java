package com.Triju.UserService.Repositories;

import com.Triju.UserService.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
