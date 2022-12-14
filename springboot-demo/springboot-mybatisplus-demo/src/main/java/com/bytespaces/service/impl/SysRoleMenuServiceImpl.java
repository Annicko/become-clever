package com.bytespaces.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bytespaces.dao.SysRoleMenuDao;
import com.bytespaces.entity.SysRoleMenuEntity;
import com.bytespaces.service.SysRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色与菜单对应关系
 *
 * @author Annicko
 * 
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenuEntity>
        implements SysRoleMenuService {

    @Override
    @Transactional
    public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
        if (menuIdList.size() == 0) {
            return;
        }
        // 先删除角色与菜单关系
        baseMapper.deleteNoMapper(roleId);

        // 保存角色与菜单关系
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        map.put("menuIdList", menuIdList);
        baseMapper.save(map);
    }

    @Override
    public List<Long> queryMenuIdList(Long roleId) {
        return baseMapper.queryMenuIdList(roleId);
    }

}
