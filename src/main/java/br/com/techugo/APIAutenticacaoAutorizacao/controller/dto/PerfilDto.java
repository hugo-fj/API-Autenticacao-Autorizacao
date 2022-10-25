package br.com.techugo.APIAutenticacaoAutorizacao.controller.dto;
import br.com.techugo.APIAutenticacaoAutorizacao.model.Perfil;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PerfilDto {
    private Long id;
    private String nome;

    public PerfilDto(Perfil perfil){
        this.id = perfil.getId();
        this.nome = perfil.getNome();
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public static List<PerfilDto> converter(List<Perfil> perfis){
        return perfis.stream().map(PerfilDto::new).collect(Collectors.toList());
    }
}
