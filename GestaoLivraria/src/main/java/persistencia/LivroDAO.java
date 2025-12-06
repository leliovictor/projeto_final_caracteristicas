/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.Livro;

/**
 *
 * @author Lelio Victor
 */
public class LivroDAO implements ILivroDAO {
    private final Connection connection;
    
    public LivroDAO() {
        this.connection = new ConFactory().getConnection();
    }

    @Override
    public List<Livro> listarTodos() {
        try {
            List<Livro> livros = new ArrayList<Livro>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM livro");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Livro livro = new Livro();
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setEditora(rs.getString("editora"));
                livro.setPreco(rs.getDouble("preco"));
                livro.setQuantidade(rs.getInt("quantidade"));
                
                livros.add(livro);
            }
            rs.close();
            stmt.close();
            return livros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void adicionar(Livro livro) {
            String sql = "INSERT INTO livro "
            + "(titulo, autor, editora, preco, quantidade) "
            + "VALUES (?,?,?,?,?)";
           
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setBigDecimal(4, new BigDecimal(livro.getPreco()));
            stmt.setInt(5, livro.getQuantidade());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizar(Livro livro) {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, editora = ?, preco = ?, quantidade = ? "
               + "WHERE idLivro = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setBigDecimal(4, new BigDecimal(livro.getPreco()));
            stmt.setInt(5, livro.getQuantidade());
            stmt.setInt(6, livro.getIdLivro());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
