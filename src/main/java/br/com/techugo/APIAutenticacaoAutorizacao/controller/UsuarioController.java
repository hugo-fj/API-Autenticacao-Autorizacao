package br.com.techugo.APIAutenticacaoAutorizacao.controller;

import br.com.techugo.APIAutenticacaoAutorizacao.controller.dto.UsuarioDto;
import br.com.techugo.APIAutenticacaoAutorizacao.controller.form.UsuarioForm;
import br.com.techugo.APIAutenticacaoAutorizacao.model.Usuario;
import br.com.techugo.APIAutenticacaoAutorizacao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;




@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<UsuarioDto> listar(String nome){
        if (nome == null){
            List<Usuario> usuarios = usuarioRepository.findAll();
            return UsuarioDto.converter(usuarios);
        }else {
            List<Usuario> usuarios = usuarioRepository.findByNome(nome);
            return UsuarioDto.converter(usuarios);
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder){
        Usuario usuario = form.converter(usuarioRepository);
        usuarioRepository.save(usuario);

        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
    }

}
