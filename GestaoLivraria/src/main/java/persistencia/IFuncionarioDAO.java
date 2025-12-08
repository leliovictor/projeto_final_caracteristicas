package persistencia;

import java.util.List;
import negocio.Funcionario;

/**
 *
 * @author Lelio Victor
 */
public interface IFuncionarioDAO {
    public boolean login(String login, String senha);
    public void adicionar(Funcionario funcionario);
    public List<Funcionario> listarTodos();
    
}
