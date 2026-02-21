package com.alura.challengeForumHub.repository;

import com.alura.challengeForumHub.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}