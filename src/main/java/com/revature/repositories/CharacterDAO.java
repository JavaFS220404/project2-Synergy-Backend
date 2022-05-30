package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Character;

public interface CharacterDAO extends JpaRepository<Character, Integer>{

}
