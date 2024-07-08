package com.luobd.server.base.business.dict.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luobd.server.base.business.dict.entity.CoreDict;
import com.luobd.server.base.business.dict.input.DictCreateInput;
import com.luobd.server.base.business.dict.mapper.CoreDictMapper;
import com.luobd.server.base.business.dict.service.ICoreDictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luobd.server.common.utils.HutoolSnowIdWorkUtil;
import org.springframework.context.annotation.Primary;
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
@Primary
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseData<Long> create(DictCreateInput input) {
        QueryWrapper<CoreDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",input.getType());
        queryWrapper.eq("dictValue",input.getDictValue());
        int count = this.count(queryWrapper);
        if(count > 0) {
            return ResponseData.error("字典值已存在");
        }

        CoreDict dict = new CoreDict();
        dict.setId(HutoolSnowIdWorkUtil.nextId());
        dict.setDictCode(HutoolSnowIdWorkUtil.nextId());
        dict.setDictValue(input.getDictValue());
        dict.setRemark(input.getRemark());
        dict.setParentId(input.getParentId());
        this.save(dict);
        return ResponseData.success(dict.getId());
    }


}
