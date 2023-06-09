package com.hotelBooking.hotelbooking.controllers;

import com.hotelBooking.hotelbooking.models.ResponseObject;
import com.hotelBooking.hotelbooking.models.Room;
import com.hotelBooking.hotelbooking.respositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Rooms")
public class RoomController {

    @Autowired // doi tuong repository se duoc tao ra khi app ta khoi dong/ tao 1 lan roi su dung
    private RoomRepository repository;

    @GetMapping("")
    List<Room> getAllRooms(){
        return repository.findAll();
    }
    //GET - get detail Room ======================================================================
    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id){
        Optional<Room> foundRoom = repository.findById(id);
        return foundRoom.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject(200,"Query product successfully",foundRoom)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject(404,"Cannot find product with id = "+id,"")
                );
    }
    //POST - insert Room ======================================================================
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertRoom(@RequestBody Room newRoom){
        // Check same name room
        List<Room> foundRooms = repository.findByRoomName(newRoom.getRoomName().trim());
        if (foundRooms.size() > 0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject(400,"Room name already taken","")
            );
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(201,"Insert Room successfully",repository.save(newRoom))
            );
        }
    }
}
