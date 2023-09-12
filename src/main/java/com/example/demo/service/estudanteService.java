package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.estudante;

public class estudanteService {
    private static Map<Long, estudante> listaEstudantes = new HashMap<>();
    
    private ResponseEntity<estudante> buscarEstudantePorId(Long id) {
        estudante estudante = listaEstudantes.get(id);
        if (estudante == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(estudante);
    }

    private List<estudante> buscarTodosEstudantes() {
        return new ArrayList<>(listaEstudantes.values());
    }

    private ResponseEntity<estudante> cadastrarEstudante(estudante estudante) {
        estudante estudanteEncontrado = listaEstudantes.get(estudante.getId());
        if (estudanteEncontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(estudanteEncontrado);
    }

    private ResponseEntity<estudante> atualizarEstudante(estudante estudante) {
        estudante estudanteEncontrado = listaEstudantes.get(estudante.getId());
        if (estudanteEncontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        listaEstudantes.put(estudante.getId(), estudante);
        return ResponseEntity.status(HttpStatus.OK).body(estudanteEncontrado);
    }

    private ResponseEntity<String> deletarEstudante(Long id) {
        estudante estudanteEncontrado = listaEstudantes.get(id);
        if (estudanteEncontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        listaEstudantes.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body("Estudante deletado com sucesso");
    }



}
