package dcc193.tvc8.trabalho.avaliacao;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/avaliacao")
public class ControllerAvaliacao {

    @Autowired
    private RepositoryAvaliacao rep;
    
    @RequestMapping({"/","index.html"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("avaliacao-index");
        mv.addObject("mensagem", "Cadastro de Avaliação!");
        return mv;
    }

    @GetMapping("/cadastrar.html")
    public ModelAndView novaGET() {
        ModelAndView mv = new ModelAndView("avaliacao-cadastro");
        Avaliacao aval = new Avaliacao();
        mv.addObject("avaliacao", aval);
        return mv;
    }
    
    @PostMapping("/cadastrar.html")
    public ModelAndView novaPOST(@Valid Avaliacao aval, BindingResult binding) {
        ModelAndView mv = new ModelAndView("avaliacao-cadastro");
        if (binding.hasErrors()) {
            mv.setViewName("avaliacao-cadastro.html");
            mv.addObject("avaliacao", aval);
            return mv;
        }
        rep.save(aval);
        mv.addObject("avaliacao", aval);
        mv.setViewName("redirect:listar.html");
        
        return mv;
    }
}
