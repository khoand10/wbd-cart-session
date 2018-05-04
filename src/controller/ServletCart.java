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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletCart", urlPatterns = "/addToCart")
public class ServletCart extends HttpServlet {
    CartService service = new CartService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] buys = request.getParameterValues("buy");
        HttpSession session = request.getSession();
        List<Product> carts = new ArrayList<>();
        for (int i = 0; i < buys.length; i++) {
            carts.add(service.add(Integer.parseInt(buys[i])));
        }
        session.setAttribute("carts",carts);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
