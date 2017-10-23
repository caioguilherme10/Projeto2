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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author HP
 */
public class UsuarioDaoBinario implements Dao<Usuario>{
    
    private final File arquivo;
    
    public UsuarioDaoBinario() {
        arquivo = new File("Usuario.bin");
        
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
    public List<Usuario> listar() throws FileNotFoundException, IOException, ClassNotFoundException{
        if(arquivo.length() == 0){
            return new ArrayList<>();
        }else{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo));
            
            List<Usuario> lista = (List<Usuario>) in.readObject();
            return lista;
        }
    }
    
    /**
     *'
     * @param email
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    @Override
    public Usuario buscar(String email) throws IOException, FileNotFoundException, ClassNotFoundException{
        List<Usuario> usuarios = listar();
        
        for(Usuario u: usuarios){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }
    
    /**
     *
     * @param u
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    @Override
    public boolean atualizar(Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        List<Usuario> usuarios = listar();
        
        for(int i=0; i<usuarios.size();i++){
            if(u.getEmail().equals(usuarios.get(i).getEmail())){
                usuarios.set(i, u);
                atualizarArquivo(usuarios);
                return true;
            }
        }
        return false;
    }
    
    /**
     *
     * @param u
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    @Override
    public boolean deletar(Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException{
        List<Usuario> usuarios = listar();
        
        if(buscar(u.getEmail()) != null){
            usuarios.remove(u);
            atualizarArquivo(usuarios);
            return true;
        }else{
            return false;
        }
    }
    
    private void atualizarArquivo(List<Usuario> usuarios) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
        
        out.writeObject(usuarios);
        out.close();
    }

    /**
     *
     * @param u
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    @Override
    public boolean salvar(Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        List<Usuario> usuarios = listar();
        
        if(buscar(u.getEmail()) == null){
            usuarios.add(u);
            atualizarArquivo(usuarios);
            return true;
        }else{
            return false;
        }
    }
}
