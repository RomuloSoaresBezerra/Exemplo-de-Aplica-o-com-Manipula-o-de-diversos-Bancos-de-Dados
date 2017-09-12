
package com.ifpb.ecommerce_exempBDs.DAO;

import com.ifpb.ecommerce_exempBDs.entidades.Pedido;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DAOMongoDB {
    
    private MongoClient cliente;
    private MongoDatabase database;
    private static MongoCollection<Document> colecao;

    public DAOMongoDB() {
        this.cliente = new MongoClient("localhost", 27017);
        this.database = cliente.getDatabase("mercado");
        this.colecao = database.getCollection("Pedido");
    }

    public MongoClient getCliente() {
        return cliente;
    }

    public void setCliente(MongoClient cliente) {
        this.cliente = cliente;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void setDatabase(MongoDatabase database) {
        this.database = database;
    }

    public MongoCollection<Document> getColecao() {
        return colecao;
    }

    public void setColecao(MongoCollection<Document> colecao) {
        this.colecao = colecao;
    }
    
    public void addRegistro(Pedido pedido){
        getColecao().insertOne(pedido.toDocument());
    }
    
    public void readRegistro(){
        Block<Document> printBlock = (final Document document)
                ->{
           
            Pedido ped = new Pedido().fromDocument(document);
            System.out.println(ped);
        };
        
        //Fazer em casa -> para montar o objeto
        //FindIterable<Document> lista = colecao.find();
        
//        while(lista.iterator().hasNext()){
//                    
//        }
        
        colecao.find().forEach(printBlock);
       
    }
       
    public void exitCliente(){
       getCliente().close();    
    }
        
       
    
}
