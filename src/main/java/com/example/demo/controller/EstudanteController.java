package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.estudante;
import com.example.demo.service.estudanteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("estudantes")
@AllArgsConstructor
public class EstudanteController {
    
    private estudanteService estudanteService;

    @GetMapping("/{id}")
    public ResponseEntity<estudante> buscarEstudantePorId(@PathVariable Long id) {
        return estudanteService.buscarEstudantePorId(id);
    }

    @GetMapping
    public List<estudante> buscarTodosEstudantes() {
        return estudanteService.buscarTodosEstudantes();
    }

    @PostMapping
    public ResponseEntity<estudante> cadastrarEstudante(@RequestBody estudante estudante) {
        return estudanteService.cadastrarEstudante(estudante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<estudante> atualizarEstudante(@PathVariable Long id, @RequestBody estudante estudante) {
        return estudanteService.atualizarEstudante(estudante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerEstudante(@PathVariable Long id) {
            return estudanteService.removerEstudante(id);
    }
}
