package dcc193.tvc8.trabalho.relatorio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/relatorio")
public class ControllerRelatorio {
 
    @RequestMapping({"/","relatorioListar.html"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("relatorio-listar");
        mv.addObject("mensagem", "Relatórios cadastrados!");
        return mv;
    }
}
