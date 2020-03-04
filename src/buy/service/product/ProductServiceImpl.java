package buy.service.product;

import buy.dao.product.IProductDao;
import buy.dao.product.ProductImpl;
import buy.entity.EasybuyProduct;
import buy.entity.EasybuyProductCategory;
import buy.util.ProductCategoryVo;
import buy.util.ProductParams;

import java.util.List;

public class ProductServiceImpl implements IProductService {
     IProductDao productDao=new ProductImpl();

    @Override
    public List<EasybuyProduct> queryProductList(ProductParams params) {
        return productDao.queryProductList(params);
    }

    @Override
    public int queryProductCount(ProductParams params) {
        return productDao.queryProductCount(params);
    }
}
