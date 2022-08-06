package dcc193.tvc8.trabalho.projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProjeto extends JpaRepository<Projeto, Long> {
    
}
