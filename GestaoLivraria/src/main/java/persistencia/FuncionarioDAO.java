package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                rs.close();
                stmt.close();
                return user;
            }

            rs.close();
            stmt.close();
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

    // NOVO MÉTODO: usado para preencher o JComboBox de vendedores
    @Override
    public List<Funcionario> listarTodos() {
        try {
            List<Funcionario> funcionarios = new ArrayList<>();

            PreparedStatement stmt = this.connection.prepareStatement(
                "SELECT * FROM funcionario"
            );
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idFuncionario")); // ajuste o nome da coluna se for diferente
                f.setNome(rs.getString("nome"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                funcionarios.add(f);
            }

            rs.close();
            stmt.close();

            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
