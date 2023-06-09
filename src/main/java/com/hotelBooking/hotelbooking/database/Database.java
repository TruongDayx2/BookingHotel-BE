package com.hotelBooking.hotelbooking.database;

import com.hotelBooking.hotelbooking.models.Room;
import com.hotelBooking.hotelbooking.respositories.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Database test truoc khi ket noi voi database:mysql,mongodb

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean // bean method chay ngay khi app chay
    CommandLineRunner initDatabase(RoomRepository roomRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Room room1 = new Room("T01",700.0,"");
                Room room2 = new Room("T02",700.0,"");
                logger.info("Insert Data: "+roomRepository.save(room1));
                logger.info("Insert Data: "+roomRepository.save(room2));

            }
        };
    }
}
