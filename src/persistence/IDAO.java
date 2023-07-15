package persistence;

import java.util.List;

public interface IDAO<E, ID> {
    List<E> getAll();

    E getByID(ID id);

    int create(E e);

    int update(E e);

    int delete(ID id);
}