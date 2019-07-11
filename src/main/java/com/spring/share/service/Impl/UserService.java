package com.spring.share.service.Impl;

import com.spring.share.dao.IUserDao;
import com.spring.share.model.UserModel;
import com.spring.share.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 处理用户相关事务操作
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public int addUserInfo(UserModel userModel) {
        return userDao.addUserInfo(userModel);
    }
}
