package com.ifpb.ecommerce_exempBDs.DAO.DAOPostgree;

import com.ifpb.ecommerce_exempBDs.conn.ConFactory;

import com.ifpb.ecommerce_exempBDs.entidades.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOProduto {

    public boolean createProduto(Produto p) throws ClassNotFoundException, SQLException {
        boolean retorno;
        try (Connection con = ConFactory.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO produto (id, descricao, preco) VALUES (?,?,?)");
            stmt.setInt(1, p.getCod());
            stmt.setString(2, p.getDescricao());
            stmt.setDouble(3, p.getPreco());
            retorno = stmt.executeUpdate() > 0;
        }
        return retorno;

    }
    
    public Produto readProduto(int idProduto) throws ClassNotFoundException, SQLException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM produto WHERE id = ?");

        stmt.setInt(1, idProduto);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Produto p = new Produto();
            
            p.setCod(rs.getInt("id"));
            p.setDescricao(rs.getString("descricao"));
            p.setPreco(rs.getDouble("preco"));

            con.close();
            return p;
        } else {
            con.close();
            return null;
        }

    }
 

}
