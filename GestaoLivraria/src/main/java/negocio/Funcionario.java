/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author Lelio Victor
 */
public class Funcionario {
    private int idFuncionario;
    private String nome;
    private String usuario;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(int idFuncionario, String nome, String usuario, String senha) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
