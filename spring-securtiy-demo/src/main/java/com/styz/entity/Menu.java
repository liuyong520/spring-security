package com.styz.entity;

import com.styz.api.model.PermissionResource;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

/**
 * creat date:2019-07-25 12:39
 * author:xxydliuyss
 * note:
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Menu {
    private PermissionResource currentMenu;
    private Map<Long,Menu> children = new HashMap<Long,Menu>();

    public Menu(PermissionResource currentMenu) {
        this.currentMenu = currentMenu;
    }
}
