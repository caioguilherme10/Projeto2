/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author HP
 */
public class UsuarioDaoBanco implements Dao<Usuario>{
    
    private ConFactory factory;
    private Connection con;
            
    public UsuarioDaoBanco(){
        factory = new ConFactory();
        
        try {
           con = factory.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na conexão com o banco", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     *
     * @param u
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public boolean salvar(Usuario u) throws ClassNotFoundException, SQLException{
  
            
        PreparedStatement stmt = con.prepareStatement("INSERT INTO usuario (email,nome,nascimento,sexo,senha) VALUES (?,?,?,?,?)");
        
        stmt.setString(1, u.getEmail());
        stmt.setString(2, u.getNome());
        stmt.setDate(3, java.sql.Date.valueOf(u.getNascimento()));
        stmt.setString(4, u.getSexo());
        stmt.setString(5, u.getSenha());
        
        return stmt.executeUpdate()>0;
    }

    /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public List<Usuario> listar() throws ClassNotFoundException, SQLException {
        
        List<Usuario> usuarios = new ArrayList<>();
        Connection con = factory.getConnection();
        
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuario");
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            String email = rs.getString(1);
            String nome = rs.getString(2);
            LocalDate nascimento = rs.getDate(3).toLocalDate();
            String sexo = rs.getString(4);
            String senha = rs.getString(5);
            
            Usuario u = new Usuario(email,nome,nascimento,sexo,senha);
            usuarios.add(u);
        }
        
        return usuarios;
    }

    /**
     *
     * @param e
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public Usuario buscar(String e) throws ClassNotFoundException, SQLException {
        
        Connection con = factory.getConnection();
        
        PreparedStatement stmt = con.prepareStatement("SELECT email FROM usuario WHERE email=?");
        stmt.setString(1, e);
        ResultSet rs = stmt.executeQuery();
        Usuario u = null;
        while(rs.next()){
            String email = rs.getString(1);
            String nome = rs.getString(2);
            LocalDate nascimento = rs.getDate(3).toLocalDate();
            String sexo = rs.getString(4);
            String senha = rs.getString(5);
            
            u = new Usuario(email,nome,nascimento,sexo,senha);
        }
        
        return u;
    }

    /**
     *
     * @param u
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public boolean atualizar(Usuario u) throws ClassNotFoundException, SQLException {
        
        Connection con = factory.getConnection();
        
        PreparedStatement stmt = con.prepareStatement("UPDATE usuario SET nome=? , nascimento=? , sexo=? , senha=? where email=?");
        
        stmt.setString(1, u.getNome());
        stmt.setDate(2, java.sql.Date.valueOf(u.getNascimento()));
        stmt.setString(3, u.getSexo());
        stmt.setString(4, u.getSenha());
        stmt.setString(5, u.getEmail());
        
        if(stmt.executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @param u
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public boolean deletar(Usuario u) throws ClassNotFoundException, SQLException {
        
        Connection con = factory.getConnection();
        
        PreparedStatement stmt = con.prepareStatement("DELETE FROM usuario WHERE email like ?");
        
        stmt.setString(1, u.getEmail());
        
        if(stmt.executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }
    
}
