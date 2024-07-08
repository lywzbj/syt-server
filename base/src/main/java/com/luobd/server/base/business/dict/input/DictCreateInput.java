package com.luobd.server.base.business.dict.input;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel(description = "字典创建表单")
public class DictCreateInput {

    @ApiModelProperty(value = "父级id")
    private Long parentId;

    @ApiModelProperty(value = "类型",required = true)
    @NotBlank(message = "请指定字典类型")
    private String type;

    @ApiModelProperty(value = "字典值",required = true)
    @NotBlank(message = "请指定字典值")
    private String dictValue;

    @ApiModelProperty(value = "备注")
    private String remark;


}
