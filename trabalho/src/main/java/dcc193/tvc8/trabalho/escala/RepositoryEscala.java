package dcc193.tvc8.trabalho.escala;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEscala extends JpaRepository<Escala, Long> {
    
}
