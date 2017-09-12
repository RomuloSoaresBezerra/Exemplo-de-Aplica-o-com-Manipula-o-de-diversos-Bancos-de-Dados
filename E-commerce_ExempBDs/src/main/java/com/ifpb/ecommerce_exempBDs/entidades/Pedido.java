package com.ifpb.ecommerce_exempBDs.entidades;

import org.bson.Document;

public class Pedido {
   
    public static int id;
    private Carrinho carrinho;
    private Cliente cliente;

    public Pedido() {
        
    }
    
    public Pedido(int id, Carrinho carrinho, Cliente cliente) {
        this.id = id;
        this.carrinho = carrinho;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", carrinho=" + carrinho + ", cliente=" + cliente + '}';
    }
    
    public Document toDocument(){
        Document doc = new Document()
                .append("id", id)
                .append("carrinho", carrinho.toDocument())
                .append("cliente", cliente.toDocument());
        return doc;
    } 
    
    public Pedido fromDocument(Document doc){
        id = doc.getInteger("id");
        carrinho = new Carrinho().fromDocument(
                doc.get("carrinho", Document.class));
        cliente = new Cliente().fromDocument(
                doc.get("cliente", Document.class));
        return this;
    }
    
}
