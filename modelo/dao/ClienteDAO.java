package modelo.dao;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.DetalleCliente;

public class ClienteDAO {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<DetalleCliente> BuscarDatos(int id){
        ArrayList<DetalleCliente> lista = new ArrayList<DetalleCliente>();
        
        try {
            cn = Conexion.getConnection();
            String sql = "INSERTAR CONSULTA SQL";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                DetalleCliente obj = new DetalleCliente();
                obj.setId_dato(rs.getInt("id_dato"));
                obj.setNombre(rs.getString("nombre_usuario"));
                obj.setApellido(rs.getString("apellido_usuario"));
                obj.setCorreo(rs.getString("correo_usuario"));
                obj.setIdentificacion(rs.getInt("numero_identificacion"));
                lista.add(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try {
                if (cn != null) {
                    cn.close();
                }

                if (ps != null) {
                    ps.close();
                }

                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }
}
