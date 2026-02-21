package com.alura.challengeForumHub.dto;

public record TopicoRequestDTO(
        String titulo,
        String mensagem,
        String autor,
        String curso
) {}
