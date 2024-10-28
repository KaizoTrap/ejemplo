package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.dao.AuthDAO;


public class AuthControlador extends HttpServlet {

    private AuthDAO authDao = new AuthDAO();
    private final String pagLogin = "Pagina_login.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        switch (accion) {
            case "login":
                Login(request, response);
                break;
            case "autentificarse":
                Autentificarse(request, response);
                break;
            case "terminar":
                terminarProceso(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    protected void Autentificarse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        
        Cliente obj = authDao.Login(correo, contrasena);
        
        if (obj != null) {
            request.getSession().setAttribute("usuario", obj);
            response.sendRedirect("pagina de generar factura");
        }else{
            request.getSession().setAttribute("error", "Usuario y/o contraseña no son correctos");
            request.getRequestDispatcher(pagLogin).forward(request, response);
        }

        
    }
    
    protected void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.getRequestDispatcher(pagLogin).forward(request, response);
        
    }
    
    protected void terminarProceso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.getSession().removeAttribute("usuario");
        response.sendRedirect("pagina de aviso.jsp");
        
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
