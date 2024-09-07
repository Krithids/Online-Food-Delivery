package onlinefooddelivery.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remove")
public class RemoveServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            String id = request.getParameter("id");
            
            if (id != null && !id.isEmpty()) {
                out.println("Product Id: " + id);
            } else {
               
                out.println("Error: Product Id not provided");
            }
        } catch (Exception e) {
           
            out.println("Error: An unexpected error occurred");
            e.printStackTrace(); 
        } finally {
            out.close(); 
        }
    }
}