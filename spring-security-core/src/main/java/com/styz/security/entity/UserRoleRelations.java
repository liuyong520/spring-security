package com.styz.security.entity;

import com.styz.api.model.PermissionRelationRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * creat date:2019-07-14 13:49
 * author:xxydliuyss
 * note:
 */
@Data
@AllArgsConstructor
public class UserRoleRelations {

    private Object roleRelation;

    public UserRoleRelations(List<PermissionRelationRole> relationRoles) {
        this.roleRelation = relationRoles;
    }
}
