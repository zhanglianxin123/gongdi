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

public class SwitchDTO implements Serializable {



    @ApiModelProperty(value = "开关id")
    private Integer switch_id;

    @ApiModelProperty(value = "开关名称")
    private String switch_name;


    @ApiModelProperty(value = "开关状态")
    private Integer switch_state;


}
