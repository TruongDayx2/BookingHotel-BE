package com.hotelBooking.hotelbooking.user.service;

import com.hotelBooking.hotelbooking.user.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}
