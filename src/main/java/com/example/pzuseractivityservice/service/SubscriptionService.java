package com.example.pzuseractivityservice.service;

import com.example.pzuseractivityservice.model.Subscription;
import com.example.pzuseractivityservice.repository.SubscriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
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

    public Subscription getById(UUID id){
        return subscriptionRepository.findById(id).orElse(null);
    }
}
