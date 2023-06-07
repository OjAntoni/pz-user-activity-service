package com.example.pzuseractivityservice.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {
    @NotNull
    private UUID userId;
    @NotNull
    private UUID topicId;
}
