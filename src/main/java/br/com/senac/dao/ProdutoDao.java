/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Produto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author marie
 */
public interface ProdutoDao extends BaseDao<Produto, Long>{
    List<Produto> pesquisarPorNome(String nome, Session sessao) throws HibernateException;
}