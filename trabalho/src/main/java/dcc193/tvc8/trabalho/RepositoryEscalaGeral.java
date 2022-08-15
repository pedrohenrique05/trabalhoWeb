package dcc193.tvc8.trabalho;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEscalaGeral extends JpaRepository<EscalaGeral, Long> {
    
}
