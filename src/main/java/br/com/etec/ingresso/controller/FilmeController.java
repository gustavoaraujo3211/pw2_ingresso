package br.com.etec.ingresso.controller;

import br.com.etec.ingresso.entity.Filme;
import br.com.etec.ingresso.enums.ClassificacaoIndicativaEnum;
import br.com.etec.ingresso.enums.SimNaoEnum;
import io.micrometer.common.KeyValue;
import lombok.Builder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.etec.ingresso.enums.ClassificacaoIndicativaEnum.A16;

@Builder
@RestController
@RequestMapping("/filmes")

public class FilmeController {

    @GetMapping
    public List<Filme> listar(){
        Filme filme1 = Filme.builder()
                .id(1L)
                .nome("Matrix")
                .classificacao(A16)
                .emCartaz(SimNaoEnum.S)
                .build();

        Filme filme2 = Filme.builder()
                .id(2L)
                .nome("Homem aranha")
                .classificacao(A16)
                .emCartaz(SimNaoEnum.S)
                .build();
        return List.of(filme1, filme2);
    }

    List<Long> idsInexistentes = List.of(1L, 2L, 3L);
    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id){
        if(idsInexistentes.contains(id)) {
            Filme filme1 = Filme.builder()
                    .id(1L)
                    .nome("Matrix")
                    .classificacao(ClassificacaoIndicativaEnum.A16)
                    .emCartaz(SimNaoEnum.S)
                    .build();
            return ResponseEntity.ok(filme1);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Filme cadastrar(@RequestBody Filme filme){
        filme.setId(100L);
        return filme;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(@RequestBody Filme filme,
                           @PathVariable Long id){
        if(idsExistentes.contains(id)){
            return ResponseEntity.ok(filme);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){

    }

}
