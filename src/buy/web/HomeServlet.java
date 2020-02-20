package buy.web;

import buy.entity.EasybuyProductCategory;
import buy.service.product.IProductCategoryService;
import buy.service.product.ProductCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//从service层获取数据
        IProductCategoryService productCategoryService=new ProductCategoryServiceImpl();
       List<EasybuyProductCategory> categoryList = productCategoryService.queryAllProductCategory(0);
       //储存数据
       request.setAttribute("categoryList",categoryList);
       //携带数据跳转到home.jsp
        request.getRequestDispatcher("").forward(request);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
