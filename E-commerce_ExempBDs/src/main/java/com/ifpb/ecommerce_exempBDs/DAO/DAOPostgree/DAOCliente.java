package com.ifpb.ecommerce_exempBDs.DAO.DAOPostgree;

import com.ifpb.ecommerce_exempBDs.conn.ConFactory;
import com.ifpb.ecommerce_exempBDs.entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOCliente {
    
     public boolean createCliente(Cliente c) throws ClassNotFoundException, SQLException {
         boolean retorno;
         try (Connection con = ConFactory.getConnection()) {
             PreparedStatement stmt = con.prepareStatement(
                     "INSERT INTO cliente (id, nome, email) VALUES (?,?,?)");
             stmt.setInt(1, c.getId());
             stmt.setString(2, c.getNome());
             stmt.setString(3, c.getEmail());
             retorno = stmt.executeUpdate() > 0;
         }
        return retorno;

    }
    
    public Cliente readCliente(int idCliente) throws ClassNotFoundException, SQLException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM cliente WHERE id = ?");

        stmt.setInt(1, idCliente);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Cliente c = new Cliente();
            
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));

            con.close();
            return c;
        } else {
            con.close();
            return null;
        }

    }
    
}
