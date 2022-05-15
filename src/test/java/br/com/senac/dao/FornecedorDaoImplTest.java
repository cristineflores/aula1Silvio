/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Fornecedor;
import br.com.senac.util.GeradorUtil;
import static br.com.senac.util.GeradorUtil.gerarNome;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;//aqui não precisa chamar o geradorUtil.gerar...

/**
 *
 * @author marie
 */
public class FornecedorDaoImplTest {
    
    private Fornecedor fornecedor;
    private FornecedorDao fornecedorDao;
    private Session sessao;
    
    public FornecedorDaoImplTest() {
        fornecedorDao = new FornecedorDaoImpl();//vou dar new em cima da classe que implementa a interface
    }    

    //@Test
    public void testSalvar() {
        System.out.println("salvar");
        fornecedor = new Fornecedor("Fornecedor " + gerarNome());
        fornecedor.setDescricao("Teste teste teste...");
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.salvarOuAlterar(fornecedor, sessao);
        sessao.close();
        assertNotNull(fornecedor.getId());
    }
    
    @Test
    public void testAlterar() {
        System.out.println("salvar");
        buscarFornecedorBd();//esse método buscarFornecedorBd garante que tem alguém no banco.
        
        fornecedor.setNome("Fornecedor" + gerarNome());
        
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.salvarOuAlterar(fornecedor, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirConexao();
        Fornecedor fornecedorAlt = fornecedorDao.pesquisarPorId(fornecedor.getId(), sessao);
        sessao.close();
        assertEquals(fornecedor.getNome(), fornecedorAlt.getNome());
    }
    
    //@Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarFornecedorBd();
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.excluir(fornecedor, sessao);
        
        Fornecedor fornecedorExc = fornecedorDao.pesquisarPorId(fornecedor.getId(), sessao);//se não tiver nenhum id, devolve null.
        sessao.close();
        assertNull(fornecedorExc);//aqui ele verifica se está null, quer dizer que excluiu.
    }

    //@Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarFornecedorBd();
        sessao = HibernateUtil.abrirConexao();
        Fornecedor fornecedorPesquisado = fornecedorDao.pesquisarPorId(fornecedor.getId(), sessao);
        sessao.close();
        
        assertNotNull(fornecedorPesquisado);
    }   

    //@Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        buscarFornecedorBd();
        sessao = HibernateUtil.abrirConexao();
        int elemento = fornecedor.getNome().indexOf(" ");
        String nome = fornecedor.getNome().substring(0, elemento);
        List<Fornecedor> fornecedores = fornecedorDao.pesquisarPorNome(nome, sessao);
        sessao.close();
        //assertTrue(!fornecedores.isEmpty());//será acertado true se minha lista não for vazia    
        assertTrue(fornecedores.size() > 0);
    }
    //se eu chamar o método buscarFornecedorBd ele garante que tem alguém no banco. 
    public Fornecedor buscarFornecedorBd() {//encapsulamento publico pq outros métodos vão chamar
        //no sql normal seria: select * from fornecedor;
        String hql = "from Fornecedor";//no hibernate o fornecedor é a entidade
        sessao = HibernateUtil.abrirConexao(); 
        Query<Fornecedor> consulta = sessao.createQuery(hql);
        List<Fornecedor> fornecedores = consulta.getResultList();//se não encontrar ninguém ele cria um array vazio.
        sessao.close();
        if(fornecedores.isEmpty()) {//se estiver vazio chama o testeSalvar pra ter pelo menos um objeto dentro do Array
            testSalvar();
        }else {
            fornecedor = fornecedores.get(0); //aqui pega o usuário na primeira posição, o primeiro que estiver no BD.
        }        
        return fornecedor;
}
    
}
