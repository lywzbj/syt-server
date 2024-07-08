package com.luobd.server.api.pub;


import com.luobd.server.base.business.dict.input.DictCreateInput;
import com.luobd.server.base.business.dict.service.ICoreDictService;
import com.luobd.server.common.model.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/base/dict")
@Api(tags = "字典模块")
public class DictController {



    @Resource
    private ICoreDictService coreDictService;


    @PostMapping(value = "/create")
    @ApiOperation(value = "创建字典")
    public ResponseData<Long> create(@RequestBody @Valid DictCreateInput input) {
        return coreDictService.create(input);
    }





}
