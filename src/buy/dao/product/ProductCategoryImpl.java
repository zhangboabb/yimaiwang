package buy.dao.product;

import buy.entity.EasybuyProductCategory;
import buy.util.DataSourceUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryImpl implements IProductCategory {

    @Override
    public List<EasybuyProductCategory> queryAllProductCategory(String parentId) {
        List<EasybuyProductCategory> productCategories=new ArrayList<EasybuyProductCategory>();
        EasybuyProductCategory productCategory=null;

        try {
            StringBuffer sql=new StringBuffer();
            sql.append("select * from easybuy_product_category where 1=1");

            //判断parentId的值，如果为0，显示一级分类
          if ( (!"".equals(parentId) || null !=parentId)){
              parentId="0";
              sql.append(" and parentId = "+ parentId);
          }

            //获取链接
            Connection conn= DataSourceUtil.getConn();
            PreparedStatement pstmt=conn.prepareStatement(sql.toString());

            ResultSet rs=pstmt.executeQuery();
            //处理结果集
            while (rs.next()){
                //实例化对象
                productCategory=new EasybuyProductCategory();
                productCategory.setId(rs.getInt(1));
                productCategory.setName(rs.getString(2));
                productCategory.setParentid(rs.getInt(3));
                productCategory.setType(rs.getInt(4));
                productCategory.setIconclass(rs.getString(5));
                //将对象填充到集合中
                productCategories.add(productCategory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productCategories;
    }
}
