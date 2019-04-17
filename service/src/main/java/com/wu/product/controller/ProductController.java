package com.wu.product.controller;/**
 * Created by sunny
 * 2019/4/1.
 */

import com.wu.product.Dto.CartDTO;
import com.wu.product.dataobject.ProductCategory;
import com.wu.product.dataobject.ProductInfo;
import com.wu.product.result.ProductInfoMode;
import com.wu.product.result.ProductMode;
import com.wu.product.result.ResultInfo;
import com.wu.product.service.CategoryService;
import com.wu.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author
 * @create 2019-04-01 22:38
 **/
@RestController
@RequestMapping("/com/wu/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultInfo<ProductMode> list(){

        List<ProductInfo> productInfoList = productService.findUpAll();
        List<Integer> categoryTypeList = productInfoList.stream()
                       .map(ProductInfo::getCategoryType)
                       .collect(Collectors.toList());
        List<ProductCategory> categoryist = categoryService.findByCategoryTypeIn(categoryTypeList);
        //构造json
        List<ProductMode> productModeList = new ArrayList<>();
        for (ProductCategory productCategory : categoryist){
            ProductMode productMode = new ProductMode();
            productMode.setCategoryName(productCategory.getCategoryName());
            productMode.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoMode> productInfoModeList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoMode productInfoMode = new ProductInfoMode();
                    BeanUtils.copyProperties(productInfo,productInfoMode);
                    productInfoModeList.add(productInfoMode);
                }
            }
            productMode.setProductInfoModeList(productInfoModeList);
            productModeList.add(productMode);
        }
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(productModeList);
        resultInfo.setCode(0);
        resultInfo.setMsg("请求成功");
        return  resultInfo;
    }


    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){
        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
        productService.decreaseStock(cartDTOList);
    }
}
