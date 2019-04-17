package com.wu.product.service;/**
 * Created by sunny
 * 2019/2/20.
 */


import com.wu.product.dataobject.ProductCategory;

import java.util.List;

/**
 *
 * @author
 * @create 2019-02-20 22:33
 **/
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
