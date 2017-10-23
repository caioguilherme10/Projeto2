/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HP
 * @param <T>
 */
public interface Dao<T> {
    
    public boolean salvar(T ojb) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException;
    public List<T> listar() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException ;
    public T buscar(String e) throws IOException, FileNotFoundException, ClassNotFoundException ,SQLException;
    public boolean atualizar(T u) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException;
    public boolean deletar(T u) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException;
}
