package com.qrs.WeChat.pojo;

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
 * @since 2021-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_document")
@ApiModel(value="Document对象", description="")
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "属性")
    private Integer attribute;

    @ApiModelProperty(value = "文件id")
    private Integer document_id;

    @ApiModelProperty(value = "文件名")
    private String document_name;

    @ApiModelProperty(value = "视频时间为多少秒")
    private Integer document_time;

    @ApiModelProperty(value = "文件路径")
    private String document_path;

    @ApiModelProperty(value = "查看后获得的分数")
    private int document_score;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime update_time;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime create_time;


}
