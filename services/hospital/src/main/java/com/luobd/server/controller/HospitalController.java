package com.luobd.server.controller;


import com.luobd.server.business.hospital.entity.HospitalSet;
import com.luobd.server.business.hospital.service.IHospitalSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "医院模块")
@RequestMapping(value = "/api/hospital")
@Slf4j
public class HospitalController {


    @Resource
    private IHospitalSetService hospitalSetService;



    @GetMapping(value = "/test")
    @ApiOperation(value = "测试接口")
    public String test(@RequestParam(value = "id") String id) {
        log.info("test");
        HospitalSet set = hospitalSetService.getById(1L);
        System.out.println(1/0);
        return  id + "success";
    }




}
