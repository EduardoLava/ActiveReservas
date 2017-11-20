package br.com.active.reservas.controller.inventario;

import br.com.active.reservas.servicos.impl.ServicoItemReservavel;
import br.com.active.reservas.servicos.impl.ServicoTipoDeAtivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 

@Controller
@RequestMapping("/item-reservavel")
public class ItemReservavelController {

	@Autowired
        private ServicoItemReservavel servicoItemReservavel;
       
        @Autowired
        private ServicoTipoDeAtivo servicoTipoDeAtivo;
	
//        @PreAuthorize("hasRole('ROLE_USUARIO')")
//	@GetMapping("/")
//	public ModelAndView listar() { 
//        
//            final List<TipoDeAtivo> tiposAtivos = servicoTipoDeAtivo.findTiposDeAtivosAtivos();
//
//            ModelAndView modelAndView = new ModelAndView( "itemReservavel/modalItens");
//            modelAndView.addObject("tiposAtivos", tiposAtivos);
//            modelAndView.addObject("itensReservaveis",  servicoItemReservavel.findAll());
//            
//            return modelAndView;
//            
//	}
        
//        @PreAuthorize("hasRole('ROLE_USUARIO')")
//        @GetMapping("/filtrar-tipos")
//        public ModelAndView pesquisarTipos(@RequestParam(value = "tipo", required = true) String tipo){
//            
//            TipoItem tip = null;
//
//            if(tipo != null && !tipo.isEmpty()){
//                tip = TipoItem.valueOf(tipo);
//            }
//            
//            return new ModelAndView(
//                    "reservas/filtrarTiposItensAjax", 
//                    "itensReservaveis", 
//                    this.servicoItemReservavel
//                            .findByTipo(tip)
//            );
//            
//        }
        
        
}
