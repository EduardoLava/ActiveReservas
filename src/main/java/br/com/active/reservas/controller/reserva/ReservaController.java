package br.com.active.reservas.controller.reserva;

import br.com.active.reservas.bean.itens.ItemReservavel;
import br.com.active.reservas.bean.itens.TipoItem;
import br.com.active.reservas.bean.itens.inventario.TipoDeAtivo;
import br.com.active.reservas.bean.reserva.ItemReserva;
import br.com.active.reservas.bean.reserva.Reserva;
import br.com.active.reservas.bean.reserva.StatusReserva;
import br.com.active.reservas.bean.usuario.Usuario;
import br.com.active.reservas.converter.LocalDateStringConverter;
import br.com.active.reservas.security.session.impl.SessionFacade;
import br.com.active.reservas.servicos.impl.ServicoItemReserva;
import br.com.active.reservas.servicos.impl.ServicoItemReservavel;
import br.com.active.reservas.servicos.impl.ServicoReserva;
import br.com.active.reservas.servicos.impl.ServicoTipoDeAtivo;
import br.com.active.reservas.servicos.impl.ServicoUsuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Scope(value = "session")
@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ServicoReserva servicoReserva;

    @Autowired
    private ServicoItemReservavel servicoItemReservavel;
    
    @Autowired
    private ServicoItemReserva servicoItemReserva;

    @Autowired
    private ServicoTipoDeAtivo servicoTipoDeAtivo;
    
    private List<ItemReserva> itensMinhaReserva;

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/")
    public ModelAndView listarReservas() { 
        
//        vai ser implementado
        return null;

    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/modal")
    public ModelAndView openModal() { 
        
        final List<TipoDeAtivo> tiposAtivos = servicoTipoDeAtivo.findTiposDeAtivosAtivos();
        ModelAndView modelAndView = new ModelAndView("reservas/modalItens");
        modelAndView.addObject("tiposAtivos", tiposAtivos);
        
        return modelAndView;
        
    }
    
    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @PostMapping("/adicionar")
    public void adicionaItemReserva(
        @Valid @ModelAttribute("id") Long id, String data,
        BindingResult result
    ){

        LocalDate dataReserva = LocalDateStringConverter.parse(data);
        
//      se o item não existir 
        if(!itensMinhaReserva
                .stream()
                .filter(
                        it -> it.getItemReservavel()
                                .getId()
                                .equals(id)
                ).findFirst()
                 .isPresent()
        ){

            ItemReserva item = new ItemReserva(servicoItemReservavel.findById(id));
            item.setDataReserva(dataReserva);
            item.setStatus(StatusReserva.ATIVA);

            itensMinhaReserva.add(item);

        }

    }
    
    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/remover-item/{id}")
    public ModelAndView removerItem(@PathVariable Long id){
        
        Optional i = itensMinhaReserva.stream().filter(it -> it.getItemReservavel().getId().equals(id)).findFirst();

        if(i.isPresent()){
            itensMinhaReserva.remove((ItemReserva)i.get());
        }

        return criaFormReserva(null);
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/formulario")
    public ModelAndView criaFormReserva(Reserva reserva){

        ModelAndView modelAndView = new ModelAndView("reservas/formCadastroReserva");

        if(itensMinhaReserva == null){
            itensMinhaReserva = new ArrayList<>();
        }
        
        modelAndView.addObject("itensMinhaReserva", itensMinhaReserva);            
        modelAndView.addObject("reserva", reserva);

        return modelAndView;
    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @PostMapping("/salvar")
    public ModelAndView salvarReserva(){

        Reserva reserva = new Reserva(SessionFacade.getUsuarioLogado(), itensMinhaReserva);
            
        servicoReserva.salvar(reserva);
            
        itensMinhaReserva = new ArrayList<>();
        
        return new ModelAndView("redirect:/reservas/");

    }

//    @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
//    @GetMapping("/editar")
//    public ModelAndView buscar(@RequestParam(value = "id", required = true) Long id ){
//        return criaFormReserva(servicoReserva.findById(id));
//    }
    
    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/detalhes")
    public ModelAndView buscar(@RequestParam(value = "id", required = true) Long id ){
        
        return new ModelAndView(
                "reservas/reservaDetalhes",
                "reserva",
                servicoReserva.findById(id)
        );
        
    }
    
    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/cancelar-item/{id}")
    public ModelAndView cancelarItem(@PathVariable Long id ){
        
        ItemReserva itemReserva = servicoItemReserva.cancelarReserva(id);
         
        return new ModelAndView("redirect:/reservas/detalhes?id="+itemReserva.getReserva().getId());
        
    }
    

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/disponiveis-data")
    public ModelAndView buscaItensDisponiveis(@RequestParam(value = "data", required = true) String data){

        LocalDate localDate = LocalDateStringConverter.parse(data);

        List<ItemReservavel> itens = servicoItemReservavel
                .findDisponiveisBy(localDate);

        final List<TipoDeAtivo> tiposAtivos = servicoTipoDeAtivo.findTiposDeAtivosAtivos();

        ModelAndView modelAndView = new ModelAndView( "reservas/filtrarTiposItensAjax");
        modelAndView.addObject("tiposAtivos", tiposAtivos);
        modelAndView.addObject("itensReservaveis",  itens);            

        return modelAndView;

    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/disponiveis-data-tipo")
    public ModelAndView buscaItensDisponiveis(
            @RequestParam(value = "data", required = true) String data, 
            @RequestParam(value = "tipo", required = true) String tipo
    ){

        LocalDate localDate = LocalDateStringConverter.parse(data);

        List<ItemReservavel> itens = servicoItemReservavel
                .findDisponiveisBy(TipoItem.valueOf(tipo), localDate);

        final List<TipoDeAtivo> tiposAtivos = servicoTipoDeAtivo.findTiposDeAtivosAtivos();

        ModelAndView modelAndView = new ModelAndView( "reservas/filtrarTiposItensAjax");
        modelAndView.addObject("tiposAtivos", tiposAtivos);
        modelAndView.addObject("itensReservaveis",  itens);            

        return modelAndView;

    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")    
    @GetMapping("/disponiveis-data-tipos")
    public ModelAndView buscaItensDisponiveis(
            @RequestParam(value = "data", required = true) String data, 
            @RequestParam(value = "tipo", required = true) String tipo,
            @RequestParam(value = "idTipoAtivo", required = true) Long idTipoDeAtivo
    ){

        LocalDate localDate = LocalDateStringConverter.parse(data);

        List<ItemReservavel> itens = servicoItemReservavel
                .findDisponiveisBy(TipoItem.valueOf(tipo), idTipoDeAtivo, localDate);

        final List<TipoDeAtivo> tiposAtivos = servicoTipoDeAtivo.findTiposDeAtivosAtivos();

        ModelAndView modelAndView = new ModelAndView( "reservas/filtrarTiposItensAjax");
        modelAndView.addObject("tiposAtivos", tiposAtivos);
        modelAndView.addObject("itensReservaveis",  itens);            

        return modelAndView;

    }
	
}
