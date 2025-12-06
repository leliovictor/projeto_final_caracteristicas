/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.util.Calendar;

/**
 *
 * @author Lelio Victor
 */
public class Venda {
    private int idVenda;
    private int idCliente;
    private int idFuncionario;
    private Calendar data_venda;
    private double total;

    public Venda() {
    }

    public Venda(int idVenda, int idCliente, int idFuncionario, Calendar data_venda, double total) {
        this.idVenda = idVenda;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.data_venda = data_venda;
        this.total = total;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public Calendar getData_venda() {
        return data_venda;
    }

    public double getTotal() {
        return total;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public void setData_venda(Calendar data_venda) {
        this.data_venda = data_venda;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
