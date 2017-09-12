/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.ecommerce_exempBDs.entidades;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author romulo
 */
public class Carrinho {
    
    public int id;
    private List<Document> cesta;

    public Carrinho() {
        this.id = id;
        cesta = new ArrayList<>();
    }
    
    public Carrinho(int id, List cesta) {
        this.id = id;
        cesta = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Document> getCesta() {
        return cesta;
    }

    public void setCesta(List<Document> cesta) {
        this.cesta = cesta;
    }

    @Override
    public String toString() {
        return "Carrinho{" + "cesta=" + cesta + '}';
    }
   
    public void addItens(ItemCarrinho item){
        cesta.add(item.toDocument());
    }
    
    public double calcularTotal(){
        double retorno = 0;
        for(int i = 0; i< cesta.size(); i++){
            //retorno += cesta.get(i).calcularSubtotal();
        }
        return retorno;
    }
    
     public Document toDocument(){
        Document doc = new Document()
                .append("id", id)
                .append("cesta", cesta);
        return doc;
    } 
    
    public Carrinho fromDocument(Document doc){
        id = doc.getInteger("id");
        cesta = doc.get("cesta", ArrayList.class);
        return this;
    }
    
}
