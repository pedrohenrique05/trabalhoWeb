package dcc193.tvc8.trabalho.Observacao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/observacao")
public class ControllerObservacao {
 
    @RequestMapping({"/","index.html"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("observacao-listar");
        mv.addObject("mensagem", "Observações!");
        return mv;
    }
}
