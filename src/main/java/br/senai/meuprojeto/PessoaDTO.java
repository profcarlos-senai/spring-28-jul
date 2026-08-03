package br.senai.meuprojeto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PessoaDTO(
        String nome,
        String telefone,
        Integer idade,
        LocalDate dataContrato,
        BigDecimal salario
) {
}