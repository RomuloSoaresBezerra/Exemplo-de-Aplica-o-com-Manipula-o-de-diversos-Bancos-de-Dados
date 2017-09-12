package com.ifpb.ecommerce_exempBDs.DAO;

import com.ifpb.ecommerce_exempBDs.entidades.Cliente;
import com.ifpb.ecommerce_exempBDs.entidades.Produto;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Values;

public class DAONeo4j {
    
    private final Driver driver;
    private final Session session;
    
    public DAONeo4j(){
        driver = GraphDatabase.driver("bolt://localhost:7687", 
                AuthTokens.basic("neo4j", "admin"));
        session = driver.session();
    }
    
    public void insertNode(Object entidade){
        if(entidade.getClass().equals(Cliente.class)){
            Cliente c = (Cliente) entidade;
            session.run("CREATE (:Cliente{id: $id, nome: $nome, email: $email})",
                Values.parameters("id", c.getId(), 
                        "nome", c.getNome(), "email", c.getEmail()));
        }else{
            Produto p = (Produto) entidade;
            session.run("CREATE (:Produto{cod: $cod, descricao: $descricao, preco: $preco})",
                Values.parameters("cod", p.getCod(), 
                        "descricao", p.getDescricao(), "preco", p.getPreco()));
            
        }
    }
    
    public void createRelationship(Cliente c, Produto p){
        session.run("MATCH (c:Cliente{id:$id}), (p:Produto{cod:$cod}) "
                + "CREATE (c)-[:COMPROU]->(p)",
                Values.parameters("id", c.getId(), 
                        "cod", p.getCod()));
    }
    
    //Busca e exibe o resultado da mineração de sugestao para venda d eproduto: 
    //se Cliente comprou produto x, é verificado que os clientes que comprou 
    //produto x tambem compraram produtos x,y e n. A função retorna essa sugestão
    public void minningDataBuyProduct(Cliente c){
        StatementResult result = session.run("MATCH (p:Produto),(pAll:Produto), (c:Cliente) " +
                "WHERE (c:Cliente{id:$id})-[:COMPROU]->(p:Produto)<-[:COMPROU]-(:Cliente)-[:COMPROU]->(pAll:Produto) " +
                    "RETURN pAll.descricao as Produtos",
                Values.parameters("id", c.getId()));    
        
        //Percorre o grafo e imprime resultado
        while (result.hasNext()) {            
            System.out.println(result.next().get("Produtos"));
        }
    }
    
    public void sessionClose(){
        session.close();
    }
    
}
