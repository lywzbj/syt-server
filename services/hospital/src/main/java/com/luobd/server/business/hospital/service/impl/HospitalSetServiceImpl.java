package com.luobd.server.business.hospital.service.impl;

import com.luobd.server.business.hospital.entity.HospitalSet;
import com.luobd.server.business.hospital.mapper.HospitalSetMapper;
import com.luobd.server.business.hospital.service.IHospitalSetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 医院设置表 服务实现类
 * </p>
 *
 * @author Luoyu
 * @since 2024-06-26
 */
@Service
@Primary
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements IHospitalSetService {


}
