package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.revature.models.UserDetails;

public interface UserDetailsDAO extends JpaRepository<UserDetails, Integer> {

}
