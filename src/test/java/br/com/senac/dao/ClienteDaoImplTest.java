/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Cliente;
import br.com.senac.util.GeradorUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marie
 */
public class ClienteDaoImplTest {

    private Cliente cliente;
    private ClienteDao clienteDao;
    private Session sessao;

    public ClienteDaoImplTest() {
        clienteDao = new ClienteDaoImpl();
    }
    
    //@Test
    public void testSalvar() {
        System.out.println("salvar");
        cliente = new Cliente(null, GeradorUtil.gerarNome(), GeradorUtil.gerarEmail(), GeradorUtil.gerarCpf(), GeradorUtil.gerarRG());
        sessao = HibernateUtil.abrirConexao();
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getId());
    }
    //@Test
    public void testAlterar() {
        System.out.println("salvar");
        buscarClienteBd();
        
        cliente.setNome(GeradorUtil.gerarNome());
        cliente.setEmail(GeradorUtil.gerarEmail());
        
        sessao = HibernateUtil.abrirConexao();
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        
        Cliente clienteAlt = clienteDao.pesquisarPorId(cliente.getId(), sessao);
        assertEquals(cliente.getNome(), clienteAlt.getNome());
        assertEquals(cliente.getEmail(), clienteAlt.getEmail());
    } 
    
    //@Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        clienteDao.excluir(cliente, sessao);
        
        Cliente usuarioExc = clienteDao.pesquisarPorId(cliente.getId(), sessao);
        sessao.close();
        assertNull(usuarioExc);
    }

    //@Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        Cliente usuarioPesquisado = clienteDao.pesquisarPorId(cliente.getId(), sessao);
        sessao.close();
        
        assertNotNull(usuarioPesquisado);
    }
    
    //@Test
    public void testPesquisarTodo() {
        System.out.println("pesquisarTodo");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        List<Cliente> clientes = clienteDao.pesquisarTodo(sessao);
        sessao.close();
        assertTrue(!clientes.isEmpty());//será acertado true se minha lista não for vazia
    }
    

    //@Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        int elemento = cliente.getNome().indexOf(" ");
        String nome = cliente.getNome().substring(0, elemento);
        List<Cliente> usuarios = clienteDao.pesquisarPorNome(nome, sessao);
        sessao.close();
        assertTrue(!usuarios.isEmpty());//será acertado true se minha lista não for vazia
    }
    
    public Cliente buscarClienteBd() {
        //no sql normal seria: select * from usuario;
        String hql = "from Cliente";
        sessao = HibernateUtil.abrirConexao(); 
        Query<Cliente> consulta = sessao.createQuery(hql);
        List<Cliente> clientes = consulta.list();
        sessao.close();
        if(clientes.isEmpty()) {//se estiver vazio chama o testeSalvar pra ter pelo menos um objeto dentro do Array
            testSalvar();
        }else {
            cliente = clientes.get(0); //aqui pega o usuário na primeira posição, o primeiro que estiver no BD.
        }        
        return cliente;
    }    
}
