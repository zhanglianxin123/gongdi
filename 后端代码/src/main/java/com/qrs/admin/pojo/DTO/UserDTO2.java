package com.qrs.admin.pojo.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
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
 * @since 2021-06-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
@ApiModel(value="User对象", description="")
public class UserDTO2 implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "工号")
    private String user_id;




    @ApiModelProperty(value = "姓名")
    private String user_name;




    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "工地名称")
    private String construction_name ;

    @ApiModelProperty(value = "部门名称")
    private String department_name;

    @ApiModelProperty(value = "分数")
    private int score;



}
