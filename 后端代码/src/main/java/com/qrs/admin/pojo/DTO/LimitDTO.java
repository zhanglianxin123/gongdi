package com.qrs.admin.pojo.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zlx
 * @since 2021-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)

public class LimitDTO implements Serializable {



    @ApiModelProperty(value = "设备id")
    private Integer device_id;



    @ApiModelProperty(value = "值")
    private Float value;





}
