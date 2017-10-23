/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Movimentacao;

/**
 *
 * @author HP
 */
public class MovimentacaoDaoBinario implements DaoMovimentacao<Movimentacao>{
    
    private File arquivo;
    
    public MovimentacaoDaoBinario() {
        arquivo = new File("Movimentacao.bin");
        
        if(!arquivo.exists()){
            try {
                arquivo.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Falha na conexão com arquivo", "Mensagem de erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    
    }
    
    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public List<Movimentacao> listar() throws FileNotFoundException, IOException, ClassNotFoundException{
        if(arquivo.length() == 0){
            return new ArrayList<>();
        }else{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo));
            
            List<Movimentacao> lista = (List<Movimentacao>) in.readObject();
            return lista;
        }
    }
    
    public boolean atualizar(Movimentacao m, Movimentacao novo) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        List<Movimentacao> movimentacoes = listar();
        
        for(int i=0; i<movimentacoes.size();i++){
            if(m.equals(i)){
                movimentacoes.set(i, novo);
                atualizarArquivo(movimentacoes);
                return true;
            }
        }
        return false;
    }
    
    /**
     *
     * @param inicio
     * @param fim
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    @Override
    public List<Movimentacao> BuscarPorData (LocalDate inicio, LocalDate fim, String email) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        List<Movimentacao> movimentacoes = listar();
        
        List<Movimentacao> lista = new ArrayList<>();
        
        for(int i=0; i<movimentacoes.size();i++){
            if(inicio.isBefore(movimentacoes.get(i).getData()) && fim.isAfter(movimentacoes.get(i).getData())){
                if(movimentacoes.get(i).getEmail().equals(email)){
                    lista.add(movimentacoes.get(i));
                }
            }
        }
        
        return lista;
    }
    
    //Deletar uma movimetacao
    public boolean excluir(Movimentacao m) throws IOException, FileNotFoundException, ClassNotFoundException{
        List<Movimentacao> movimentacoes = listar();
        
        movimentacoes.remove(m);
        atualizarArquivo(movimentacoes);
        return true;
    }
    
    //Deletar Movimentacao do usuario
    public boolean deletar(String email) throws IOException, FileNotFoundException, ClassNotFoundException{
        List<Movimentacao> movimentacoes = listar();
        
        for(int i = 0; i<movimentacoes.size();i++){
            if(movimentacoes.get(i).getEmail().equals(email)){
                movimentacoes.remove(i);
            }
        }
        atualizarArquivo(movimentacoes);
        return true;
    }

    private void atualizarArquivo(List<Movimentacao> movimentacoes) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
        
        out.writeObject(movimentacoes);
        out.close();
    }

    /**
     *
     * @param m
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public boolean salvar(Movimentacao m) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        
        List<Movimentacao> movimentacoes = listar();
        
        movimentacoes.add(m);
        atualizarArquivo(movimentacoes);
        return true;
    }
    
    public Movimentacao buscarId(int id) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        List<Movimentacao> movimentacoes = listar();
       
        for(int i=0; i<movimentacoes.size();i++){
            System.out.println(movimentacoes.get(i).getId());
            if(id == movimentacoes.get(i).getId()){
                return movimentacoes.get(i);
            }
        }
       
        return null;
    }
}
