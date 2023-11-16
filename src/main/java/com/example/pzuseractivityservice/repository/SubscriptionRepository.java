package com.example.pzuseractivityservice.repository;

import com.example.pzuseractivityservice.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {
    List<Subscription> findAllByUserId(long id);
    List<Subscription> findAllByTopicId(UUID id);

    boolean existsByTopicIdAndUserId(UUID topic, long user);
    Subscription findByTopicIdAndUserId(UUID topic, long user);
}
