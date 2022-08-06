package dcc193.tvc8.trabalho.avaliacao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/avaliacao")
public class ControllerAvaliacao {
    @RequestMapping({"/","cadastro.html"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("avaliacao-cadastro");
        mv.addObject("mensagem", "Cadastro de Avaliação!");
        return mv;
    }
}
