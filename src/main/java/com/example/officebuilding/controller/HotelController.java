package com.example.officebuilding.controller;

import com.example.officebuilding.dtos.HotelDTO;
import com.example.officebuilding.service.hotel.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/hotel", produces = "application/json")
public class HotelController {
    @Autowired
    private IHotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDTO> createNewHotel(@RequestBody HotelDTO hotelDTO){
        return new ResponseEntity<>(hotelService.save(hotelDTO), HttpStatus.OK);
    }
}
