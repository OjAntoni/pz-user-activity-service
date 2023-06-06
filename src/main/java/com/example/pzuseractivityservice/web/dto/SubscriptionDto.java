package com.example.pzuseractivityservice.web.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class SubscriptionDto {
    @NotNull
    private UUID userId;
    @NotNull
    private UUID topicId;
}
