package buy.service.product;

import buy.dao.product.IProductCategory;
import buy.dao.product.ProductCategoryImpl;
import buy.entity.EasybuyProductCategory;
import buy.util.ProductCategoryVo;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryServiceImpl implements IProductCategoryService {
    private IProductCategory productCategory=new ProductCategoryImpl();
    @Override
    public List<EasybuyProductCategory> queryAllProductCategory(String parentId) {
        parentId="0";
        return productCategory.queryAllProductCategory(parentId);
    }

    @Override
    public List<ProductCategoryVo> queryAllProductCategory() {
        return  productCategory.queryAllProductCategory();
    }
}
