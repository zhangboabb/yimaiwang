package buy.dao.product;

import buy.entity.EasybuyProduct;
import buy.util.ProductParams;

import java.util.List;

/*
* 商品接口类
* */
public interface IProductDao {
    /*
    * 根据条件查询商品列表
    * */
   public List<EasybuyProduct> queryProductList(ProductParams params);
/*
* 根据条件查询商品数量
* */
  public int queryProductCount(ProductParams params);
}
