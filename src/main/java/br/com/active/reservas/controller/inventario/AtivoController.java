package br.com.active.reservas.controller.inventario;

import br.com.active.reservas.bean.itens.inventario.Ativo;
import br.com.active.reservas.bean.itens.inventario.TipoDeAtivo;
import br.com.active.reservas.bean.usuario.Usuario;
import br.com.active.reservas.servicos.impl.ServicoAtivo;
import br.com.active.reservas.servicos.impl.ServicoTipoDeAtivo;
import br.com.active.reservas.servicos.impl.ServicoUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
 
import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ativos")
public class AtivoController {

	@Autowired
        private ServicoAtivo servicoAtivo;
        
	@Autowired
        private ServicoUsuario servicoUsuario;
        
        @Autowired
        private ServicoTipoDeAtivo servicoTipoDeAtivo;
	
        @PreAuthorize("hasRole('ROLE_USUARIO')")
	@GetMapping("/")
	public ModelAndView listar() { 
        
            return new ModelAndView(
                    "ativos/listarAtivos", 
                    "ativos", 
                    servicoAtivo.findAll()
            );
		
	}
        
//        @PreAuthorize("hasRole('ROLE_USUARIO')")
//	@GetMapping("/filtrar")
//	public ModelAndView listarSalas(@RequestParam(value = "filtro", required = true) String filtro) { 
//            return new ModelAndView("salas/listarSalasPesquisaAjax", "ativos", servicoAtivo.filtrarPorDescricaoOuCodigo(filtro));
//		
//	}
        
        @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
        @GetMapping("/cadastrar")
        public ModelAndView criaFormCadastro(Ativo ativo){
     
            List<Usuario> funcionariosAtivos = servicoUsuario
                    .findFuncionariosAtivos();
            
            List<TipoDeAtivo> tiposDeAtivos = servicoTipoDeAtivo
                    .findTiposDeAtivosAtivos();
            
//            nome da view no construtor
            ModelAndView modelAndView = new ModelAndView("ativos/formCadastroAtivo");
            modelAndView.addObject("ativo", ativo);
            modelAndView.addObject("funcionariosAtivos", funcionariosAtivos);
            modelAndView.addObject("tiposDeAtivos", tiposDeAtivos);
            
            return modelAndView;
                
        }
        
        @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
        @PostMapping("/salvar")
        public ModelAndView cadastrarAtivo(
                @Valid @ModelAttribute("ativo") Ativo ativo, 
                BindingResult result
        ){
            
            if(result.hasFieldErrors() || result.hasGlobalErrors()){
                return criaFormCadastro(ativo);
            }
            
            servicoAtivo.salvar(ativo);
            
            return new ModelAndView("redirect:/ativos/");
             
        
//        para fazer um redirect no lado do servidor utilizamos forward
//        e no lado do cliente utilizamos redirect
        }
        
        @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
        @GetMapping("/editar")
        public ModelAndView buscar(@RequestParam(value = "id", required = true) Long id ){
            return criaFormCadastro(servicoAtivo.findById(id));
        }
        
	
}
