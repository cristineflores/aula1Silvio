/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Fornecedor;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author marie
 */
public class FornecedorDaoImpl extends BaseDaoImpl<Fornecedor, Long> implements FornecedorDao{

    @Override
    public Fornecedor pesquisarPorId(Long id, Session sessao) throws HibernateException {
        Fornecedor fornecedor = sessao.get(Fornecedor.class, id);
        return fornecedor;        
    }   

    @Override
    public List<Fornecedor> pesquisarPorNome(String nome, Session sessao) throws HibernateException {//pra cada linha dessa faz a de baixo também
        Query<Fornecedor> consulta = sessao.createQuery("from Fornecedor where nome like :nomeHql");
        consulta.setParameter("nomeHql", "%" + nome + "%");
        return consulta.getResultList();
    }
    
}

