package com.example.officebuilding.controller;

import com.example.officebuilding.dtos.InfoDTO;
import com.example.officebuilding.dtos.OrderDTO;
import com.example.officebuilding.service.info.IInfoService;
import com.example.officebuilding.service.order.IOrderService;
import com.example.officebuilding.service.room.IRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api",produces = "application/json")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IInfoService infoService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping("/user/order/create")
    public ResponseEntity<OrderDTO> createNewOrder(@RequestBody OrderDTO orderDTO){
        return new ResponseEntity<>(orderService.save(orderDTO), HttpStatus.OK);
    }

    @GetMapping("/user/order/userId/{id}")
    public ResponseEntity<List<OrderDTO>> getOrderByUserId(@PathVariable Integer id){
        logger.error("Unauthorized error. Message - {}", id);

        List<OrderDTO> orderDTOs = orderService.getOrdersByUserId(id);
        logger.error("Unauthorized error. Message - {}", orderDTOs);

        return new ResponseEntity<>(orderDTOs,HttpStatus.OK);
    }

//    @GetMapping("/user/order/userId/{id}")
//    public ResponseEntity<Map<String, Object>> getInfoAndOrderById
}
