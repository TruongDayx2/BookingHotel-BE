package com.hotelBooking.hotelbooking.controllers;

import com.hotelBooking.hotelbooking.models.ResponseObject;
import com.hotelBooking.hotelbooking.models.Room;
import com.hotelBooking.hotelbooking.respositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.rmi.ServerException;
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
        try {
            Optional<Room> foundRoom = repository.findById(id);
            return foundRoom.isPresent() ?
                    ResponseEntity.status(HttpStatus.OK).body(
                            new ResponseObject(200,"Query room successfully",foundRoom)
                    ):
                    ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                            new ResponseObject(404,"Cannot find room with id = "+id,"")
                    );
        }catch (Exception err){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject(500,err.getMessage(),"")
            );
        }

    }
    //POST - insert Room ======================================================================
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertRoom(@RequestBody Room newRoom){
        // Check same name room
        try {
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
        }catch (Exception err){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject(500,err.getMessage(),"")
            );
        }

    }
    //PUT - upsert Room ~ update if found else insert room  ==========================================
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Room newRoom,@PathVariable long id){
        try {
            Room updateRoom = repository.findById(id)
                    .map(room ->{
                        room.setRoomName(newRoom.getRoomName());
                        room.setPrice(newRoom.getPrice());
                        room.setUrl(newRoom.getUrl());
                        return repository.save(room);
                    }).orElseGet(()->{
                        newRoom.setId(id);
                        return repository.save(newRoom);
                    });
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(201,"Update Room successfully",updateRoom)
            );
        }catch (Exception err){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject(500,err.getMessage(),"")
            );
        }
    }
    //DELETE - delete Room ======================================================================
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id){
        try {
            boolean exists = repository.existsById(id);
            if (exists){
                repository.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject(200,"Delete room with id = "+id+" successfully","")
                );
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject(404,"Cannot find room with id = "+id,"")
                );
            }
        }catch (Exception err){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject(500,err.getMessage(),"")
            );
        }

    }

}
