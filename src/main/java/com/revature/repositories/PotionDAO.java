package com.revature.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Potion;

public interface PotionDAO extends JpaRepository<Potion, String>{

}
