package com.seuprojeto.bancoimagens.model;

import jakarta.persistence.*;

@Entity
@Table(name = "imagens")
public class ImagemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String url;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
