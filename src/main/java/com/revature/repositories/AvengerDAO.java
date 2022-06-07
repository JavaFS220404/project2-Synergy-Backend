package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Avenger;

public interface AvengerDAO extends JpaRepository<Avenger, Integer>{

	public Optional<List<Avenger>> findBySuperheroName(String name);
}
