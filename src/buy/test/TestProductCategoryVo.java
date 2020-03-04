package buy.test;

import buy.dao.product.IProductCategory;
import buy.dao.product.ProductCategoryImpl;
import buy.service.product.IProductCategoryService;
import buy.service.product.ProductCategoryServiceImpl;
import buy.util.ProductCategoryVo;
import org.junit.Test;

import java.util.List;

public class TestProductCategoryVo {
    @Test
    public void testProductCategoryVo(){
        /*IProductCategory productCategory=new ProductCategoryImpl();
        System.out.println(productCategory.queryAllProductCategory().size());*/


        IProductCategoryService service=new ProductCategoryServiceImpl();
        System.out.println(service.queryAllProductCategory().size());

    }
}
