package com.spring.share.dao;

import com.spring.share.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户数据层接口
 */
@Mapper
public interface IUserDao {
    /**
     * 添加用户信息
     * @param userModel 需要添加的用户实体
     * @return 返回添加编号
     */

    int addUserInfo(UserModel userModel);
}
