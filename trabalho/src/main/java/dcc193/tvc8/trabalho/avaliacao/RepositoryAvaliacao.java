package dcc193.tvc8.trabalho.avaliacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAvaliacao extends JpaRepository<Avaliacao, Long> {
    
}
