package com.seuprojeto.bancoimagens.service;

import com.seuprojeto.bancoimagens.model.ImagemModel;
import com.seuprojeto.bancoimagens.repository.ImagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagemService {

    private final ImagemRepository repository;

    public ImagemService(ImagemRepository repository) {
        this.repository = repository;
    }

    public ImagemModel salvar(ImagemModel imagem) {
        return repository.save(imagem);
    }

    public List<ImagemModel> listarTodas() {
        return repository.findAll();
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Optional<ImagemModel> buscarPorId(Long id) {
        return repository.findById(id);
    }
}
