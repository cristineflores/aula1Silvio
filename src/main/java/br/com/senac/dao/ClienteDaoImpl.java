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
import org.hibernate.query.Query;

/**
 *
 * @author marie
 */
public class ClienteDaoImpl extends BaseDaoImpl<Cliente, Long> implements ClienteDao{

    @Override
    public Cliente pesquisarPorId(Long id, Session sessao) throws HibernateException {
        Cliente cliente = sessao.get(Cliente.class, id);
        return cliente;
        
    }

    @Override
    public List<Cliente> pesquisarTodo(Session sessao) throws HibernateException {
        Query<Cliente> consulta = sessao.createQuery("from Cliente");
        return null;
    }

    @Override
    public List<Cliente> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
        Query<Cliente> consulta = sessao.createQuery("from Cliente where nome like :nomeHql");
        consulta.setParameter("nomeHql", "%" + nome + "%");
        return consulta.getResultList();
    }
    
}
