package br.senai.meuprojeto.repositorio;

import br.senai.meuprojeto.modelo.Batata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatataRepository extends JpaRepository<Batata, Integer> {
}