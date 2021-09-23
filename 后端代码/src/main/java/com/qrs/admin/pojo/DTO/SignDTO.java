package com.qrs.admin.pojo.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class SignDTO implements Serializable {

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer user_id;

    @ApiModelProperty(value = "用户姓名")
    private String user_name;

    @ApiModelProperty(value = "工地名称")
    private String construction_name;

    @ApiModelProperty(value = "签到时间")
    private String sign_time;

    @ApiModelProperty(value = "签到位置/工地")
    private Integer construction_id;

    @ApiModelProperty(value = "状态 进/出")
    private Integer status;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime update_time;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime create_time;


}
