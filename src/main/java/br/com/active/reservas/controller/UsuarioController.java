package br.com.active.reservas.controller;

import br.com.active.reservas.bean.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 
import br.com.active.reservas.servicos.impl.ServicoUsuario;
import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private ServicoUsuario servicoUsuario;
	
        @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
	@GetMapping("/")
	public ModelAndView listarUsuarios() { 
        
            return new ModelAndView(
                    "usuarios/listarUsuarios", 
                    "usuarios", 
                    servicoUsuario.findAll()
            );
		
	}
        
        @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
        @GetMapping("/cadastrar")
        public ModelAndView criaFormCadastro(){
     
                return new ModelAndView(
                        "usuarios/formCadastroUsuario", 
                        "usuario",
                        new Usuario()
                );
                
        }
        
        @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
        @PostMapping("/salvar")
        public String cadastrarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result){
            
            if(result.hasFieldErrors()){
                return "usuarios/formCadastroUsuario";
            }
            
            servicoUsuario.salvar(usuario);
            
            return "redirect:/usuarios/";
             
        
//        para fazer um redirect no lado do servidor utilizamos forward
//        e no lado do cliente utilizamos redirect
        }
	
}
