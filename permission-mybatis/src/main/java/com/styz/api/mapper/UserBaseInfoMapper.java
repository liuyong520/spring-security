package com.styz.api.mapper;

import com.styz.api.model.UserBaseInfo;import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Mybatis Generator 2019/07/25
 */
public interface UserBaseInfoMapper {
    int deleteByPrimaryKey(Long gid);

    int insert(UserBaseInfo record);

    int insertSelective(UserBaseInfo record);

    UserBaseInfo selectByPrimaryKey(Long gid);

    int updateByPrimaryKeySelective(UserBaseInfo record);

    int updateByPrimaryKeyWithBLOBs(UserBaseInfo record);

    int updateByPrimaryKey(UserBaseInfo record);

    UserBaseInfo findUserByUserName(@Param("username") String username);

    List<UserBaseInfo> findAllUsers();
}