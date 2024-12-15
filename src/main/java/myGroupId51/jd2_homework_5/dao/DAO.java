package myGroupId51.jd2_homework_5.dao;

import java.util.List;

public interface DAO <T>{
    void createTable();
    void save(T t);
    void update(T t);
    void delete(int id);
    T find(int id);
    List<T> findAll();
}
