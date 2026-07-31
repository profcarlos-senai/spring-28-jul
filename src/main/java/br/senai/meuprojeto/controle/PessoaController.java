package br.senai.meuprojeto.controle;

import br.senai.meuprojeto.modelo.Pessoa;
import br.senai.meuprojeto.repositorio.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Retorna a lista completa de pessoas do banco
    @GetMapping
    public List<Pessoa> getPessoa() {
        return pessoaRepository.findAll();
    }

    // Retorna uma pessoa específica através do ID
    @GetMapping("{id}")
    public ResponseEntity<Pessoa> getPessoaPorId(@PathVariable Long id) {
        return pessoaRepository.findById(id)
                .map(pessoa -> ResponseEntity.ok(pessoa))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa criaPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @PutMapping("{id}")
    public ResponseEntity<Pessoa> alteraPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        if (!pessoaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pessoa.setId(id);
        Pessoa pessoaAtualizada = pessoaRepository.save(pessoa);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletaPessoa(@PathVariable Long id) {
        if (!pessoaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pessoaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}

