package br.com.techugo.APIAutenticacaoAutorizacao.controller.dto;
import br.com.techugo.APIAutenticacaoAutorizacao.model.Usuario;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDto {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    public UsuarioDto(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public static List<UsuarioDto> converter(List<Usuario> usuarios){
        return  usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
    }
}
