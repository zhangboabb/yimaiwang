package buy.web.pre;

import buy.entity.EasybuyProductCategory;
import buy.service.product.IProductCategoryService;
import buy.service.product.ProductCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = {"/home"})
public class HomeServlet extends AbstractServlet {
   /* protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//从service层获取数据
        IProductCategoryService productCategoryService=new ProductCategoryServiceImpl();
        List<EasybuyProductCategory> categoryList = productCategoryService.queryAllProductCategory("0");
        //储存数据
       request.setAttribute("categoryList",categoryList);
       //携带数据跳转到home.jsp
        request.getRequestDispatcher("/front/home.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }*/
   IProductCategoryService productCategoryService;

    @Override
    public void init() throws ServletException {
        //从service层获取数据
        productCategoryService=new ProductCategoryServiceImpl();
    }

    public String index(HttpServletRequest request, HttpServletResponse response)throws Exception{
         List<EasybuyProductCategory> categoryList = productCategoryService.queryAllProductCategory("0");
         //储存数据
         request.setAttribute("categoryList",categoryList);

         //页面跳转
         return "/front/home";

     }


    @Override
    public Class getServletClass() {
        return HomeServlet.class;
    }
}
