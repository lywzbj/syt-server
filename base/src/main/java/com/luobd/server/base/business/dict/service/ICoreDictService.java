package com.luobd.server.base.business.dict.service;

import com.luobd.server.base.business.dict.entity.CoreDict;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luobd.server.common.model.ResponseData;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Luoyu
 * @since 2024-06-30
 */
public interface ICoreDictService extends IService<CoreDict> {


   ResponseData<Boolean> delete(Long id);



  ResponseData<Boolean> batchDelete(List<Long> ids);












}
