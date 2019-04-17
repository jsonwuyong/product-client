package com.wu.product.Dto;/**
 * Created by sunny
 * 2019/4/14.
 */

import lombok.Data;

/**
 *
 * @author
 * @create 2019-04-14 17:04
 **/
@Data
public class CartDTO {

    private String productId;
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
