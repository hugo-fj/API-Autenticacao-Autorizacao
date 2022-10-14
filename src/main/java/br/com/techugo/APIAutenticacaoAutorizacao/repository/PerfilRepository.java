package br.com.techugo.APIAutenticacaoAutorizacao.repository;

import br.com.techugo.APIAutenticacaoAutorizacao.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil,Long> {
}
