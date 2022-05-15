/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.dao;

//import br.com.senac.entidade.Cliente;
import br.com.senac.entidade.Cliente;
import br.com.senac.entidade.Fornecedor;
import br.com.senac.entidade.Produto;
import br.com.senac.entidade.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Silvio
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory; //Singleton

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(Usuario.class);//cada classe que for criada tem que add essa linha com alterações
            cfg.addAnnotatedClass(Cliente.class);//cada classe que for criada tem que add essa linha com alterações
            cfg.addAnnotatedClass(Fornecedor.class);//cada classe que for criada tem que add essa linha com alterações
            cfg.addAnnotatedClass(Produto.class);//cada classe que for criada tem que add essa linha com alterações

            cfg.configure("/META-INF/hibernate.cfg.xml");
            StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().
                    applySettings(cfg.getProperties());
            sessionFactory = cfg.buildSessionFactory(build.build());
        } catch (HibernateException ex) {
            System.err.println("Erro ao criar Hibernate util." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session abrirConexao() {
        return sessionFactory.openSession();
    }
}
