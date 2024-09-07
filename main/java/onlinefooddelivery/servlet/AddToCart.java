package onlinefooddelivery.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onlinefooddelivery.model.*;


//@WebServlet("/addtocart")
//public class AddToCartServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//
//        try (PrintWriter out = response.getWriter()) {
//            int id = Integer.parseInt(request.getParameter("id"));
//            Menu cm = new Menu();
//            cm.setId(id);
//            cm.setQuantity(1);
//
//            HttpSession session = request.getSession();
//            ArrayList<Menu> cartList = (ArrayList<Menu>) session.getAttribute("cart-list");
//
//            if (cartList == null) {
//                cartList = new ArrayList<>();
//                cartList.add(cm);
//                session.setAttribute("cart-list", cartList);
//                response.sendRedirect("index.jsp");
//            } else {
//                boolean exist = false;
//
//                for (Menu c : cartList) {
//                    if (c.getId() == id) {
//                        exist = true;
//                        out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");
//                        break; // Exit the loop since the item is already in the cart
//                    }
//                }
//
//                if (!exist) {
//                    cartList.add(cm);
//                    response.sendRedirect("index.jsp");
//                }
//            }
//        }
//    }
//}

@WebServlet(name = "AddToCartServlet", urlPatterns = "/add-to-cart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
//        	out.print("add to cart servlet");

            ArrayList<Menu> cartList = new ArrayList<>();
            int id = Integer.parseInt(request.getParameter("id"));
            Menu cm = new Menu();
            cm.setId(id);
            cm.setQuantity(1);
            HttpSession session = request.getSession();
            ArrayList<Menu> cart_list = (ArrayList<Menu>) session.getAttribute("cart-list");
            if (cart_list == null) {
                cartList.add(cm);
                session.setAttribute("cart-list", cartList);
                response.sendRedirect("index.jsp");
            } else {
                cartList = cart_list;

                boolean exist = false;
                for (Menu c : cart_list) {
                    if (c.getId() == id) {
                        exist = true;
                        out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");
                    }
                }

                if (!exist) {
                    cartList.add(cm);
                    response.sendRedirect("index.jsp");
                }
            }
        }
	}

}
