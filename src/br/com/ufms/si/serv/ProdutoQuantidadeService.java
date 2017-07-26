package br.com.ufms.si.serv;

import br.com.ufms.si.model.Evento;
import br.com.ufms.si.model.Produto;
import br.com.ufms.si.model.ProdutoQuantidade;
import br.com.ufms.si.serv.ProdutoQuantidadeService.ProdutoQuantidadeSearch;

public interface ProdutoQuantidadeService extends AbstractService<ProdutoQuantidade, ProdutoQuantidadeSearch> {

	public interface ProdutoQuantidadeSearch {

		Evento getEvento();

		Produto getProduto();

	}

}
