package br.com.techugo.APIAutenticacaoAutorizacao.controller;

import br.com.techugo.APIAutenticacaoAutorizacao.controller.dto.UsuarioDto;
import br.com.techugo.APIAutenticacaoAutorizacao.model.Usuario;
import br.com.techugo.APIAutenticacaoAutorizacao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/usuarios")
    public List<UsuarioDto> listar(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioDto.converter(usuarios);
    }


}
