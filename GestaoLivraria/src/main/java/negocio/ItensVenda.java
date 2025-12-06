/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author Lelio Victor
 */
public class ItensVenda {
    private int idItem;
    private int idVenda;
    private int idLivro;
    private int quantidade;
    private double subtotal;

    public ItensVenda() {
    }

    public ItensVenda(int idItem, int idVenda, int idLivro, int quantidade, double subtotal) {
        this.idItem = idItem;
        this.idVenda = idVenda;
        this.idLivro = idLivro;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public int getIdItem() {
        return idItem;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
