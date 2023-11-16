package com.example.pzuseractivityservice.web;

import com.example.pzuseractivityservice.model.Subscription;
import com.example.pzuseractivityservice.service.SubscriptionService;
import com.example.pzuseractivityservice.web.dto.SubscriptionDto;
import com.example.pzuseractivityservice.web.mapper.SubscriptionMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/subscription")
@AllArgsConstructor
public class SubscriptionResource {
    private SubscriptionService subscriptionService;
    private SubscriptionMapper subscriptionMapper;


    @GetMapping
    public ResponseEntity<?> getSubsForUser(@RequestParam long userId){
        List<Subscription> all = subscriptionService.getAll(userId);
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createNewSub(@RequestBody SubscriptionDto dto){
        Subscription subscription = subscriptionMapper.toEntity(dto);
        Subscription save = subscriptionService.save(subscription);
        return new ResponseEntity<>(save,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSub(@PathVariable UUID id){
        subscriptionService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id){
        return new ResponseEntity<>(subscriptionService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getByTopicId(@RequestParam UUID topicId){
        return new ResponseEntity<>(subscriptionService.getAllByTopic(topicId), HttpStatus.OK);
    }
}
