package com.highonmusic.users.dao;

import com.highonmusic.users.dto.TestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Testdao extends JpaRepository<TestDto, Integer> {
}
