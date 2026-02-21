package com.alura.challengeForumHub.service;

import com.alura.challengeForumHub.dto.TopicoRequestDTO;
import com.alura.challengeForumHub.entity.Topico;
import com.alura.challengeForumHub.repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository) {
        this.repository = repository;
    }

    public Topico criar(TopicoRequestDTO dto) {
        Topico topico = new Topico(
                dto.titulo(),
                dto.mensagem(),
                dto.autor(),
                dto.curso()
        );
        return repository.save(topico);
    }

    public List<Topico> listar() {
        return repository.findAll();
    }

    public Optional<Topico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Topico atualizar(Long id, TopicoRequestDTO dto) {
        Topico topico = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));

        topico.setTitulo(dto.titulo());
        topico.setMensagem(dto.mensagem());
        topico.setAutor(dto.autor());
        topico.setCurso(dto.curso());

        return repository.save(topico);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}