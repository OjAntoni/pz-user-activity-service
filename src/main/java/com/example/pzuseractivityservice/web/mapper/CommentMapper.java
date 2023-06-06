package com.example.pzuseractivityservice.web.mapper;

import com.example.pzuseractivityservice.model.Comment;
import com.example.pzuseractivityservice.web.dto.CommentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment toEntity(CommentDto dto);
}
