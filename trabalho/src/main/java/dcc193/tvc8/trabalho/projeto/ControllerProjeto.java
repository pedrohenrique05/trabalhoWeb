package dcc193.tvc8.trabalho.projeto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/projeto")
public class ControllerProjeto {
    
    @RequestMapping("cadastro.html")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("projeto-cadastro");
        mv.addObject("mensagem", "Cadastro de Projeto!");
        return mv;
    }
}
