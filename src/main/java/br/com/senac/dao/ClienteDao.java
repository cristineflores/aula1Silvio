/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
/**
 *
 * @author marie
 */
public interface ClienteDao extends BaseDao<Cliente, Long>{
    List<Cliente> pesquisarTodo(Session sessao) throws HibernateException;
    
    List<Cliente> pesquisarPorNome(String nome, Session sessao) throws HibernateException;        
}
    
