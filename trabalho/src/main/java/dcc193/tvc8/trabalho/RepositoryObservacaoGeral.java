package dcc193.tvc8.trabalho;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryObservacaoGeral extends JpaRepository<ObservacaoGeral, Long> {
    
    @Query(value = "SELECT * FROM ObservacaoGeral  WHERE idProjeto=?id" , nativeQuery = true)
    List<ObservacaoGeral> listarObservacoes(@Param("id")Long id);
    

   
}
