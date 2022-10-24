package br.com.techugo.APIAutenticacaoAutorizacao.controller.form;

import br.com.techugo.APIAutenticacaoAutorizacao.model.Usuario;
import br.com.techugo.APIAutenticacaoAutorizacao.repository.UsuarioRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String email;

    @NotNull @NotEmpty @Length(min = 10)
    private String nome;

    @NotNull @NotEmpty @Length(min = 6)
    private String senha;


    public String getEmail() {return email;}
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }


    public Usuario converter(UsuarioRepository usuarioRepository) {
        return new Usuario(nome,email,senha);
    }
}
