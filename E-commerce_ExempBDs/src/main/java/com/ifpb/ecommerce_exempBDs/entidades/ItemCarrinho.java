/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.ecommerce_exempBDs.entidades;

import org.bson.Document;

/**
 *
 * @author romulo
 */
public class ItemCarrinho {
   
    private int quantidade;
    private Produto produto;

    public ItemCarrinho(){
        
    }
    
    public ItemCarrinho(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "ItemCarrinho{" + "quantidade=" + quantidade + ", produto=" + produto + '}';
    }
    
    public double calcularSubtotal(){
        return quantidade * produto.getPreco();
    }
    
     public Document toDocument(){
        Document doc = new Document()
                .append("quantidade", quantidade)
                .append("produto", produto.toDocument());
        return doc;
    } 
    
    public ItemCarrinho fromDocument(Document doc){
        quantidade = doc.getInteger("quantidade");
        produto = new Produto().fromDocument(
                doc.get("produto", Document.class));
        return this;
    }
    
}
