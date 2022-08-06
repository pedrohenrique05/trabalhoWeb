package dcc193.tvc8.trabalho.relatorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRelatorio extends JpaRepository<Relatorio, Long> {
    
}
