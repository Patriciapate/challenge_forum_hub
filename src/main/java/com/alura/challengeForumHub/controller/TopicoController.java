package com.alura.challengeForumHub.controller;

import com.alura.challengeForumHub.dto.TopicoRequestDTO;
import com.alura.challengeForumHub.entity.Topico;
import com.alura.challengeForumHub.service.TopicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService service;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    @PostMapping
    public Topico criar(@RequestBody TopicoRequestDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<Topico> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Topico buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));
    }

    @PutMapping("/{id}")
    public Topico atualizar(@PathVariable Long id, @RequestBody TopicoRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}