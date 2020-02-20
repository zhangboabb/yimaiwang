package buy.dao.product;

import buy.entity.EasybuyProductCategory;


import java.util.List;

public interface IProductCategory {
    //获取商品的一级分类
    List<EasybuyProductCategory> queryAllProductCategory(String parentId);
}
