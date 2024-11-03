package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import modelo.DetalleCliente;
import modelo.dao.ClienteDAO;
import util.Carrito;
import modelo.DetallePedido;


public class FacturaControlador extends HttpServlet {
    
    private String PagFactura = "insertar pagina de factura.jsp";
    private ClienteDAO clidao = new ClienteDAO();
    private Carrito objCarrito = new Carrito();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "facturar":
                Facturar(request, response);  
                break;
            case "mostrardatos":
                mostrarDatos(request, response);  
                break;
            case "generarfactura":
                generarFactura(request, response);  
                break;
            default:
                throw new AssertionError();
        }     
        
    }
    
    protected void Facturar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.getRequestDispatcher(PagFactura).forward(request, response);
        
    }
    
    protected void mostrarDatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         int clienteId = Integer.parseInt(request.getParameter("id")); 
         ArrayList<DetalleCliente> clienteDatos = clidao.BuscarDatos(clienteId);
        
        if (!clienteDatos.isEmpty()) {
            ArrayList<DetallePedido> lista = objCarrito.ObtenerSesion(request);
            request.setAttribute("clienteDatos", clienteDatos.get(0)); 
            request.setAttribute("carrito", lista);
            request.setAttribute("total", objCarrito.ImporteTotal(lista)); 
            request.getRequestDispatcher(PagFactura).forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Cliente no encontrado");
        }
        
    }
    
    protected void generarFactura(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.getRequestDispatcher(PagFactura).forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
