package com.luobd.server.base.business.dict.service.impl;

import com.luobd.server.base.business.dict.entity.CoreDict;
import com.luobd.server.base.business.dict.mapper.CoreDictMapper;
import com.luobd.server.base.business.dict.service.ICoreDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.luobd.server.common.model.ResponseData;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Luoyu
 * @since 2024-06-30
 */
@Service
public class CoreDictServiceImpl extends ServiceImpl<CoreDictMapper, CoreDict> implements ICoreDictService {


  @Resource
  private CoreDictMapper baseMapper;


@Override
@Transactional(rollbackFor = Exception.class)
public ResponseData<Boolean> delete(Long id) {
    final boolean remove = this.removeById(id);
    if(!remove) {
    return ResponseData.error("删除失败");
    }
    return ResponseData.success(Boolean.TRUE);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseData<Boolean> batchDelete(List<Long> ids) {
            final boolean remove = this.removeByIds(ids);
            if(!remove) {
            return ResponseData.error("删除失败");
            }
            return ResponseData.success(Boolean.TRUE);
            }






}
