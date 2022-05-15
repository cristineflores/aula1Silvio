/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

import br.com.senac.entidade.Fornecedor;
import br.com.senac.entidade.Produto;
import br.com.senac.util.GeradorUtil;
import static br.com.senac.util.GeradorUtil.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marie
 */
public class ProdutoDaoImplTest {

    private Produto produto;
    private ProdutoDao produtoDao;
    private Session sessao;

    public ProdutoDaoImplTest() {
        produtoDao = new ProdutoDaoImpl();
    }

    // @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
    }

    //@Test
    public void testSalvar() {
        System.out.println("salvar");
        produto = new Produto(gerarNome(), Integer.parseInt(gerarNumero(2)), Double.parseDouble(gerarNumero(4)));

        FornecedorDaoImplTest fdit = new FornecedorDaoImplTest();//aqui chamamos o método buscarFornecedorBd lá da classe FornecedorDaoImplTeste 
        Fornecedor fornecedor = fdit.buscarFornecedorBd();
        produto.setFornecedor(fornecedor);//nessa linha que o produto encherga o fornecedor
        sessao = HibernateUtil.abrirConexao();
        produtoDao.salvarOuAlterar(produto, sessao);
        sessao.close();
        assertNotNull(produto.getId());
    }

    //----ver eager, lazy-----
    // @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarProdutoBd();
        produto.setNome("Produto alterado!");
        sessao = HibernateUtil.abrirConexao();
        produtoDao.salvarOuAlterar(produto, sessao);
        sessao.close();
        
        sessao = HibernateUtil.abrirConexao();
        Produto produtoAlt = produtoDao.pesquisarPorId(produto.getId(), sessao);
        sessao.close();
        assertEquals(produto.getNome(), produtoAlt.getNome());
    }
    
    //@Test
//    public void testExcluir() {
//        System.out.println("excluir");
//        buscarFornecedorBd();
//        sessao = HibernateUtil.abrirConexao();
//        fornecedorDao.excluir(fornecedor, sessao);
//        
//        Fornecedor fornecedorExc = fornecedorDao.pesquisarPorId(fornecedor.getId(), sessao);//se não tiver nenhum id, devolve null.
//        sessao.close();
//        assertNull(fornecedorExc);//aqui ele verifica se está null, quer dizer que excluiu.
//    }

    // @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
    }

    public Produto buscarProdutoBd() {
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Produto");        
        List<Produto> produtos = consulta.getResultList();
        sessao.close();
        if (produtos.isEmpty()) {
            testSalvar();
        } else {
            produto = produtos.get(0);
        }
        return produto;
    }

}
