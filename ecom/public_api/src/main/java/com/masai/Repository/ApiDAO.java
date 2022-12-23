package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.masai.model.Myapi;

public interface ApiDAO extends JpaRepository<Myapi,Integer> {
	
}
