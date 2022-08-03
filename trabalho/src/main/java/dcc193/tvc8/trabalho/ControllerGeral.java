package dcc193.tvc8.trabalho;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ControllerGeral {
    
    @RequestMapping({ "/", "/index.html" })
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("geral-index");
        mv.addObject("mensagem", "Ola Mundo");
        return mv;
    }
}
