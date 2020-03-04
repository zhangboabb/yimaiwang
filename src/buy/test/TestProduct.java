package buy.test;

import buy.dao.product.IProductDao;
import buy.dao.product.ProductImpl;
import buy.util.ProductParams;
import org.junit.Test;

public class TestProduct {
    IProductDao productDao=new ProductImpl();
    @Test
    public void testProduct(){

        ProductParams params=new ProductParams();
      /*  boolean page = params.isPage();
        params.setStartIndex(0);
        params.setPageSize(5);*/
      params.setSort("name");
        System.out.println(productDao.queryProductList(params).get(0).getName());
    }
    @Test
    public void testCount(){
        ProductParams params=new ProductParams();
      /*  boolean page = params.isPage();
        params.setStartIndex(0);
        params.setPageSize(5);*/
        params.setSort("name");
        System.out.println(productDao.queryProductCount(params));
    }
}
