package br.com.active.reservas.controller.login;

import br.com.active.reservas.bean.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 
import br.com.active.reservas.servicos.ServicoUsuario;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private ServicoUsuario servicoUsuario;
	
	@GetMapping({"", "/login"})
	public ModelAndView criaFormLogin() {  
            return new ModelAndView(
                    "login/formLogin", 
                    "usuario", 
                    new Usuario()
            );
		
	}
         
	
}
