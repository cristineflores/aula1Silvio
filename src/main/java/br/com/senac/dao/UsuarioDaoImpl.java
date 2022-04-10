/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author marie
 */
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Long> implements UsuarioDao{

    @Override
    public Usuario pesquisarPorId(Long id, Session sessao) throws HibernateException {
        Usuario usuario = sessao.get(Usuario.class, id);
        return usuario;
    }
    
    
}
