package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lelio Victor
 */
public class ConFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/dblibrary", "admin", "root");
        } catch(SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
    
}
