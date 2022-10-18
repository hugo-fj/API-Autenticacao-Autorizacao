package br.com.techugo.APIAutenticacaoAutorizacao.repository;

import br.com.techugo.APIAutenticacaoAutorizacao.model.Perfil;
import br.com.techugo.APIAutenticacaoAutorizacao.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerfilRepository extends JpaRepository<Perfil,Long> {
}
