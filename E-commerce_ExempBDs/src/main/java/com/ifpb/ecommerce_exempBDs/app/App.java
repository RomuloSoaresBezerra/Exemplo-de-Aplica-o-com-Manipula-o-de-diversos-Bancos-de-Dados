/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.ecommerce_exempBDs.app;

import com.ifpb.ecommerce_exempBDs.DAO.DAOMongoDB;
import com.ifpb.ecommerce_exempBDs.entidades.Carrinho;
import com.ifpb.ecommerce_exempBDs.entidades.Cliente;
import com.ifpb.ecommerce_exempBDs.entidades.ItemCarrinho;
import com.ifpb.ecommerce_exempBDs.entidades.Pedido;
import com.ifpb.ecommerce_exempBDs.entidades.Produto;
import java.sql.SQLException;

/**
 *
 * @author romulo
 */
public class App {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        //Produtos carrinho
        Produto sabao = new Produto(0, "sabão", 2.5);
        Produto cafe = new Produto(0, "café", 5.0);
        
        //Itens carrinho
        ItemCarrinho itemSabao = new ItemCarrinho(4, sabao);
        ItemCarrinho itemCafe = new ItemCarrinho(5, cafe);
            
        //Carrinho
        Carrinho carrinho = new Carrinho();
        carrinho.setId(1);
        carrinho.addItens(itemSabao);
        carrinho.addItens(itemCafe);
        
        Cliente cliMercado = new Cliente();
        cliMercado.setId(0);
        cliMercado.setNome("Rômulo");
        cliMercado.setEmail("bromulosoares@gmail.com");
          
        Pedido pedido = new Pedido(0, carrinho, cliMercado);
        
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
           
    }
    
}
