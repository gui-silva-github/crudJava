package dao;

import model.Usuario;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Crud {
    
    // CRUD - Create, Read, Update e Delete

    // C 

    public void save(Usuario usuario){

        // Instruction SQL

        String sql = "INSERT INTO usuarios (nome, idade, email, senha, dt_cadastro) VALUES (?, ?, ?, ?, ?)";

        // Connection

        Connection conn = null;

        // Prepared Statement

        PreparedStatement pstm = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            // Using the getters and setters

            pstm.setString(1, usuario.getNome());
            pstm.setInt(2, usuario.getIdade());
            pstm.setString(3, usuario.getEmail());
            pstm.setString(4, usuario.getSenha());
            pstm.setDate(5, new Date (usuario.getDt_cadastro().getTime()));

            // Executing the "pstm"

            pstm.execute();

            System.out.print("Usuário -> " + usuario.getNome() + " -> cadastrado com sucesso!");

        } catch (Exception e){

            e.printStackTrace();

        } finally {

            try {

                // Closing the structures

                if (pstm!=null){ pstm.close(); };
                if (conn!=null) { conn.close(); };

            } catch (Exception e){

                e.printStackTrace();

            }

        }

    }

    // R

    public List<Usuario> getUsuarios() throws SQLException {

        // Instruction SQL

        String sql = "SELECT * FROM usuarios";

        // List

        List<Usuario> usuarios = new ArrayList<Usuario>();

        // Connection

        Connection conn = null;

        // Prepared Statement

        PreparedStatement pstm = null;

        // Result Set

        ResultSet rset = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            // Saving the data

            rset = pstm.executeQuery();

            // While contains data

            while (rset.next()){

                // Defines a user

                Usuario usuario = new Usuario();
				
				usuario.setId(rset.getInt("id"));
                usuario.setNome(rset.getString("nome"));
                usuario.setIdade(rset.getInt("idade"));
				usuario.setEmail(rset.getString("email"));
				usuario.setSenha(rset.getString("senha"));
				usuario.setDt_cadastro(rset.getDate("dt_cadastro"));

                // Adding to list

                usuarios.add(usuario);

            }

        } catch (Exception e){

            e.printStackTrace();

        } finally {

            try {

                // Closing the structures

                if (rset!=null){ rset.close(); };
                if (pstm!=null) { pstm.close(); };
                if (conn!=null) { conn.close(); };

            } catch (Exception e){

                e.printStackTrace();

            }

        }

        return usuarios;

    }

    // U

    public void update(Usuario usuario){

         // Instruction SQL

         String sql = "UPDATE usuarios set nome = ?, idade = ?, email = ?, senha = ?, dt_cadastro = ? WHERE id = ?";

         // Connection

        Connection conn = null;

        // Prepared Statement

        PreparedStatement pstm = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            // Using the getters and setters

            pstm.setString(1, usuario.getNome());
            pstm.setInt(2, usuario.getIdade());
            pstm.setString(3, usuario.getEmail());
            pstm.setString(4, usuario.getSenha());
            pstm.setDate(5, new Date(usuario.getDt_cadastro().getTime()));
            
            pstm.setInt(6, usuario.getId());

            // Executing the "pstm"

            pstm.execute();

            System.out.print("Usuário -> " + usuario.getNome() + " -> atualizado com sucesso!");

        } catch (Exception e){

            e.printStackTrace();

        } finally {

            try {

                // Closing the structures

                if (pstm!=null){ pstm.close(); };
                if (conn!=null) { conn.close(); };

            } catch (Exception e){

                e.printStackTrace();

            }

        }

    }

    // D 

    public void deleteById(int id){

        // Instruction SQL

        String sql = "DELETE FROM usuarios WHERE id = ?";

        // Connection

       Connection conn = null;

       // Prepared Statement

       PreparedStatement pstm = null;

       try {

        conn  = ConnectionFactory.createConnectionToMySQL();

        pstm = conn.prepareStatement(sql);

        // Setter in id

        pstm.setInt(1, id);

        // Executing the "pstm"

        pstm.execute();

        System.out.print("Usuário de id " + id + " deletado com sucesso!");

       } catch (Exception e){

            e.printStackTrace();

        } finally {

            try {

            // Closing the structures

            if (pstm!=null){ pstm.close(); };
            if (conn!=null) { conn.close(); };

            } catch (Exception e){

                e.printStackTrace();

            }

        }

    }

}
