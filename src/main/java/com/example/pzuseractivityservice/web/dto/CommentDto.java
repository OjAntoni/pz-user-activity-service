package com.example.pzuseractivityservice.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private long authorId;
    @NotNull
    @NotBlank
    @NotEmpty
    private String content;
    @NotNull
    private UUID articleId;
}
