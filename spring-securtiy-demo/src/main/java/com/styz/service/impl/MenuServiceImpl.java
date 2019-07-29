package com.styz.service.impl;

import com.styz.api.model.PermissionResource;
import com.styz.entity.Menu;
import com.styz.enums.MenuEnum;
import com.styz.security.service.PermessionResourcesService;
import com.styz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * creat date:2019-07-25 13:24
 * author:xxydliuyss
 * note:
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private PermessionResourcesService permessionResourcesService;
    @Override
    public Map<Long, Menu> getTreeMenu(String username) {
        HashMap<Long, Menu> treeMap = new HashMap<>();
        List<PermissionResource> menuResources = permessionResourcesService.getMenuResourceByUserName(username);
        for(PermissionResource resource : menuResources){
            if(resource.getMenutype() == MenuEnum.SECONDE.getLevel()){
                if(treeMap.get(resource.getParentresourceid())!=null){
                    treeMap.get(resource.getParentresourceid()).getChildren().put(resource.getGid(),new Menu(resource));
                }else{
                    treeMap.put(resource.getParentresourceid(),new Menu());
                    treeMap.get(resource.getParentresourceid()).getChildren().put(resource.getGid(),new Menu(resource));
                }
            }
            //如果是顶级菜单
            else if(resource.getMenutype() == MenuEnum.TOP.getLevel()){
                if(treeMap.get(resource.getGid())!=null){
                    treeMap.get(resource.getGid()).setCurrentMenu(resource);
                }else {
                    treeMap.put(resource.getGid(),new Menu(resource));
                }
            }
        }
        return treeMap;
    }
}
