package br.senai.meuprojeto.controle;

import br.senai.meuprojeto.modelo.Pessoa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @GetMapping
    public Pessoa getPessoa() {
        // Instancia um objeto Pessoa populado com dados fictícios
        return new Pessoa(
                1L,
                "Carlos Eduardo",
                "(41) 99999-8888",
                28,
                LocalDate.of(2023, 3, 15),
                new BigDecimal("4500.50")
        );
    }
}

