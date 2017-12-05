package br.com.active.reservas.controller.emprestimo;

import br.com.active.reservas.bean.emprestimo.Emprestimo;
import br.com.active.reservas.bean.emprestimo.EmprestimoItem;
import br.com.active.reservas.bean.emprestimo.StatusEmprestimo;
import br.com.active.reservas.bean.emprestimo.responsavel.TipoResponsavelEmprestimo;
import br.com.active.reservas.bean.emprestimo.responsavel.UsuarioEmprestimo;
import br.com.active.reservas.bean.itens.ItemReservavel;
import br.com.active.reservas.bean.itens.TipoItem;
import br.com.active.reservas.bean.itens.inventario.TipoDeAtivo;
import br.com.active.reservas.bean.reserva.ItemReserva;
import br.com.active.reservas.bean.usuario.Usuario;
import br.com.active.reservas.converter.LocalDateStringConverter;
import br.com.active.reservas.security.session.impl.SessionFacade;
import br.com.active.reservas.servicos.impl.ServicoEmprestimo;
import br.com.active.reservas.servicos.impl.ServicoItemReservavel;
import br.com.active.reservas.servicos.impl.ServicoTipoDeAtivo;
import br.com.active.reservas.servicos.impl.ServicoUsuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private ServicoEmprestimo servicoEmprestimo;
    
    @Autowired
    private ServicoTipoDeAtivo servicoTipoDeAtivo;
    
    @Autowired
    private ServicoItemReservavel servicoItemReservavel;
    
    
    @Autowired
    private ServicoUsuario servicoUsuario;
    
    private List<EmprestimoItem> itensMeusEmprestimos;

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/")
    public ModelAndView listarReservas() { 
        
//        vai ser implementado
        return null;

    }

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping({"/formulario","/formulario/"})
    public ModelAndView criaFormEmprestimo(Emprestimo emprestimo){

        ModelAndView modelAndView = new ModelAndView("emprestimos/formCadastroEmprestimo");

        if(itensMeusEmprestimos == null){
            itensMeusEmprestimos = new ArrayList<>();
        }
        modelAndView.addObject("usuarios", servicoUsuario.findAll());   
        modelAndView.addObject("itensMeusEmprestimos", itensMeusEmprestimos);            
        modelAndView.addObject("emprestimo", emprestimo);

        return modelAndView;
    }
    
    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/modal")
    public ModelAndView openModal() { 
        
        final List<TipoDeAtivo> tiposAtivos = servicoTipoDeAtivo.findTiposDeAtivosAtivos();
        ModelAndView modelAndView = new ModelAndView("emprestimos/modalItens");
        modelAndView.addObject("tiposAtivos", tiposAtivos);
        
        return modelAndView;
        
    }
//    
    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @PostMapping("/adicionar")
    public void adicionaItemEmprestimo(
        @Valid @ModelAttribute("id") Long id, String data
    ){

        LocalDate dataEmprestimo = LocalDateStringConverter.parse(data);
        
//      se o item não existir 
        if(!itensMeusEmprestimos
                .stream()
                .filter(
                        it -> it.getItemReservavel()
                                .getId()
                                .equals(id)
                ).findFirst()
                 .isPresent()
        ){

            ItemReservavel item = servicoItemReservavel.findById(id);
            EmprestimoItem emprestimoItem = new EmprestimoItem();
            emprestimoItem.setItemReservavel(item);
            emprestimoItem.setData(dataEmprestimo);
            itensMeusEmprestimos.add(emprestimoItem);

        }

    }
    
    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/remover-item/{id}")
    public ModelAndView removerItem(@PathVariable Long id){
        
        Optional i = itensMeusEmprestimos.stream().filter(it -> it.getItemReservavel().getId().equals(id)).findFirst();

        if(i.isPresent()){
            itensMeusEmprestimos.remove((EmprestimoItem)i.get());
        }

        return new ModelAndView("redirect:/emprestimos/formulario/"); 
    }

    

    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @PostMapping("/salvar")
    public ModelAndView salvar(@RequestParam(value = "usuario")Long usuario){

        System.out.println(usuario);
        List<UsuarioEmprestimo> usuarios = new ArrayList<UsuarioEmprestimo>();
        UsuarioEmprestimo funcionario = new UsuarioEmprestimo();
        funcionario.setUsuario(SessionFacade.getUsuarioLogado());
        funcionario.setTipoResponsavelEmprestimo(TipoResponsavelEmprestimo.FUNCIONARIO);
        
        UsuarioEmprestimo responsavel = new UsuarioEmprestimo();
        responsavel.setUsuario(servicoUsuario.findById(usuario));
        responsavel.setTipoResponsavelEmprestimo(TipoResponsavelEmprestimo.RESPONSAVEL);
        
        usuarios.add(responsavel);
        usuarios.add(funcionario);
        Emprestimo emprestimo = new Emprestimo(StatusEmprestimo.ATIVO, null, usuarios, itensMeusEmprestimos);
            
        servicoEmprestimo.salvar(emprestimo);
            
        itensMeusEmprestimos = new ArrayList<>();
        
        return new ModelAndView("redirect:/emprestimos/");

    }
//
////    @PreAuthorize("hasRole('ROLE_FUNCIONARIO')")
////    @GetMapping("/editar")
////    public ModelAndView buscar(@RequestParam(value = "id", required = true) Long id ){
////        return criaFormReserva(servicoReserva.findById(id));
////    }
//    
//    @PreAuthorize("hasRole('ROLE_USUARIO')")
//    @GetMapping("/detalhes")
//    public ModelAndView buscar(@RequestParam(value = "id", required = true) Long id ){
//        
//        return new ModelAndView(
//                "reservas/reservaDetalhes",
//                "reserva",
//                servicoReserva.findById(id)
//        );
//        
//    }
//    
//    @PreAuthorize("hasRole('ROLE_USUARIO')")
//    @GetMapping("/cancelar-item/{id}")
//    public ModelAndView cancelarItem(@PathVariable Long id ){
//        
//        ItemReserva itemReserva = servicoItemReserva.cancelarReserva(id);
//         
//        return new ModelAndView("redirect:/reservas/detalhes?id="+itemReserva.getReserva().getId());
//        
//    }
//    
//
    @PreAuthorize("hasRole('ROLE_USUARIO')")
    @GetMapping("/disponiveis-data")
    public ModelAndView buscaItensDisponiveis(@RequestParam(value = "data", required = true) String data){

        LocalDate localDate = LocalDateStringConverter.parse(data);

        List<ItemReservavel> itens = servicoItemReservavel
                .findDisponiveisBy(localDate);

        final List<TipoDeAtivo> tiposAtivos = servicoTipoDeAtivo.findTiposDeAtivosAtivos();

        ModelAndView modelAndView = new ModelAndView( "emprestimos/filtrarTiposItensAjax");
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

        ModelAndView modelAndView = new ModelAndView( "emprestimos/filtrarTiposItensAjax");
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

        ModelAndView modelAndView = new ModelAndView( "emprestimos/filtrarTiposItensAjax");
        modelAndView.addObject("tiposAtivos", tiposAtivos);
        modelAndView.addObject("itensReservaveis",  itens);            

        return modelAndView;

    }
	
}
