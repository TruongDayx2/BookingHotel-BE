package com.hotelBooking.hotelbooking.respositories;

// như là kho / nơi chứa data lưu về từ database hay memory

import com.hotelBooking.hotelbooking.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findByRoomName(String roomName);
}
