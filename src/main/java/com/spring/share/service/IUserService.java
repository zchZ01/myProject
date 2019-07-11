package com.spring.share.service;

import com.spring.share.model.UserModel;

/**
 * 用户相关操作的事务层
 */
public interface IUserService {
    /**
     * 添加用户信息
     * @param userModel 需要添加的用户实体
     * @return 返回添加编号
     */
    int addUserInfo(UserModel userModel);
}
