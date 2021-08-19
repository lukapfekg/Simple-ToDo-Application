package db;

import org.hibernate.Session;

import java.util.List;

public interface Repository<T> {
    void persist(T t);
    List<T> getAll();
    void deleteRow(int id);
}
