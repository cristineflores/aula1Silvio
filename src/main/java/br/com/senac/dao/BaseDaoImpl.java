/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import org.hibernate.*;

/**
 *
 * @author marie
 * @param <T> representa qualquer entidade
 * @param <ID> representa o tipo do id
 */
public abstract class BaseDaoImpl<T, ID> implements BaseDao<T, ID>{
    
    private Transaction transaction;

    @Override
    public void salvarOuAlterar(T entidade, Session sessao) throws HibernateException {
        transaction = sessao.beginTransaction();
        sessao.saveOrUpdate(entidade);
        transaction.commit();
    }

    @Override
    public void excluir(T entidade, Session sessao) throws HibernateException {
        transaction = sessao.beginTransaction();
        sessao.delete(entidade);
        transaction.commit();
    }    
}
