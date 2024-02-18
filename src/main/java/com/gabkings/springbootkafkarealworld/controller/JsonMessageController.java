package com.gabkings.springbootkafkarealworld.controller;


import com.gabkings.springbootkafkarealworld.kafka.JsonKafkaProducer;
import com.gabkings.springbootkafkarealworld.payLoad.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessge(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
