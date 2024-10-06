package app;

import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.annotation.WebListener;
import modelo.ProductoDAO.ProductoDAO;

@WebListener
public class AppInitializer implements ServletContextListener{
    
    private ProductoDAO prodDAO = new ProductoDAO();
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("productos", prodDAO.ListarTodos());
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}
