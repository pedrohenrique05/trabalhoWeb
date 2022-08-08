package dcc193.tvc8.trabalho.Observacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;



//import dcc193.tvc8.trabalho.escala.Escala;



@Entity
public class Observacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @NotBlank(message = "E preciso um nome!")
    String nome;
    @NotBlank(message = "E preciso a url para a sua descrição!")
    String urlDescricao;
    @NotBlank(message = "E preciso uma única escala a que pertence!")
    String esc;
    //Escala esc ;

    
    public Observacao(Long id, @NotBlank(message = "E preciso um nome!") String nome,
            @NotBlank(message = "E preciso a url para a sua descrição!") String urlDescricao,
            @NotBlank(message = "E preciso uma única escala a que pertence!") String esc) {
        this.id = id;
        this.nome = nome;
        this.urlDescricao = urlDescricao;
        this.esc = esc;
    }

    public Observacao(Long id, @NotBlank(message = "E preciso um nome!") String nome,
            @NotBlank(message = "E preciso a url para a sua descrição!") String urlDescricao) {
        this(id,nome,urlDescricao,null);
    }

    public Observacao(Long id, @NotBlank(message = "E preciso um nome!") String nome) {
        this(id,nome,null,null);
    }

    public Observacao(Long id) {
        this(id,null,null,null);
    }

    public Observacao() {
        this(null,null,null,null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlDescricao() {
        return urlDescricao;
    }

    public void setUrlDescricao(String urlDescricao) {
        this.urlDescricao = urlDescricao;
    }

    public String getEsc() {
        return esc;
    }

    public void setEsc(String esc) {
        this.esc = esc;
    }

    @Override
    public String toString() {
        return "Observacao [esc=" + esc.toString() + ", id=" + id + ", nome=" + nome + ", urlDescricao=" + urlDescricao + "]";
    }

    
}
