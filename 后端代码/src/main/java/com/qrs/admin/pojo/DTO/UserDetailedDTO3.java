package com.qrs.admin.pojo.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @Author zlx
 * @description
 * @Version 1.0
 * @Date 2021/6/15 16:23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDetailedDTO3 {
    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "工号")
    private String user_id;

    @ApiModelProperty(value = "工地id")
    private Integer construction_id;

    @ApiModelProperty(value = "工地名")
    private String construction_name;

    @ApiModelProperty(value = "部门id")
    private Integer department_id;
    @ApiModelProperty(value = "部门名")
    private String department_name;

    @ApiModelProperty(value = "权限id")
    private Integer role_id;

    @ApiModelProperty(value = "权限名")
    private String role_name;

    @ApiModelProperty(value = "姓名")
    private String user_name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "身份证号")
    private String id_card;

    @ApiModelProperty(value = "家庭住址")
    private String address;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime update_time;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime create_time;
}
