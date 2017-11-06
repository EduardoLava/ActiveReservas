package br.com.active.reservas.controller.sala;

import br.com.active.reservas.bean.itens.sala.Sala;
import br.com.active.reservas.bean.usuario.Usuario;
import br.com.active.reservas.security.session.ISessionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.active.reservas.servicos.impl.ServicoSala;
import br.com.active.reservas.servicos.impl.ServicoUsuario;
import java.util.List;
import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/salas")
public class SalaController {

	@Autowired
	private ServicoSala servicoSala;
        
        @Autowired
        private ServicoUsuario servicoUsuario;
	
        @Autowired
        private ISessionFacade session;
        
        @PreAuthorize("hasRole('ROLE_USUARIO')")
	@GetMapping("/")
	public ModelAndView listarSalas() { 
                    
            return new ModelAndView("salas/listarSalas", "salas", servicoSala.findAll());
		
	}
        
        @PreAuthorize("hasRole('ROLE_USUARIO')")
	@GetMapping("/filtrar")
	public ModelAndView listarSalas(@RequestParam(value = "filtro", required = true) String filtro) { 
            return new ModelAndView("salas/listarSalasPesquisaAjax", "salas", servicoSala.filtrarPorDescricaoOuCodigo(filtro));
		
	}
        
        @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
        @GetMapping("/formulario")
        public ModelAndView criaFormSala(Sala sala){
            
            List<Usuario> funcionariosAtivos = servicoUsuario
                    .findFuncionariosAtivos();
            
//            nome da view no construtor
            ModelAndView modelAndView = new ModelAndView("salas/formCadastroSala");
            modelAndView.addObject("sala", sala);
            modelAndView.addObject("funcionariosAtivos", funcionariosAtivos);
            
            return modelAndView;
        }
       
        @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
        @PostMapping("/salvar")
        public ModelAndView salvarSala(@Valid @ModelAttribute("sala") Sala sala, BindingResult bindingResult){
//            System.out.println(bindingResult.getGlobalError());
//            System.out.println(bindingResult.getFieldError());
            if(bindingResult.hasFieldErrors() || bindingResult.hasGlobalErrors()){
                  return criaFormSala(sala);
            }
            
            servicoSala.salvar(sala);
            
            return new ModelAndView("redirect:/salas/");
            
        }
        
        @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
        @GetMapping("/editar")
        public ModelAndView buscar(@RequestParam(value = "id", required = true) Long id ){
            return criaFormSala(servicoSala.findById(id));
        }
	
}
