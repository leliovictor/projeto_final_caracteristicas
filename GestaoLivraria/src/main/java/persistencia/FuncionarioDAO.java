/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lelio Victor
 */
public class FuncionarioDAO implements IFuncionarioDAO {
    private final Connection connection;
    
    public FuncionarioDAO() {
        this.connection = new ConFactory().getConnection();
    }

    @Override
    public boolean login(String login, String senha) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
            "SELECT EXISTS(SELECT 1 FROM funcionario WHERE login = ? AND senha = ?) AS user"
            );
            
            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                boolean user = rs.getInt("user") == 1;
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return false;
    }
}
