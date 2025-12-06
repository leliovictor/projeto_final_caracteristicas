/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.Livro;

/**
 *
 * @author Lelio Victor
 */
public interface ILivroDAO {
    public void adicionar(Livro livro);
    public void atualizar(Livro livro);
    public List<Livro> listarTodos();
}
