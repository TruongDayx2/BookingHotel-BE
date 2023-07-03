package com.example.officebuilding.repository;

import com.example.officebuilding.entities.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomTypeRepository extends JpaRepository<RoomTypeEntity, Integer> {

}
