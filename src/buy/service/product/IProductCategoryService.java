package buy.service.product;

import buy.entity.EasybuyProductCategory;
import buy.util.ProductCategoryVo;

import java.util.List;

public interface IProductCategoryService {
    List<EasybuyProductCategory> queryAllProductCategory(String parentId);
    List<ProductCategoryVo> queryAllProductCategory();
}
