package com.wu.product.result;/**
 * Created by sunny
 * 2019/4/8.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 *
 * @author
 * @create 2019-04-08 23:17
 **/
@Data
public class ProductMode {

    private static final long serialVersionUID = 7097863777546530545L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoMode> productInfoModeList;
}
