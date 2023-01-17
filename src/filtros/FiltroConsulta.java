/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filtros;

import enums.FiltroConsultaTipoEnum;

/**
 *
 * @author luisf
 */
public class FiltroConsulta {
    
    private String text;
    private FiltroConsultaTipoEnum tipo; 
    
    public FiltroConsulta(String text, FiltroConsultaTipoEnum tipo) {
        this.text = text;
        this.tipo = tipo;
    }

    public String getText() {
        return text;
    }

    public FiltroConsultaTipoEnum getTipo() {
        return tipo;
    }
}
