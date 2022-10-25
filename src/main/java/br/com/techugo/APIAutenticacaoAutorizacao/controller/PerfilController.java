package br.com.techugo.APIAutenticacaoAutorizacao.controller;


import br.com.techugo.APIAutenticacaoAutorizacao.controller.dto.PerfilDto;
import br.com.techugo.APIAutenticacaoAutorizacao.controller.form.AtualizacaoUsuarioForm;
import br.com.techugo.APIAutenticacaoAutorizacao.controller.form.PerfilForm;
import br.com.techugo.APIAutenticacaoAutorizacao.model.Perfil;
import br.com.techugo.APIAutenticacaoAutorizacao.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping
    public List<PerfilDto> listar(String nome){
        if(nome == null){
            List<Perfil> perfis = perfilRepository.findAll();
            return PerfilDto.converter(perfis);
        }else{
            List<Perfil> perfis = perfilRepository.findByNome(nome);
            return PerfilDto.converter(perfis);
        }
    }
    @PostMapping
    @Transactional
    public ResponseEntity<PerfilDto> cadastrar(@RequestBody @Valid PerfilForm form, UriComponentsBuilder uriBuilder){
        Perfil perfil  = form.converter(perfilRepository);
        perfilRepository.save(perfil);

        URI uri = uriBuilder.path("/perfis/{id}").buildAndExpand(perfil.getId()).toUri();
        return ResponseEntity.created(uri).body(new PerfilDto(perfil));
        }

    @GetMapping ("/{id}")
    public PerfilDto detalhar(@PathVariable Long id){
        Perfil perfil = perfilRepository.getReferenceById(id);
        return new PerfilDto(perfil);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PerfilDto> atualizar(@PathVariable Long id, @RequestBody @Valid PerfilForm form) {
        Perfil perfil = form.atualizar(id,perfilRepository);
        return ResponseEntity.ok(new PerfilDto(perfil));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        perfilRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}





