/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author HP
 */
public interface DaoMovimentacao<T> {
    
    public boolean salvar(T ojb) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException;
    public List<T> listar() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException ;
    public List<T> BuscarPorData (LocalDate inicio, LocalDate fim) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException ;
}
