package com.wu.product.service;/**
 * Created by sunny
 * 2019/4/8.
 */

import com.wu.product.Dto.CartDTO;
import com.wu.product.dataobject.ProductInfo;

import java.util.List;

/**
 *
 * @author
 * @create 2019-04-08 22:41
 **/
public interface ProductService {

   List<ProductInfo> findUpAll();

   /**|
    * 查询商品列表
    * @param productIdList
    * @return
    */
   List<ProductInfo> findList(List<String> productIdList);

   void decreaseStock(List<CartDTO> cartDTOList);
}
