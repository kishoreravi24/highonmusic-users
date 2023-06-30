package com.highonmusic.users.dao;

import com.highonmusic.users.model.Testmodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Testdao extends JpaRepository<Testmodel, Integer> {
}
