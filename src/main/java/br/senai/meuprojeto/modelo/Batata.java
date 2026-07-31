package br.senai.meuprojeto.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "clientes") // nome dessa tabela no banco
public class Batata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_BATATA") // nome desse campo no banco
    private Integer codigo;
    @Column(length = 50) // tamanho desse campo no banco
    private String nome;
    private LocalDate dataNasc;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
}
