package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Favourites;
import com.revature.models.Trainer;
import com.revature.models.User;



public interface FavouriteDAO extends JpaRepository<Favourites, Integer> {

	List<Favourites> findByUserId(int userId);
}
