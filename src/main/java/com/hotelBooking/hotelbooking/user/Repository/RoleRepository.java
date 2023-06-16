package com.hotelBooking.hotelbooking.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelBooking.hotelbooking.user.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
  Role findByName(String Name);
}
