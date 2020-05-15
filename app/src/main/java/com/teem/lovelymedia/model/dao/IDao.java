package com.teem.lovelymedia.model.dao;

/**
 * @author tangdi
 * @date 2020/05/15
 */
public interface IDao<T> {
    void insert(T... t);

    void update(T... t);

    void delete(T... t);

    void query(T... t);
}
