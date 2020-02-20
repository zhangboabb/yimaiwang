package buy.test;

import buy.dao.product.IProductCategory;
import buy.dao.product.ProductCategoryImpl;
import buy.entity.EasybuyProductCategory;
import buy.service.product.IProductCategoryService;
import buy.service.product.ProductCategoryServiceImpl;
import org.junit.Test;


import java.util.List;

public class TestProductCategory {
   @Test
    public void testProductCategory(){
        IProductCategoryService service=new ProductCategoryServiceImpl();
              List<EasybuyProductCategory> productCategories =service.queryAllProductCategory("0");
              for (EasybuyProductCategory category : productCategories){
                  System.out.println(category.getName());
              }

    }

}
