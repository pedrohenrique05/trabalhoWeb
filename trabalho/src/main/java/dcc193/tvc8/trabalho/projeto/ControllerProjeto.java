package dcc193.tvc8.trabalho.projeto;



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
            return mv;
        }
        rep.save(pro);
        mv.addObject("projeto", pro);
        mv.setViewName("redirect:listar.html");
        
        return mv;
    }

    @GetMapping(path = "/listar.html")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("projeto-listar");
        List<Projeto> pro = rep.findAll();
        mv.addObject("projetos", pro);
        return mv;
    }
    @GetMapping("/editar/{id}")
    public ModelAndView editarGET(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("projeto-editar");

        Optional<Projeto> projetoEditarOptional = rep.findById(id);
        if (projetoEditarOptional.isPresent()) {
            Projeto pro = projetoEditarOptional.get();
            mv.setViewName("projeto-editar");
            mv.addObject("projeto", pro);
            return mv;
        }
        mv.setViewName("redirect: ../listar.html");
        return mv;
    }

    @PostMapping("/editar/{id}")
    public ModelAndView editarPOST(@Valid Projeto pro, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("projeto-editar.html");
            mv.addObject("projeto", pro);
            return mv;
        }
        rep.save(pro);
        mv.addObject("projeto", pro);
        mv.setViewName("redirect:../listar.html");
        return mv;

    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("redirect:../listar.html");

        Optional<Projeto> projetoexcluir = rep.findById(id);

        if (projetoexcluir.isPresent()) {
            Projeto pro = projetoexcluir.get();
            rep.delete(pro);
        }
        return mv;
    }
}
