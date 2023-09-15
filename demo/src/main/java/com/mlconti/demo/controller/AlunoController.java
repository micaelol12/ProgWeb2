package com.mlconti.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlconti.demo.domain.Aluno;
import com.mlconti.demo.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> alunos = alunoRepository.findAll();
        return ResponseEntity.ok().body(alunos);
    }
}
