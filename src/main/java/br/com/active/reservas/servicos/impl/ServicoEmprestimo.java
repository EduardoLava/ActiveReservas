package br.com.active.reservas.servicos.impl;

import br.com.active.reservas.bean.emprestimo.Emprestimo;
import br.com.active.reservas.bean.emprestimo.EmprestimoItem;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.active.reservas.dao.RepositorioEmprestimo;
import br.com.active.reservas.servicos.IServicoBase;
import java.time.LocalTime;

@Service
@Transactional
public class ServicoEmprestimo implements IServicoBase<Emprestimo, Long>{

    @Autowired
    private RepositorioEmprestimo repositorioEmprestimo;
    
    @Autowired
    private ServicoUsuarioEmprestimo servicoUsuarioEmprestimo;
    
    @Autowired
    private ServicoEmprestimoItem servicoEmprestimoItem;

	/*
	 * Save or update
	 */
	@Override
	public Emprestimo salvar(Emprestimo entidade) {
            
            Emprestimo emprestimo = repositorioEmprestimo.save(entidade);
            
            if(emprestimo != null){
                emprestimo.getEmprestimoItems().forEach(i -> { 
                    i.setEmprestimo(emprestimo);
                    i.setHoraInicio(LocalTime.now());
                    servicoEmprestimoItem.salvar(i);
                });
                
                emprestimo.getUsuarios().forEach(u ->{
                    u.setEmprestimo(emprestimo);
                    servicoUsuarioEmprestimo.salvar(u);
                });
                
            }
            
            return emprestimo;
                
	}
	
	@Override
	public void delete(Emprestimo entidae) {
		this.repositorioEmprestimo.delete(entidae);
	}
	
	@Override
	public Emprestimo findById(Long id) {
		return this.repositorioEmprestimo
                        .findOne(id);
	}

	@Override
	public Iterable<Emprestimo> findAll() {
		return this.repositorioEmprestimo.findAll();
	}
        
        
}
