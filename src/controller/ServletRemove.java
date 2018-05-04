package controller;

import bean.Product;
import service.CartService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletRemove",urlPatterns = "/removeToCart")
public class ServletRemove extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService service = new CartService();
        HttpSession session = request.getSession();
        String[] deletes = request.getParameterValues("delete");
        List<Product> carts = (List<Product>)session.getAttribute("carts");

        for (int i = 0; i < deletes.length; i++) {
            carts.remove(service.add(Integer.parseInt(deletes[i])));
        }

        session.setAttribute("carts", carts);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

    }
}
