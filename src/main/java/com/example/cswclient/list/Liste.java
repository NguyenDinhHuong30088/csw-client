package com.example.cswclient.list;

import com.example.cswclient.entity.Product;
import com.example.cswclient.service.ProductService;
import com.example.cswclient.retrofit.RetrofitServiceGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class Liste extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("liste");
        ProductService productService = RetrofitServiceGenerator.createService(ProductService.class);
        List<Product> liste = productService.getlist().execute().body();
        req.setAttribute("l", liste);
        req.getRequestDispatcher("/liste.jsp").forward(req,resp);
    }
}
