package br.com.active.reservas.controller.login;

import br.com.active.reservas.bean.usuario.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

//	@Autowired
//	private ServicoUsuario servicoUsuario;
	
	@GetMapping({"", "/login"})
	public ModelAndView criaFormLogin() {  
            return new ModelAndView(
                    "login/formLogin", 
                    "usuario", 
                    new Usuario()
            );
		
	}
         
	
}
