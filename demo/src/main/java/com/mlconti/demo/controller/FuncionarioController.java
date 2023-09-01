package com.mlconti.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mlconti.demo.domain.Funcionario;
import com.mlconti.demo.repository.FuncionarioRepository;
import com.mlconti.demo.services.FuncServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcRrepository;

    @Autowired
    private FuncServices funcServices;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        funcServices.delFunct(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id_depto}")
    public ResponseEntity<Funcionario> insFunc(@PathVariable Integer id_depto,
            @Valid @RequestBody Funcionario pFuncionario) {
        Funcionario novoFuncionario = funcServices.insFunc(pFuncionario, id_depto);

        URI vUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(novoFuncionario.getId_funcionario()).toUri();

        return ResponseEntity.created(vUri).body(novoFuncionario);
    }

}
