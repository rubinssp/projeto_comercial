/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regex;

/**
 *
 * @author luisf
 */
public class ValidaCampos {
      public static boolean validaNome (String nome){
        return nome.matches("\\p{Upper}[\\p{IsLatin}[ ]]+");       
    }
    public static boolean validaEndereco(String endereco){
        return endereco.matches("\\p{Upper}[\\p{IsLatin}\\p{Alnum}[ ][,-]]+");       
    }    
    public static boolean validaEmail (String email){
        return email.matches("([\\p{Alnum}\\._-])+@([\\p{Alnum}])+(\\.([\\p{Alnum}])+)+");       
    }
    public static boolean validaFone(String fone){
        return fone.matches("\\(\\p{Digit}{2}\\)\\p{Digit}{4,5}-\\p{Digit}{4}");       
    }
    public static boolean validaCpf(String cpf){
        return cpf.matches("/^\\p{Digit}{3}.?\\p{Digit}{3}.?\\p{Digit}{3}-\\p{Digit}{2}");       
    }
    public static boolean validaDataInicio (String datainicio){
        return datainicio.matches("\\p{Digit}{2}/\\p{Digit}{2}/\\p{Digit}{4}");
    }
    public static boolean validaDataConclusao (String dataconclusao){
        return dataconclusao.matches("\\p{Digit}{2}/\\p{Digit}{2}/\\p{Digit}{4}");
    }
    public static boolean validaValor (String valor){
        return valor.matches("\\p{Digit}{2}/\\p{Digit}{2}/\\p{Digit}{4}");
    }
    public static boolean validaHorasTrabalhadas (String horastrabalhadas){
        return horastrabalhadas.matches("\\p{Digit}{2}/\\p{Digit}{2}/\\p{Digit}{4}");
    }
}
