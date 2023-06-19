package com.hotelBooking.hotelbooking.user.service;

import com.hotelBooking.hotelbooking.user.entity.Role;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}