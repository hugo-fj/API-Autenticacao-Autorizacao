package br.com.techugo.APIAutenticacaoAutorizacao.repository;

import br.com.techugo.APIAutenticacaoAutorizacao.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerfilRepository extends JpaRepository<Perfil,Long> {

    List<Perfil> findByNome(String nome);
}
