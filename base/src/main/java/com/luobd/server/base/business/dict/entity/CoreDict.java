package com.luobd.server.base.business.dict.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Luoyu
 * @since 2024-06-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CoreDict", description="")
public class CoreDict implements Serializable {

    private static final long serialVersionUID = 1L;



    @ApiModelProperty(value = "id")
    @TableId
    private Long id;


    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "创建人")
    @TableField("createUserId")
    private Long createUserId;

    @ApiModelProperty(value = "更新时间")
    @TableField("updateTime")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "更新人")
    @TableField("updateUserId")
    private Long updateUserId;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "删除状态")
    private Boolean deleted;

    @ApiModelProperty(value = "父级id")
    @TableField("parentId")
    private Long parentId;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "字典值")
    @TableField("dictValue")
    private String dictValue;

    @ApiModelProperty(value = "字典code")
    @TableField("dictCode")
    private Long dictCode;

    @ApiModelProperty(value = "备注")
    private String remark;


}
