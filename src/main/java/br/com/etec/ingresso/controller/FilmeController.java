package br.com.etec.ingresso.controller;

import br.com.etec.ingresso.entity.Filme;
import br.com.etec.ingresso.enums.ClassificacaoIndicativaEnum;
import br.com.etec.ingresso.enums.SimNaoEnum;
import lombok.Builder;
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
    @GetMapping("/{id}")
    public Filme buscaPorId(@PathVariable Long id){
        Filme filme1 = Filme.builder()
                .id(1L)
                .nome("Matrix")
                .classificacao(A16)
                .emCartaz(SimNaoEnum.S)
                .build();
        return filme1;
    }
    @PostMapping
    public Filme cadastrar(@RequestBody Filme filme){
        filme.setId(100L);
        return filme;
    }

}
