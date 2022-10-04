package skomorokhin.com.market.servlets;

import skomorokhin.com.market.Product;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "getProducts", urlPatterns = "/products")
public class GetProducts extends HttpServlet {


    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        for (Product product : createProductList()) {
            resp.getWriter().println(product.toString());
        }
    }


    private List<Product> createProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,100, "Orange"));
        productList.add(new Product(2,60, "Apple"));
        productList.add(new Product(3,70, "Milk"));
        productList.add(new Product(4,28, "Bread"));
        productList.add(new Product(5,65, "Ice-cream"));
        productList.add(new Product(6,25, "Water"));
        productList.add(new Product(7,45, "Cookies"));
        productList.add(new Product(8,250, "Candy"));
        productList.add(new Product(9,120, "Chips"));
        productList.add(new Product(10,30, "Gum"));
        return productList;
    }
}
