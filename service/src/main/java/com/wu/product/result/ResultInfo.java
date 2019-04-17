package com.wu.product.result;/**
 * Created by sunny
 * 2019/4/8.
 */

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author
 * @create 2019-04-08 23:15
 **/
@Data
public class ResultInfo<T> implements Serializable {

    private static final long serialVersionUID = 3068837394742385883L;

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
