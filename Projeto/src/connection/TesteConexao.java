/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

 
import java.sql.Connection;


public class TesteConexao {
    
    public static void main(String args[]){
         Connection con = ConnectionFactory.getConnection();
        
        if (con != null) {
            System.out.println("Connectado com sucesso!");
        }
        
        }
    
}