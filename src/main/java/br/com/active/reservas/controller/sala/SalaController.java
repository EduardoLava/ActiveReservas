package br.com.active.reservas.controller.sala;

import br.com.active.reservas.bean.sala.Sala;
import br.com.active.reservas.bean.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.active.reservas.servicos.ServicoSala;
import br.com.active.reservas.servicos.ServicoUsuario;
import java.util.List;
import javax.validation.Valid;
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
	
	@GetMapping("/")
	public ModelAndView listarSalas() { 
		
            return new ModelAndView("salas/listarSalas", "salas", servicoSala.findAll());
		
	}
        
	@GetMapping("/filtrar")
	public ModelAndView listarSalas(@RequestParam(value = "filtro", required = true) String filtro) { 
            return new ModelAndView("salas/listarSalasPesquisaAjax", "salas", servicoSala.filtrarPorDescricaoOuCodigo(filtro));
		
	}
        
        @GetMapping("/cadastrar")
        public ModelAndView criaFormCadastroSala(){
            
            List<Usuario> funcionariosAtivos = servicoUsuario
                    .findFuncionariosAtivos();
            
//            nome da view no construtor
            ModelAndView modelAndView = new ModelAndView("salas/formCadastroSala");
            modelAndView.addObject("sala", new Sala());
            modelAndView.addObject("funcionariosAtivos", funcionariosAtivos);
            
            return modelAndView;
        }
       
        @PostMapping("/salvar")
        public String salvarSala(@Valid @ModelAttribute("sala") Sala sala, BindingResult bindingResult){
            
            if(bindingResult.hasFieldErrors()){
                System.out.println("has field errors: "+bindingResult.toString());
                return "salas/formCadastroSala";
            }
            
//            if(sala.getId() != null){
//                Sala x = servicoSala.findById(sala.getId());
//                sala.setDataCadastro(x.getDataCadastro());
//            }
            
            servicoSala.salvar(sala);
            
            return "redirect:/salas/";
            
        }
        
        @GetMapping("/editar")
        public ModelAndView criaFormEditar(@RequestParam(value = "id", required = true) Long id ){
            
            List<Usuario> funcionariosAtivos = servicoUsuario.findFuncionariosAtivos();
            
            ModelAndView modelAndView = new ModelAndView("salas/formCadastroSala");
            modelAndView.addObject("sala", servicoSala.findById(id));
            modelAndView.addObject("funcionariosAtivos", funcionariosAtivos);
            modelAndView.addObject("modo", "EDICAO");
            
            return modelAndView;
            
        }
	
}
