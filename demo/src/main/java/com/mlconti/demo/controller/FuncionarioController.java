package com.mlconti.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlconti.demo.domain.Funcionario;
import com.mlconti.demo.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    FuncionarioRepository funcRrepository;

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {
        List<Funcionario> funcionarios = funcRrepository.findAll();

        return ResponseEntity.ok().body(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Funcionario>> findByID(@PathVariable Integer id) {
        Optional<Funcionario> funcionario = funcRrepository.findById(id);

        return ResponseEntity.ok().body(funcionario);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Funcionario>> findByName(@PathVariable String nome) {
        List<Funcionario> funcionarios = funcRrepository.findByName(nome);

        return ResponseEntity.ok().body(funcionarios);
    }

}
