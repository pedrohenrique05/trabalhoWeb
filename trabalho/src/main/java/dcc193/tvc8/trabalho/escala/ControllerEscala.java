package dcc193.tvc8.trabalho.escala;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/escala")
public class ControllerEscala {

    @Autowired
    private RepositoryEscala rep;
    
    @RequestMapping({"/","index.html"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("escala-index");
        mv.addObject("mensagem", "Cadastro de Escala!");
        return mv;
    }

    @GetMapping("/cadastrar.html")
    public ModelAndView novaGET() {
        ModelAndView mv = new ModelAndView("escala-cadastro");
        Escala esc = new Escala();
        mv.addObject("escala", esc);
        return mv;
    }
    
    @PostMapping("/cadastrar.html")
    public ModelAndView novaPOST(@Valid Escala esc, BindingResult binding) {
        ModelAndView mv = new ModelAndView("escala-cadastro");
        if (binding.hasErrors()) {
            mv.setViewName("escala-cadastro.html");
            mv.addObject("escala", esc);
            return mv;
        }
        rep.save(esc);
        mv.addObject("escala", esc);
        mv.setViewName("redirect:listar.html");
        return mv;
    }

    @GetMapping(path = "/listar.html")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("escala-listar");
        List<Escala> esc = rep.findAll();
        mv.addObject("escalas", esc);
        return mv;
    }
    
    @GetMapping("/editar/{id}")
    public ModelAndView editarGET(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("escala-editar");

        Optional<Escala> escalaEditarOptional = rep.findById(id);
        if (escalaEditarOptional.isPresent()) {
            Escala esc = escalaEditarOptional.get();
            mv.setViewName("escala-editar");
            mv.addObject("escala", esc);
            return mv;
        }
        mv.setViewName("redirect: ../listar.html");
        return mv;
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarPOST(@Valid Escala esc, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("escala-editar.html");
            mv.addObject("escala", esc);
            return mv;
        }
        rep.save(esc);
        mv.addObject("escala", esc);
        mv.setViewName("redirect:../listar.html");
        return mv;

    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("redirect:../listar.html");

        Optional<Escala> escalaExcluir = rep.findById(id);

        if (escalaExcluir.isPresent()) {
            Escala esc = escalaExcluir.get();
            rep.delete(esc);
        }
        return mv;
    }
}
