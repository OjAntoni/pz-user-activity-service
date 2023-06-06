package com.example.pzuseractivityservice.web.mapper;

import com.example.pzuseractivityservice.model.Comment;
import com.example.pzuseractivityservice.model.Subscription;
import com.example.pzuseractivityservice.web.dto.SubscriptionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    Subscription toEntity(SubscriptionDto dto);
}
