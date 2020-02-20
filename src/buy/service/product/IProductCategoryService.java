package buy.service.product;

import buy.entity.EasybuyProductCategory;

import java.util.List;

public interface IProductCategoryService {
    List<EasybuyProductCategory> queryAllProductCategory(String parentId);
}
