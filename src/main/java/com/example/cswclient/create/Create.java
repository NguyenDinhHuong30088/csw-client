package com.example.cswclient.create;

import com.example.cswclient.entity.Product;
import com.example.cswclient.service.ProductService;
import com.example.cswclient.retrofit.RetrofitServiceGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Create extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Create.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Name = req.getParameter("Name");
        double Price = Double.parseDouble(req.getParameter("Price"));
        int Quantity = Integer.parseInt(req.getParameter("Quantity"));
        ProductService productService = RetrofitServiceGenerator.createService(ProductService.class);
        productService.add(new Product(Name,Price,Quantity)).execute();
        resp.sendRedirect("/Liste");

    }
}
