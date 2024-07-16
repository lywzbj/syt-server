package com.luobd.server.api.pub;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luobd.server.business.hospital.entity.HospitalSet;
import com.luobd.server.business.hospital.service.IHospitalSetService;
import com.luobd.server.common.model.PageInput;
import com.luobd.server.common.model.ResponseData;
import com.luobd.server.common.model.ResponsePageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "医院设置模块")
@RequestMapping(value = "/api/hospital/set")
public class HospitalSetController {



    @Resource
    private IHospitalSetService hospitalSetService;



    @PostMapping(value = "/create")
    @ApiOperation(value = "创建医院设置信息")
    public ResponseData<Boolean> create(@RequestBody HospitalSet hospitalSet) {
        hospitalSet.setStatus(1);
       // hospitalSet.setSignKey(MD5.getMD5(hospitalSet.getSignKey().getBytes(StandardCharsets.UTF_8)));
        boolean save = hospitalSetService.save(hospitalSet);
        return ResponseData.success(save);
    }


    @GetMapping(value = "/get")
    @ApiOperation(value = "根据id获取医院设置")
    public ResponseData<HospitalSet> get(@RequestParam(value = "id")Long id) {
        return ResponseData.success(hospitalSetService.getById(id));
    }



    @PostMapping(value = "/batchDelete")
    @ApiOperation(value = "批量删除")
    public ResponseData<Boolean> batchDelete(@RequestBody List<Long> ids) {
        return ResponseData.success(hospitalSetService.removeByIds(ids));
    }



    @GetMapping(value = "/disable")
    @ApiOperation(value = "/设置禁用")
    public ResponseData<Boolean> disable(@RequestParam(value = "id") Long id) {
        return setLock(id,1);
    }

    @GetMapping(value = "/enabled")
    @ApiOperation(value = "/设置开启")
    public ResponseData<Boolean> enabled(@RequestParam(value = "id") Long id) {
        return setLock(id,0);
    }


    private ResponseData<Boolean> setLock(Long id,Integer status) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        if(hospitalSet == null) {
            return ResponseData.error("医院设置信息不存在");
        }


        hospitalSet.setStatus(status);
        boolean update = hospitalSetService.updateById(hospitalSet);
        if(update) {
            return ResponseData.success(true);
        }
        return ResponseData.error("设置失败");
    }











    @GetMapping(value = "/getAll")
    @ApiOperation(value = "获取所有的医院设置信息")
    public ResponseData<List<HospitalSet>> getAll() {
        return ResponseData.success(hospitalSetService.list());
    }



    @PostMapping(value = "/page")
    @ApiOperation(value = "分页查询")
    public ResponsePageData<HospitalSet> page(@RequestBody @Valid HospitalSetPageInput input) {

        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(input.getHosname())) {
            queryWrapper.like("hosname",input.getHosname());
        }
        if(StringUtils.isNotBlank(input.getHoscode())) {
            queryWrapper.eq("hoscode",input.getHoscode());
        }
        Page<HospitalSet> page = hospitalSetService.page(new Page<>(input.getPageIndex(), input.getPageSize()), queryWrapper);
        return ResponsePageData.success(page.getRecords(),page.getTotal());
    }




}


@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel(description = "医院分页查询表单")
class HospitalSetPageInput extends PageInput {



    /**
     * 医院名称
     */
    @ApiModelProperty(value = "医院名称")
    private String hosname;

    /**
     * 医院编号
     */
    @ApiModelProperty(value = "医院编码")
    private String hoscode;



}


