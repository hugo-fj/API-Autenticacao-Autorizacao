package br.com.techugo.APIAutenticacaoAutorizacao.controller.form;

import br.com.techugo.APIAutenticacaoAutorizacao.model.Perfil;
import br.com.techugo.APIAutenticacaoAutorizacao.repository.PerfilRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PerfilForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public Perfil converter(PerfilRepository perfilRepository) {
        return new Perfil(nome);
    }

    public Perfil atualizar(Long id, PerfilRepository perfilRepository){
        Perfil perfil = perfilRepository.getReferenceById(id);
        perfil.setNome(this.nome);
        return perfil;
    }

}
