package br.com.ufms.si.serv;

import java.util.List;

public interface AbstractService<T, S> {

	void create(T entity);

	T update(T entity);

	T load(Integer id);

	List<T> search(S search);

	List<T> loadAll();

	void delete(Long id);

	Integer loadMax();

}
