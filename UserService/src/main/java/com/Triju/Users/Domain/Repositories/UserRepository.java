package com.Triju.Users.Domain.Repositories;

import com.Triju.Users.Domain.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
