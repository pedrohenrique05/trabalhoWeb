package dcc193.tvc8.trabalho.projeto;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/projeto")
public class ControllerProjeto {
    
    @Autowired
    private RepositoryProjeto rep;

    @RequestMapping({"/","/index.html"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("projeto-index");
        mv.addObject("mensagem", "Cadastro de Projeto!");
        return mv;
    }


    @GetMapping("/cadastrar.html")
    public ModelAndView novaGET() {
        ModelAndView mv = new ModelAndView("projeto-cadastro");
        Projeto pro = new Projeto();
        mv.addObject("projeto", pro);
        return mv;
    }
    
    @PostMapping("/cadastrar.html")
    public ModelAndView novaPOST(@Valid Projeto pro, BindingResult binding) {
        ModelAndView mv = new ModelAndView("projeto-cadastro");
        if (binding.hasErrors()) {
            mv.setViewName("projeto-cadastro.html");
            mv.addObject("projeto", pro);
            System.out.println("Erro"); 
            return mv;
        }
        rep.save(pro);
        mv.addObject("projeto", pro);
        mv.setViewName("redirect:listar.html");
        System.out.println("Funcionou");
        return mv;
    }

    @GetMapping(path = "/listar.html")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("projeto-listar");
        List<Projeto> pro = rep.findAll();
        mv.addObject("projeto", pro);
        return mv;
    }
    @RequestMapping("editar.html")
    public ModelAndView editar() {
        ModelAndView mv = new ModelAndView("projeto-editar");
        mv.addObject("mensagem", "Edição de Projeto!");
        return mv;
    }

    

    
    
}
