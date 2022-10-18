package br.com.techugo.APIAutenticacaoAutorizacao.repository;

import br.com.techugo.APIAutenticacaoAutorizacao.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    List<Usuario> findByNome(String nome);
}

