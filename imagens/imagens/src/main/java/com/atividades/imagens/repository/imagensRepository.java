package com.seuprojeto.bancoimagens.repository;

import com.seuprojeto.bancoimagens.model.ImagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<ImagemModel, Long> {}
