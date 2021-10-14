package br.com.ayrton.excecoesspringapirest.repositories;

import br.com.ayrton.excecoesspringapirest.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
}
