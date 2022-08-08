package dcc193.tvc8.trabalho.Observacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryObservacao extends JpaRepository<Observacao, Long> {
    
}
