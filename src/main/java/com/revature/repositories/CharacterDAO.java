package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Character;

public interface CharacterDAO extends JpaRepository<Character, Integer>{

	Optional<List<Character>> findByHogwartsHouse(String hogwartsHouse);

	Optional<List<Character>> findByHogwartsStudent(boolean hogwartsStudent);

}
