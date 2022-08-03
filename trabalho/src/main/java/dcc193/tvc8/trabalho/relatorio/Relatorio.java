package dcc193.tvc8.trabalho.relatorio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Relatorio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
