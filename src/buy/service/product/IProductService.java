package buy.service.product;

import buy.entity.EasybuyProduct;
import buy.util.ProductParams;

import java.util.List;

public interface IProductService {
    /*
     * 根据条件查询商品列表
     * */
    List<EasybuyProduct> queryProductList(ProductParams params);
    /*
     * 根据条件查询商品数量
     * */
    int queryProductCount(ProductParams params);
}
