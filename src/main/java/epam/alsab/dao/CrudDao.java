package epam.alsab.dao;

public interface CrudDao<T, ID> extends Dao<T> {

    void create(T obj);

    T read(ID id);

    void update(T obj);

    void delete(ID id);
}
