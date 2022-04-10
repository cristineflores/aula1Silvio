/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Usuario;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marie
 */
public class UsuarioDaoImplTest {
    
    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private Session sessao;
    
    public UsuarioDaoImplTest() {
        usuarioDao = new UsuarioDaoImpl();
    }

    @Test
    public void testSalvar() {
    System.out.println("salvar");
    usuario = new Usuario(null, "João", "@joao", "12345");
    sessao = HibernateUtil.abrirConexao();
    usuarioDao.salvarOuAlterar(usuario, sessao);
    sessao.close(); 
        assertNotNull(usuario.getId());
    }
    
    //@Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");        
    }
    
}
