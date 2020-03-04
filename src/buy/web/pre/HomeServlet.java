package buy.web.pre;

import buy.entity.EasybuyNews;
import buy.entity.EasybuyProductCategory;
import buy.service.news.INewsService;
import buy.service.news.NewsServiceImpl;
import buy.service.product.IProductCategoryService;
import buy.service.product.ProductCategoryServiceImpl;
import buy.util.ProductCategoryVo;

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
   INewsService newsService;

    @Override
    public void init() throws ServletException {
        //从service层获取数据
        productCategoryService=new ProductCategoryServiceImpl();
        newsService=new NewsServiceImpl();
    }

    public String index(HttpServletRequest request, HttpServletResponse response)throws Exception{
         List<ProductCategoryVo> categoryList = productCategoryService.queryAllProductCategory();
         List<EasybuyNews> newsList=newsService.getAllNewsList();

         //储存数据
         request.setAttribute("categoryList",categoryList);
         request.setAttribute("newsList",newsList);

         //页面跳转
         return "/front/home";

     }


    @Override
    public Class getServletClass() {
        return HomeServlet.class;
    }
}
