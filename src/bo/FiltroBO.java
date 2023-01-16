/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

/**
 *
 * @author luisf
 */
public class FiltroBO {
    private int id;
    private String tipo;

    public FiltroBO(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "FiltroBO{" + "id=" + id + ", tipo=" + tipo + '}';
    }

    
}
