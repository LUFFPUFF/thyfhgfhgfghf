package come.example.practiketaskspring1.service;

import java.util.Collection;

public interface DAOService<T> {

    T getById(Long id);
    Collection<T> getAll();
    boolean create(T entity);
    boolean update(Long id, T entity);
    boolean delete(Long id);
}
