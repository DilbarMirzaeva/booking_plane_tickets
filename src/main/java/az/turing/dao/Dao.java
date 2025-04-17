package az.turing.dao;

import java.util.List;

public interface Dao<E,T> {

    List<E> getAll();
    E create(E entity);
    E update(E entity);
    void delete(T id);
    E getById(T id);

}
