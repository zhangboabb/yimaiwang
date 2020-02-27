package buy.test;

import buy.dao.product.ProductCategoryImpl;
import buy.util.ProductCategoryVo;
import org.junit.Test;

import java.util.List;

public class TestProductCategoryVo {
    @Test
    public void testProductCategoryVo(){
        ProductCategoryImpl productCategory=new ProductCategoryImpl();
        List<ProductCategoryVo> productCategoryVos = productCategory.queryAllProductCategory();
       for (ProductCategoryVo categoryVo : productCategoryVos){
           System.out.println(categoryVo.getProductCategory());
       }
    }
}
