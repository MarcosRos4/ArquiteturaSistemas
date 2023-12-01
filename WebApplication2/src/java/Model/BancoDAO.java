/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


/**
 * 
 * @author marcos
 */


public class BancoDAO {
    
    private EntityManager manager;
    
    private void conectar(){
        manager = Persistence.createEntityManagerFactory(
                "WebApplication2PU").createEntityManager();
    }
    
    public <T> int cadastrar(T obj){
        conectar();
        try{
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
            return 1;
        }   
        catch(Exception erro){
            return 0;
        }
    }
    
    public <T>List listar(String queryNomeada, Class<T> classe){
        conectar();
        try{
            return manager.createNamedQuery(queryNomeada, classe).getResultList();
        } catch(NoResultException erro){
            return null;
        }
    }
    
    public <T> Produto listarUm(Integer idproduto){
        conectar();
            
            Produto produto_encontrado = manager.find(Produto.class, idproduto);
            
            if(produto_encontrado == null){
                return null;
            }
            else{
                return produto_encontrado;
            }
    }
    
    public <T> int deletar(Integer obj){
        conectar();
        try{
            Produto produto = this.listarUm(obj);
            manager.getTransaction().begin();
            manager.remove(produto);
            manager.getTransaction().commit();
            return 1;
        }   
        catch(Exception erro){
            return 0;
        }
    }
    
    public <T> int editar(Integer idproduto, Produto novoproduto){
        conectar();
        try{
            Produto produto = this.listarUm(idproduto);
            manager.getTransaction().begin();
            produto.setProdutonome(novoproduto.getProdutonome());
            produto.setProdutomarca(novoproduto.getProdutomarca());
            produto.setProdutopreco(novoproduto.getProdutopreco());
            manager.getTransaction().commit();
            return 1;
        }   
        catch(Exception erro){
            return 0;
        }
    }
    
}