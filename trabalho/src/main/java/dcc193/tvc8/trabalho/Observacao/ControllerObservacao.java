package dcc193.tvc8.trabalho.Observacao;

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
@RequestMapping("/observacao")
public class ControllerObservacao {
 
    @Autowired
    private RepositoryObservacao rep;
    
    @RequestMapping({"/","index.html"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("observacao-index");
        mv.addObject("mensagem", "Observações!");
        return mv;
    }

    @GetMapping("/cadastrar.html")
    public ModelAndView novaGET() {
        ModelAndView mv = new ModelAndView("observacao-cadastro");
        Observacao obs = new Observacao();
        mv.addObject("observacao", obs);
        return mv;
    }
    
    @PostMapping("/cadastrar.html")
    public ModelAndView novaPOST(@Valid Observacao obs, BindingResult binding) {
        ModelAndView mv = new ModelAndView("observacao-cadastro");
        if (binding.hasErrors()) {
            mv.setViewName("observacao-cadastro.html");
            mv.addObject("observacao", obs);
            return mv;
        }
        rep.save(obs);
        mv.addObject("observacao", obs);
        mv.setViewName("redirect:listar.html");
        return mv;
    }

    @GetMapping(path = "/listar.html")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("observacao-listar");
        List<Observacao> obs = rep.findAll();
        mv.addObject("observacoes", obs);
        return mv;
    }
    
    @GetMapping("/editar/{id}")
    public ModelAndView editarGET(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("observacao-editar");

        Optional<Observacao> escalaEditarOptional = rep.findById(id);
        if (escalaEditarOptional.isPresent()) {
            Observacao obs = escalaEditarOptional.get();
            mv.setViewName("observacao-editar");
            mv.addObject("observacao", obs);
            return mv;
        }
        mv.setViewName("redirect: ../listar.html");
        return mv;
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarPOST(@Valid Observacao obs, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("observacao-editar.html");
            mv.addObject("observacao", obs);
            return mv;
        }
        rep.save(obs);
        mv.addObject("observacao", obs);
        mv.setViewName("redirect:../listar.html");
        return mv;

    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("redirect:../listar.html");

        Optional<Observacao> observacaoExcluir = rep.findById(id);

        if (observacaoExcluir.isPresent()) {
            Observacao obs = observacaoExcluir.get();
            rep.delete(obs);
        }
        return mv;
    }
}
