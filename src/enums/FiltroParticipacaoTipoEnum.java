/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package enums;

/**
 *
 * @author luisf
 */
public enum FiltroParticipacaoTipoEnum {
    
    CLIENTE,
    PROFISSIONAL;
    
    public String getTipo() {
        
        return this.name();
    }
}
