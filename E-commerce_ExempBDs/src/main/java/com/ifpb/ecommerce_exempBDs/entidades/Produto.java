package com.ifpb.ecommerce_exempBDs.entidades;

import org.bson.Document;

public class Produto {
    
    private int cod;
    private String descricao;
    private double preco;

    public Produto(int cod, String descricao, double preco) {
        this.cod = cod;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto() {
        
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" + "cod=" + cod + ", descricao=" + descricao 
                + ", preco=" + preco + '}';
    } 
    
     public Document toDocument(){
        Document doc = new Document()
                .append("cod", cod)
                .append("descricao", descricao)
                .append("preco", preco);
        return doc;
    }
    
    public Produto fromDocument(Document doc){
        cod = doc.getInteger("cod");
        descricao = doc.getString("descricao");
        preco = doc.getDouble("preco");
        return this;
    }
    
}
