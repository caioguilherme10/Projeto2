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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.Movimentacao;

/**
 *
 * @author HP
 */
public class MovimentacaoDaoBinario {
    
    private File arquivo;
    
    public MovimentacaoDaoBinario() throws IOException{
        arquivo = new File("Movimentacao.bin");
        
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
    
    }
    
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
    
    public List<Movimentacao> BuscarPorData (LocalDate inicio, LocalDate fim) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        List<Movimentacao> movimentacoes = listar();
        
        List<Movimentacao> lista = new ArrayList<>();
        
        for(int i=0; i<movimentacoes.size();i++){
            if(inicio.isBefore(movimentacoes.get(i).getData()) && fim.isAfter(movimentacoes.get(i).getData())){
                lista.add(movimentacoes.get(i));
            }
        }
        
        return lista;
    }
    
    public boolean create (Movimentacao m) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        List<Movimentacao> movimentacoes = listar();
        
        movimentacoes.add(m);
        atualizarArquivo(movimentacoes);
        return true;
    }
    
    //Deletar uma movimetacao
    public boolean excluir(Movimentacao m) throws IOException, FileNotFoundException, ClassNotFoundException{
        List<Movimentacao> movimentacoes = listar();
        
        movimentacoes.remove(m);
        atualizarArquivo(movimentacoes);
        return true;
    }
    
    //Deletar Movimentacao do usuario
    public void deletar(String email) throws IOException, FileNotFoundException, ClassNotFoundException{
        List<Movimentacao> movimentacoes = listar();
        
        for(int i = 0; i<movimentacoes.size();i++){
            if(movimentacoes.get(i).getEmail().equals(email)){
                movimentacoes.remove(i);
            }
        }
        atualizarArquivo(movimentacoes);
    }

    private void atualizarArquivo(List<Movimentacao> movimentacoes) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
        
        out.writeObject(movimentacoes);
        out.close();
    }
}
