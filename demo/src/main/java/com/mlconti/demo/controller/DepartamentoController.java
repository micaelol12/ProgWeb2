package com.mlconti.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlconti.demo.domain.Departamento;
import com.mlconti.demo.domain.Funcionario;
import com.mlconti.demo.repository.DepartamentoRepository;
import com.mlconti.demo.repository.FuncionarioRepository;
import com.mlconti.demo.services.DeptServices;

@RestController
@RequestMapping(value = "/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository deptoRepository;

    @Autowired
    private FuncionarioRepository funcRepository;

    @Autowired
    private DeptServices deptServices;

    @GetMapping
    public ResponseEntity<List<Departamento>> findAll() {
        List<Departamento> departamentos = deptoRepository.findAll();
        return ResponseEntity.ok().body(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Departamento>> findById(@PathVariable Integer id) {
        Optional<Departamento> departamento = deptoRepository.findById(id);

        return ResponseEntity.ok().body(departamento);
    }

    @GetMapping("/{id}/funcionarios")
    public ResponseEntity<List<Funcionario>> findByDepto(@PathVariable Integer id) {
        List<Funcionario> funcionarios = funcRepository.findByDepto(id);
        return ResponseEntity.ok().body(funcionarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delDepto(@PathVariable Integer id) {
        deptServices.delDepartamento(id);

        return ResponseEntity.noContent().build();
    }
}
