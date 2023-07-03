package com.example.officebuilding.controller;

import com.example.officebuilding.dao.RoomTypeDAO;
import com.example.officebuilding.dtos.CompanyEmployeeDTO;
import com.example.officebuilding.dtos.RoomTypeDTO;
import com.example.officebuilding.entities.HotelEntity;
import com.example.officebuilding.entities.RoomTypeEntity;
import com.example.officebuilding.service.room_type.IRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api",produces = "application/json")
public class RoomTypeController {
    @Autowired
    private IRoomTypeService roomTypeService;

    @Autowired
    private RoomTypeDAO roomTypeDAO;
    private static final Logger logger = LoggerFactory.getLogger(RoomTypeController.class);

    @PostMapping("/roomType/{id}")
    public ResponseEntity<RoomTypeDTO> createNewRoomType(@PathVariable Integer id, @RequestBody RoomTypeDTO roomTypeDTO){
        logger.error("Unauthorized error. Message - {}", roomTypeDTO);

        return new ResponseEntity<>(roomTypeService.save(roomTypeDTO), HttpStatus.OK);
    }

    @PostMapping("/roomType/hotelID={id}")
    public void insertRoomTypeOfHotel(@PathVariable Integer id, @RequestBody RoomTypeDTO roomTypeDTO){
        logger.error("Unauthorized error. Message - {}", roomTypeDTO);

        roomTypeDAO.insertRoomTypeByHotelId(id,roomTypeDTO);
    }

}
