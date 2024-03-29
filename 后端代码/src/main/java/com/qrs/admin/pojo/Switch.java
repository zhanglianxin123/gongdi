package com.qrs.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("t_switch")
@ApiModel(value="Switch对象", description="")
public class Switch implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "开关id")
    private Integer switch_id;

    @ApiModelProperty(value = "开关编号")
    private String switch_number;

    @ApiModelProperty(value = "开关名称")
    private String switch_name;

    @ApiModelProperty(value = "开关状态")
    private Integer switch_state;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime update_time;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime create_time;


}
