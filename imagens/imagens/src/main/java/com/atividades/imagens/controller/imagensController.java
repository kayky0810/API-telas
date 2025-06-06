package com.seuprojeto.bancoimagens.controller;

import com.seuprojeto.bancoimagens.model.ImagemModel;
import com.seuprojeto.bancoimagens.service.ImagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imagens")
@CrossOrigin(origins = "*") // Permite acesso do front-end
public class ImagemController {

    private final ImagemService service;

    public ImagemController(ImagemService service) {
        this.service = service;
    }

    @PostMapping
    public ImagemModel adicionarImagem(@RequestBody ImagemModel imagem) {
        return service.salvar(imagem);
    }

    @GetMapping
    public List<ImagemModel> listarImagens() {
        return service.listarTodas();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerImagem(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImagemModel> editarImagem(@PathVariable Long id, @RequestBody ImagemModel novaImagem) {
        return service.buscarPorId(id)
                .map(imagem -> {
                    imagem.setNome(novaImagem.getNome());
                    imagem.setUrl(novaImagem.getUrl());
                    ImagemModel imagemAtualizada = service.salvar(imagem);
                    return ResponseEntity.ok(imagemAtualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
