package com.spring.web.repo;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.web.dao.GitUser;

public interface Repo extends JpaRepository<Integer, Id> {

	void save(GitUser user);

	

}
