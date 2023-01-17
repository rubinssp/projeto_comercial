/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filtros;

import enums.FiltroParticipacaoTipoEnum;

/**
 *
 * @author luisf
 */
public class FiltroParticipacao {
    private int id;
    private FiltroParticipacaoTipoEnum tipo;

    public FiltroParticipacao(int id, FiltroParticipacaoTipoEnum tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public FiltroParticipacaoTipoEnum getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "FiltroBO{" + "id=" + id + ", tipo=" + tipo + '}';
    }

    
}
