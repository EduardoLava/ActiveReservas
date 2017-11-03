package br.com.active.reservas.servicos;

import br.com.active.reservas.bean.usuario.StatusUsuario;
import br.com.active.reservas.bean.usuario.TipoUsuario;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.active.reservas.bean.usuario.Usuario;
import br.com.active.reservas.dao.RepositorioUsuario;
import java.util.List;

@Service
@Transactional
public class ServicoUsuario implements ServicoBase<Usuario, Long>{

	/**
	 * equivale ao @Inject do cdi
	 */
	@Autowired
	private RepositorioUsuario repositorioUsuario;

	/*
	 * Save or update
	 */
	@Override
	public Usuario salvar(Usuario entidade) {
		return this.repositorioUsuario.save(entidade);
	}
	
	@Override
	public void delete(Usuario entidae) {
		this.repositorioUsuario.delete(entidae);
	}
	
	@Override
	public Usuario findById(Long id) {
		return this.repositorioUsuario.findOne(id);
	}

	@Override
	public Iterable<Usuario> findAll() {
		return this.repositorioUsuario.findAll();
	}
        
        public List<Usuario> findFuncionariosAtivos(){
            
            return this.repositorioUsuario
                    .findByTipoUsuarioAndStatusUsuario(
                            TipoUsuario.FUNCIONARIO,
                            StatusUsuario.ATIVO
                    );
            
        }
        
        public Usuario buscarPorLogin(String login){
            return this.repositorioUsuario.findByLogin(login);
        }
	
}
