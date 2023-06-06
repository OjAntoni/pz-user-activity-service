package com.example.pzuseractivityservice.service;

import com.example.pzuseractivityservice.model.Subscription;
import com.example.pzuseractivityservice.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionService {
    private SubscriptionRepository subscriptionRepository;

    public Subscription save(Subscription c){
        return subscriptionRepository.save(c);
    }

    public void delete(UUID id){
        subscriptionRepository.deleteById(id);
    }

    public List<Subscription> getAll(UUID userId){
        return subscriptionRepository.findAllByUserId(userId);
    }
}
