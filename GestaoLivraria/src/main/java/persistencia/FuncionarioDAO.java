package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Funcionario;

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

    @Override
    public void adicionar(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, login, senha) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getLogin());
            stmt.setString(3, funcionario.getSenha());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
