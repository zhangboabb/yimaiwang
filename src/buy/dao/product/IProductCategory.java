package buy.dao.product;

import buy.entity.EasybuyProductCategory;
import buy.util.ProductCategoryVo;


import java.util.List;

public interface IProductCategory {
    //获取商品的一级分类
    List<EasybuyProductCategory> queryAllProductCategory(String parentId);
    //获取商品的所有分类
    List<ProductCategoryVo> queryAllProductCategory();
}
