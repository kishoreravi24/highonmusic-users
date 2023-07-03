package com.highonmusic.users.dao;

import com.highonmusic.users.dto.AuthenticationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usersdao extends JpaRepository<AuthenticationDto,String>{
    boolean existsByUsernameAndPassword(String username, String password);
}
