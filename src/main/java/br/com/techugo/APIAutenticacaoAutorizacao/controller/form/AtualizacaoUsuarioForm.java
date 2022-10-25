package br.com.techugo.APIAutenticacaoAutorizacao.controller.form;

import br.com.techugo.APIAutenticacaoAutorizacao.model.Usuario;
import br.com.techugo.APIAutenticacaoAutorizacao.repository.UsuarioRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoUsuarioForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String email;

    @NotNull @NotEmpty @Length(min = 10)
    private String nome;

    public AtualizacaoUsuarioForm(String email, String nome) {
        this.email = email;
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario atualizar(Long id, UsuarioRepository usuarioRepository){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        return usuario;
    }
}
