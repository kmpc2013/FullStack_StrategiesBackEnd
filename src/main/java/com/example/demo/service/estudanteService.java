package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.estudante;

@Service
public class estudanteService {
    private static Map<Long, estudante> listaEstudantes = new HashMap<>();
    
    public ResponseEntity<estudante> buscarEstudantePorId(Long id) {
        estudante estudante = listaEstudantes.get(id);
        if (estudante == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(estudante);
    }

    public List<estudante> buscarTodosEstudantes() {
        return new ArrayList<>(listaEstudantes.values());
    }

    public ResponseEntity<estudante> cadastrarEstudante(estudante estudante) {
        listaEstudantes.put(estudante.getId(), estudante);
        return ResponseEntity.status(HttpStatus.OK).body(estudante);
    }

    public ResponseEntity<estudante> atualizarEstudante(estudante estudante) {
        estudante estudanteEncontrado = listaEstudantes.get(estudante.getId());
        if (estudanteEncontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        listaEstudantes.put(estudante.getId(), estudante);
        return ResponseEntity.status(HttpStatus.OK).body(estudanteEncontrado);
    }

    public ResponseEntity<String> removerEstudante(Long id) {
        estudante estudanteEncontrado = listaEstudantes.get(id);
        if (estudanteEncontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        listaEstudantes.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body("Estudante deletado com sucesso");
    }



}
