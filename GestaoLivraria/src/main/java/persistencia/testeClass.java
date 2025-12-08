/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Execute o arquivo e observe se aparece o 'conectado' no console.
 * Caso não, acerte a string de conexão até conseguir (revise login e senha).
 * Após fazer a conexão, escrever essa mesma query de conexão no arquivo ConFactory.java (pasta persistência)
 * @author Lelio Victor
 */
public class testeClass {
    
    public static void main(String[] args) throws SQLException {
        Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/dblibrary", "root", "24479018");
        System.out.println("Conectado!");
        conexao.close();
    }
}
