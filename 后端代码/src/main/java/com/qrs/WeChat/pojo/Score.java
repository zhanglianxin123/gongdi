package com.qrs.WeChat.pojo;

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
 * @since 2021-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_score")
@ApiModel(value="Score对象", description="")
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "用户id")
    private Integer user_id;

    @ApiModelProperty(value = "属性")
    private Integer attribute;

    @ApiModelProperty(value = "文件id")
    private Integer document_id;

    @ApiModelProperty(value = "查看后获得的分数")
    private Integer document_score;


    @ApiModelProperty(value = "更新时间")
    private LocalDateTime update_time;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime create_time;

}
