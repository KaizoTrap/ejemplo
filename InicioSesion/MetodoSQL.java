
package conexion;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class MetodoSQL {

    private PreparedStatement sentenciaPreparada;
    private Connection conexion;
    private ResultSet resultado;
    
    public boolean buscarUsuarioInicioSesion(String nombre, String contrasena){
        
        boolean iniciarSesion = false;
        
        try {
            conexion= Conexion.conectar();
            String consulta = "SELECT nombre, contrasena FROM usuarios WHERE nombre = ? AND contrasena = ?";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1, nombre);
            sentenciaPreparada.setString(2, contrasena);
            resultado = sentenciaPreparada.executeQuery();
            
            if(resultado.next()){
                iniciarSesion = true;
            }else{
                iniciarSesion = false;
            }
            conexion.close();
            
        }catch (SQLException e){
            System.out.println("Error "+ e);
        }finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error "+ e);
            }
        }
        return iniciarSesion;
    }
}
