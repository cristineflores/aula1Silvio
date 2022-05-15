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
public abstract class BaseDaoImpl<T, ID> implements BaseDao<T, ID>{//o t representa todas as clásses de entidade
  //em cima o abstract diz que essa classe vai ter filho, diz que é uma classe pai   
    private Transaction transaction;//para salvarOuAlterar e exclhuir ele vai fazer uma transação com o BD pois vai alterar como estava antes

    @Override 
    public void salvarOuAlterar(T entidade, Session sessao) throws HibernateException {
        transaction = sessao.beginTransaction();//pra pesquisar não precisa
        sessao.saveOrUpdate(entidade);
        transaction.commit();//pra pesquisar não precisa
    }

    @Override
    public void excluir(T entidade, Session sessao) throws HibernateException {
        transaction = sessao.beginTransaction();
        sessao.delete(entidade);
        transaction.commit();
    }    
}
