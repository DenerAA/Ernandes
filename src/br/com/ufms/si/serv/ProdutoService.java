package br.com.ufms.si.serv;

import br.com.ufms.si.model.Produto;
import br.com.ufms.si.serv.ProdutoService.ProdutoSearch;

public interface ProdutoService extends AbstractService<Produto, ProdutoSearch> {

	public interface ProdutoSearch {

		String getNome();

		String getDescricao();
	}

}
