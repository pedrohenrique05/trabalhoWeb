package dcc193.tvc8.trabalho.projeto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Projeto {

    @NotBlank(message = "E preciso um titulo!")
    private String titulo;

    @NotBlank(message = "E preciso a url do repositorio!")
    private String urlRepositorio;

    @NotBlank(message = "E preciso a url do perfil principal do projeto!")
    private String urlPerfil;

    @NotBlank(message = "É preciso uma descrição do projeto")
    private String obs;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 


    
    
    public Projeto(Long id, @NotBlank(message = "E preciso um titulo!") String titulo,
            @NotBlank(message = "E preciso a url do repositorio!") String urlRepositorio,
            @NotBlank(message = "E preciso a url do perfil principal do projeto!") String urlPerfil,
            @NotBlank(message = "É preciso uma descrição do projeto") String obs) {
        this.titulo = titulo;
        this.urlRepositorio = urlRepositorio;
        this.urlPerfil = urlPerfil;
        this.obs = obs;
        this.id = id;
    }

    public Projeto(Long id, String titulo, String urlRepositorio,String urlPerfil){
        this(id,titulo,urlRepositorio,urlPerfil,null);
    }

    public Projeto(Long id, String titulo, String urlRepositorio){
        this(id,titulo,urlRepositorio,null,null);
    }

    public Projeto(Long id, String titulo){
        this(id,titulo,null,null,null);
    }

    public Projeto(long id){
        this(id,null,null,null,null);
    }

    public Projeto(){
        this(null,null,null,null,null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrlRepositorio() {
        return urlRepositorio;
    }

    public void setUrlRepositorio(String urlRepositorio) {
        this.urlRepositorio = urlRepositorio;
    }

    public String getUrlPerfil() {
        return urlPerfil;
    }

    public void setUrlPerfil(String urlPerfil) {
        this.urlPerfil = urlPerfil;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Projeto [id=" + id + ", obs=" + obs + ", titulo=" + titulo + ", urlPerfil=" + urlPerfil
                + ", urlRepositorio=" + urlRepositorio + "]";
    }

        
    
}
