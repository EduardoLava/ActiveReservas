package br.com.active.reservas.servicos.impl;

import br.com.active.reservas.bean.emprestimo.EmprestimoItem;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.active.reservas.dao.RepositorioEmprestimoItem;
import br.com.active.reservas.servicos.IServicoBase;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
public class ServicoEmprestimoItem implements IServicoBase<EmprestimoItem, Long>{

    @Autowired
    private RepositorioEmprestimoItem repositorioEmprestimoItem;

	/*
	 * Save or update
	 */
	@Override
	public EmprestimoItem salvar(EmprestimoItem entidade) {
            
            
            return repositorioEmprestimoItem.save(entidade);
                
	}
	
	@Override
	public void delete(EmprestimoItem entidae) {
		this.repositorioEmprestimoItem.delete(entidae);
	}
	
	@Override
	public EmprestimoItem findById(Long id) {
		return this.repositorioEmprestimoItem
                        .findOne(id);
	}

	@Override
	public Iterable<EmprestimoItem> findAll() {
		return this.repositorioEmprestimoItem.findAll();
	}
        
        public List<EmprestimoItem> buscarPor(Long idUsuario){ 
           
            if(-1 == idUsuario.intValue()){
                return repositorioEmprestimoItem.findAll();
            }
            
            return repositorioEmprestimoItem.findByUsuario_id(idUsuario);
            
        }
        
        public void finalizarEmprestimo(EmprestimoItem emprestimoItem){
            emprestimoItem.setHoraDevolucao(LocalTime.now());
            repositorioEmprestimoItem.save(emprestimoItem);
            
        }
        
}
