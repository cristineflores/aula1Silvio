/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author marie
 */
public interface BaseDao<T, ID> { // o ID representa o tipo da chave primária
    
    //por default, antes do void tem public abstract: public abstract void salvarOuAlterar
    void salvarOuAlterar(T entidade, Session sessao) throws HibernateException; // o hibernate deixa fazer salvar ou alterar junto
    //se tiver id ele altera, se não tiver ele salva
    void excluir(T entidade, Session sessao) throws HibernateException;
    
    T pesquisarPorId(ID id, Session sessao) throws HibernateException;
}
