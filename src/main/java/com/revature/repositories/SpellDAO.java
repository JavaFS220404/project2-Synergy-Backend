package com.revature.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Spell;

public interface SpellDAO extends JpaRepository<Spell, String>{

}
