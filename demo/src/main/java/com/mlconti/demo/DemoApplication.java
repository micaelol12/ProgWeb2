package com.mlconti.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mlconti.demo.domain.Departamento;
import com.mlconti.demo.domain.Funcionario;
import com.mlconti.demo.repository.DepartamentoRepository;
import com.mlconti.demo.repository.FuncionarioRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(
			DepartamentoRepository deptoRep,
			FuncionarioRepository funcRep) {
		return (args) -> {
			Departamento depto1 = new Departamento(null, "Finanças");
			Departamento depto2 = new Departamento(null, "Produção");

			deptoRep.save(depto1);
			deptoRep.save(depto2);


			Funcionario func1 = new Funcionario(null, "Micael", depto2);
			Funcionario func2 = new Funcionario(null,"Viviane",depto1);
			funcRep.save(func1);
			funcRep.save(func2);
		};
	}
}
