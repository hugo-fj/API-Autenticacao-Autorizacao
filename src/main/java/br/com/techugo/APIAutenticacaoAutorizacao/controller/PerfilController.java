package br.com.techugo.APIAutenticacaoAutorizacao.controller;


import br.com.techugo.APIAutenticacaoAutorizacao.controller.dto.PerfilDto;
import br.com.techugo.APIAutenticacaoAutorizacao.model.Perfil;
import br.com.techugo.APIAutenticacaoAutorizacao.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    @RequestMapping("/perfis")
    public List<PerfilDto> listar(){
        List<Perfil> perfis = perfilRepository.findAll();
        return PerfilDto.converter(perfis);
    }
}
