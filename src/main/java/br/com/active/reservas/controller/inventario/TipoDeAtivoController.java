package br.com.active.reservas.controller.inventario;

import br.com.active.reservas.bean.itens.inventario.TipoDeAtivo;
import br.com.active.reservas.controller.*;
import br.com.active.reservas.bean.usuario.Usuario;
import br.com.active.reservas.servicos.impl.ServicoTipoDeAtivo;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tipos-de-ativos")
public class TipoDeAtivoController {

	@Autowired
        private ServicoTipoDeAtivo servicoTipoDeAtivo;
	
        @PreAuthorize("hasRole('ROLE_USUARIO')")
	@GetMapping("/")
	public ModelAndView listar() { 
        
            return new ModelAndView(
                    "tipoDeAtivo/listarTiposDeAtivos", 
                    "tiposDeAtivos", 
                    servicoTipoDeAtivo.findAll()
            );
		
	}
        
        @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
        @GetMapping("/cadastrar")
        public ModelAndView criaFormCadastro(TipoDeAtivo tipoDeAtivo){
     
                return new ModelAndView(
                        "tipoDeAtivo/formCadastroTipoDeAtivo", 
                        "tipoDeAtivo",
                        tipoDeAtivo
                );
                
        }
        
        @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
        @PostMapping("/salvar")
        public String cadastrarTipoDeAtivo(@Valid @ModelAttribute("tipoDeAtivo") TipoDeAtivo  tipoDeAtivo, BindingResult result){
            
            if(result.hasFieldErrors()){
                return "tipoDeAtivo/formCadastroTipoDeAtivo";
            }
            
            servicoTipoDeAtivo.salvar(tipoDeAtivo);
            
            return "redirect:/tipos-de-ativos/";
             
        
//        para fazer um redirect no lado do servidor utilizamos forward
//        e no lado do cliente utilizamos redirect
        }
        
        @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
        @GetMapping("/editar")
        public ModelAndView buscar(@RequestParam(value = "id", required = true) Long id ){
            return criaFormCadastro(servicoTipoDeAtivo.findById(id));
        }
        
	
}
