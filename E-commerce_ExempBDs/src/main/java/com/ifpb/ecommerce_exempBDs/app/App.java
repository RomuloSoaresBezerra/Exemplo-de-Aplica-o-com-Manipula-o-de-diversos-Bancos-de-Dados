/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.ecommerce_exempBDs.app;

import com.ifpb.ecommerce_exempBDs.DAO.DAOMongoDB;
import com.ifpb.ecommerce_exempBDs.DAO.DAONeo4j;
import com.ifpb.ecommerce_exempBDs.entidades.Carrinho;
import com.ifpb.ecommerce_exempBDs.entidades.Cliente;
import com.ifpb.ecommerce_exempBDs.entidades.ItemCarrinho;
import com.ifpb.ecommerce_exempBDs.entidades.Pedido;
import com.ifpb.ecommerce_exempBDs.entidades.Produto;
import java.sql.SQLException;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

/**
 *
 * @author romulo
 */
public class App {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
//        //Produtos carrinho
//        Produto sabao = new Produto(0, "sabão", 2.5);
//        Produto cafe = new Produto(0, "café", 5.0);
//        
//        //Itens carrinho
//        ItemCarrinho itemSabao = new ItemCarrinho(4, sabao);
//        ItemCarrinho itemCafe = new ItemCarrinho(5, cafe);
//            
//        //Carrinho
//        Carrinho carrinho = new Carrinho();
//        carrinho.setId(1);
//        carrinho.addItens(itemSabao);
//        carrinho.addItens(itemCafe);
//        
//        Cliente cliMercado = new Cliente();
//        cliMercado.setId(0);
//        cliMercado.setNome("Rômulo");
//        cliMercado.setEmail("bromulosoares@gmail.com");
//          
//        Pedido pedido = new Pedido(0, carrinho, cliMercado);
        
        //---- DAOProduto --------------------------------------
//        DAOProduto daoProduto = new DAOProduto();
//        daoProduto.createProduto(cafe);
        
        //---- DAOCliente --------------------------------------
//        DAOCliente daoCliente = new DAOCliente();
//        daoCliente.createCliente(cliMercado);
        
//        //---- DAORedis --------------------------------------
//        DAORedis daoRedis = new DAORedis();
//        
//        daoRedis.addRegistro(carrinho);
//        
//        daoRedis.deletRegistro(carrinho);
//        
//        System.out.println(daoRedis.readRegistro("0"));
        
        
        //---- DAOMongoDB --------------------------------------
//        DAOMongoDB daoMongoBD = new DAOMongoDB();
//        
//        daoMongoBD.addRegistro(pedido);
//        
//        daoMongoBD.readRegistro();
//        
//        daoMongoBD.exitCliente();


        //---- EXEMPLO MANIPULAÇÃO NEO4J {esta no dao - MAntive aqui por questao
        //de segurança para apresentação}-----------------------
        
//        Driver driver = GraphDatabase.driver("bolt://localhost:7687", 
//                AuthTokens.basic("neo4j", "admin"));
//        
//        Session session = driver.session();
//        
//        Cliente romulo = new Cliente(1, "romulo", "romulo@gmail.com");
//        Cliente renan = new Cliente(2, "renan", "renan@gmail.com");
//        Cliente raissa = new Cliente(3, "raissa", "raissa@gmail.com");
//        Cliente dad = new Cliente(4, "Dad", "dad@gmail.com");
//        
//        //Cria Clientes no Neo4j
//        session.run("CREATE (:Cliente{id: $id, nome: $nome, email: $email})",
//                Values.parameters("id", romulo.getId(), 
//                        "nome", romulo.getNome(), "email", romulo.getEmail()));
//        session.run("CREATE (:Cliente{id: $id, nome: $nome, email: $email})",
//                Values.parameters("id", renan.getId(), 
//                        "nome",renan.getNome(), "email", renan.getEmail()));
//        session.run("CREATE (:Cliente{id: $id, nome: $nome, email: $email})",
//                Values.parameters("id", raissa.getId(), 
//                        "nome", raissa.getNome(), "email", raissa.getEmail()));
//        session.run("CREATE (:Cliente{id: $id, nome: $nome, email: $email})",
//                Values.parameters("id", dad.getId(), 
//                        "nome", dad.getNome(), "email", dad.getEmail()));
//        
//        Produto sabao = new Produto(1, "sabão", 2.5);
//        Produto cafe = new Produto(2, "café", 2.5);
//        Produto feijao = new Produto(3, "feijão", 2.5);
//        Produto milho = new Produto(4, "millho", 2.5);
//        
//        //Cria Produtos no Neo4j
//        session.run("CREATE (:Produto{cod: $cod, descricao: $descricao, preco: $preco})",
//                Values.parameters("cod", sabao.getCod(), 
//                        "descricao", sabao.getDescricao(), "preco", sabao.getPreco()));
//        session.run("CREATE (:Produto{cod: $cod, descricao: $descricao, preco: $preco})",
//                Values.parameters("cod", cafe.getCod(), 
//                        "descricao", cafe.getDescricao(), "preco", cafe.getPreco()));
//        session.run("CREATE (:Produto{cod: $cod, descricao: $descricao, preco: $preco})",
//                Values.parameters("cod", feijao.getCod(), 
//                        "descricao", feijao.getDescricao(), "preco", feijao.getPreco()));
//        session.run("CREATE (:Produto{cod: $cod, descricao: $descricao, preco: $preco})",
//                Values.parameters("cod", milho.getCod(), 
//                        "descricao", milho.getDescricao(), "preco", milho.getPreco()));
//        
//        //Cria relacionamentos de Clientes com Produtos
//        session.run("MATCH (c:Cliente{id:$id}), (p:Produto{cod:$cod}) "
//                + "CREATE (c)-[:COMPROU]->(p)",
//                Values.parameters("id", romulo.getId(), 
//                        "cod", sabao.getCod()));
//        session.run("MATCH (c:Cliente{id:$id}), (p:Produto{cod:$cod}) "
//                + "CREATE (c)-[:COMPROU]->(p)",
//                Values.parameters("id", renan.getId(), 
//                        "cod", sabao.getCod()));
//        session.run("MATCH (c:Cliente{id:$id}), (p:Produto{cod:$cod}) "
//                + "CREATE (c)-[:COMPROU]->(p)",
//                Values.parameters("id", raissa.getId(), 
//                        "cod", sabao.getCod()));
//        session.run("MATCH (c:Cliente{id:$id}), (p:Produto{cod:$cod}) "
//                + "CREATE (c)-[:COMPROU]->(p)",
//                Values.parameters("id", dad.getId(), 
//                        "cod", sabao.getCod()));
//        session.run("MATCH (c:Cliente{id:$id}), (p:Produto{cod:$cod}) "
//                + "CREATE (c)-[:COMPROU]->(p)",
//                Values.parameters("id", dad.getId(), 
//                        "cod", milho.getCod()));
//        session.run("MATCH (c:Cliente{id:$id}), (p:Produto{cod:$cod}) "
//                + "CREATE (c)-[:COMPROU]->(p)",
//                Values.parameters("id", renan.getId(), 
//                        "cod", cafe.getCod()));
//        session.run("MATCH (c:Cliente{id:$id}), (p:Produto{cod:$cod}) "
//                + "CREATE (c)-[:COMPROU]->(p)",
//                Values.parameters("id", renan.getId(), 
//                        "cod", feijao.getCod()));
//        
//        //Executa a busca
//        StatementResult result = session.run("MATCH (p:Produto),(pAll:Produto), (c:Cliente) " +
//                "WHERE (c:Cliente{id:$id})-[:COMPROU]->(p:Produto)<-[:COMPROU]-(:Cliente)-[:COMPROU]->(pAll:Produto) " +
//                    "RETURN pAll.descricao as Produtos",
//                Values.parameters("id", raissa.getId()));    
//        
//        //Percorre o grafo e imprime resultado
//        while (result.hasNext()) {            
//            System.out.println(result.next().get("Produtos"));
//        }
//
//        session.close();
        
        //--- Manipulando dados no Neo4j-------------------------------
        Cliente romulo = new Cliente(1, "romulo", "romulo@gmail.com");
        Cliente renan = new Cliente(2, "renan", "renan@gmail.com");
        Cliente raissa = new Cliente(3, "raissa", "raissa@gmail.com");
        Cliente dad = new Cliente(4, "Dad", "dad@gmail.com");

        Produto sabao = new Produto(1, "sabão", 2.5);
        Produto cafe = new Produto(2, "café", 2.5);
        Produto feijao = new Produto(3, "feijão", 2.5);
        Produto milho = new Produto(4, "millho", 2.5);
        
        DAONeo4j daoNeo4j = new DAONeo4j();
        
        daoNeo4j.insertNode(romulo);
        daoNeo4j.insertNode(renan);
        daoNeo4j.insertNode(raissa);
        daoNeo4j.insertNode(dad);
        
        daoNeo4j.insertNode(sabao);
        daoNeo4j.insertNode(cafe);
        daoNeo4j.insertNode(feijao);
        daoNeo4j.insertNode(milho);
        
        daoNeo4j.createRelationship(romulo, sabao);
        daoNeo4j.createRelationship(renan, sabao);
        daoNeo4j.createRelationship(raissa, sabao);
        daoNeo4j.createRelationship(dad, sabao);
        daoNeo4j.createRelationship(renan, cafe);
        daoNeo4j.createRelationship(renan, feijao);
        daoNeo4j.createRelationship(dad, milho);
        
        daoNeo4j.minningDataBuyProduct(raissa);
        
        daoNeo4j.sessionClose();

    }
    
}
