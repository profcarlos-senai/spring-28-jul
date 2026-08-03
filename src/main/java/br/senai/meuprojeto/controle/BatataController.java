package br.senai.meuprojeto.controle;

import br.senai.meuprojeto.modelo.Batata;
import br.senai.meuprojeto.repositorio.BatataRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/batata")
public class BatataController {

    private final BatataRepository batataRepository;

    // em vez de usar @Autowire, isso tbm funciona
    public BatataController(BatataRepository batataRepository) {
        this.batataRepository = batataRepository;
    }

    // GET /batata
    @GetMapping
    public List<Batata> listar() {
        return batataRepository.findAll();
    }

    // GET /batata/5
    @GetMapping("/{codigo}")
    public ResponseEntity<Batata> buscar(@PathVariable Integer codigo) {

        Optional<Batata> opt = batataRepository.findById(codigo);

        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(opt.get());
    }

    // POST /batata
    @PostMapping
    public ResponseEntity<Batata> inserir(@RequestBody Batata batata) {

        batata.setCodigo(null);

        Batata salva = batataRepository.save(batata);

        return ResponseEntity
                .created(URI.create("/batata/" + salva.getCodigo()))
                .body(salva);
    }

    // PUT /batata/5
    @PutMapping("/{codigo}")
    public ResponseEntity<Batata> alterar(@PathVariable Integer codigo,
                                          @RequestBody Batata batata) {

        if (!batataRepository.existsById(codigo)) {
            return ResponseEntity.notFound().build();
        }

        batata.setCodigo(codigo);

        Batata alterada = batataRepository.save(batata);

        return ResponseEntity.ok(alterada);
    }

    // DELETE /batata/5
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> excluir(@PathVariable Integer codigo) {

        if (!batataRepository.existsById(codigo)) {
            return ResponseEntity.notFound().build();
        }

        batataRepository.deleteById(codigo);

        return ResponseEntity.noContent().build();
    }

}