/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.Cliente;

/**
 *
 * @author Lelio Victor
 */
public interface IClienteDAO {
    public void adicionar(Cliente cliente);
    public List<Cliente> listarTodos();
}
