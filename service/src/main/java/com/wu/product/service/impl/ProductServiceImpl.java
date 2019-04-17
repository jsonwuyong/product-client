package com.wu.product.service.impl;/**
 * Created by sunny
 * 2019/4/8.
 */

import com.wu.product.Dto.CartDTO;
import com.wu.product.dao.ProductInfoRepository;
import com.wu.product.dataobject.ProductInfo;
import com.wu.product.enumutils.ProductStatusEnum;
import com.wu.product.enumutils.ResultEnum;
import com.wu.product.exception.ProductException;
import com.wu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author
 * @create 2019-04-08 22:57
 **/

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
            for (CartDTO cartDTO : cartDTOList){
                Optional<ProductInfo> productInfo = productInfoRepository
                        .findById(cartDTO.getProductId());
                if(!productInfo.isPresent()){
                    throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
                }

                ProductInfo productInfo1 = productInfo.get();
                Integer result = productInfo1.getProductStock() - cartDTO.getProductQuantity();
                if(result < 0){
                    throw  new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
                }
                productInfo1.setProductStock(result);
                productInfoRepository.save(productInfo1);
            }
    }
}
