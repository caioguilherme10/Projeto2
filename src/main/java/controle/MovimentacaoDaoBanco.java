/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Movimentacao;

/**
 *
 * @author HP
 */
public class MovimentacaoDaoBanco implements DaoMovimentacao<Movimentacao>{
    
    private ConFactory factory;
    private Connection con;
            
    public MovimentacaoDaoBanco(){
        factory = new ConFactory();
        
        try {
           con = factory.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha na conexão com o banco", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public boolean salvar(Movimentacao m) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        
        PreparedStatement stmt = con.prepareStatement("INSERT INTO movimentacao (id,descricao,data,valor,tipo,categoria,email) VALUES (?,?,?,?,?,?,?)");
        
        stmt.setInt(1, m.getId());
        stmt.setString(2, m.getDescricao());
        stmt.setDate(3, java.sql.Date.valueOf(m.getData()));
        stmt.setFloat(4, m.getPreco());
        stmt.setString(5, m.getTipo());
        stmt.setString(6, m.getCategoria());
        stmt.setString(7, m.getEmail());
        
        return stmt.executeUpdate()>0;
    }

    @Override
    public List<Movimentacao> listar() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        
        List<Movimentacao> movimentacao = new ArrayList<>();
        Connection con = factory.getConnection();
        
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM movimentacao");
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            int id = rs.getInt(1);
            String descricao = rs.getString(2);
            LocalDate data = rs.getDate(3).toLocalDate();
            float valor = rs.getFloat(4);
            String tipo = rs.getString(5);
            String categoria = rs.getString(6);
            String email = rs.getString(7);
            
            Movimentacao m = new Movimentacao(descricao,data,valor,tipo,categoria,email);
            m.setId(id);
            movimentacao.add(m);
        }
        
        return movimentacao;
    }
    
    /**
     *
     * @param inicio
     * @param fim
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public List<Movimentacao> BuscarPorData (LocalDate inicio, LocalDate fim ,String email) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException{
        
        List<Movimentacao> movimentacoes = listar();
        
        List<Movimentacao> lista = new ArrayList<>();
        
        for(int i=0; i<movimentacoes.size();i++){
            if(inicio.isBefore(movimentacoes.get(i).getData()) && fim.isAfter(movimentacoes.get(i).getData())){
                lista.add(movimentacoes.get(i));
            }
        }
        
        return lista;
    }
    
    //Deletar Movimentacao do usuario
    public boolean deletar(String email) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException{
        
        PreparedStatement stmt = con.prepareStatement("DELETE FROM movimentacao WHERE email like ?");
        
        stmt.setString(1, email);
        
        return stmt.executeUpdate()>0;
    }
}
