package com.chaoxing.filemanagement.service.impl;

import com.chaoxing.filemanagement.common.ResponseString;
import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.dao.PermissionsMapper;
import com.chaoxing.filemanagement.dao.UserMapper;
import com.chaoxing.filemanagement.po.Permissions;
import com.chaoxing.filemanagement.po.User;
import com.chaoxing.filemanagement.service.UserService;
import com.chaoxing.filemanagement.util.JWTUtil;
import com.chaoxing.filemanagement.util.MD5Util;
import com.chaoxing.filemanagement.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Create by tachai on 2019-10-22 08:40
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;
    @Autowired
    private PermissionsMapper permissionDao;



    @Override
    public ServerResponse<String> addUser(User user) {
        int temp = userDao.selectByEmail(user.getEmail());
        if(temp>0){
            return ServerResponse.createByErrorMessage("该邮箱号已使用，新增失败");
        }
        user.setInsertTime(new Date());
        user.setIsDelete(ResponseString.UN_DELETE);
        String pwd = user.getPassword();
        pwd= MD5Util.MD5(pwd);
        user.setPassword(pwd);

        int res = userDao.insert(user);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.ADD_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.ADD_FAIL);
    }

    @Override
    public ServerResponse<String> deleteById(Integer id) {
        User user = userDao.selectByPrimaryKey(id);
        user.setIsDelete(ResponseString.IS_DELETE);

        return update(user);
    }

    @Override
    public ServerResponse<String> updateUser(User user) {
        return update(user);
    }

    @Override
    public ServerResponse<User> selectById(Integer id) {
        User user = userDao.selectByPrimaryKey(id);
        return ServerResponse.createBySuccess(user,ResponseString.SELECT_SUCCESS);
    }

    @Override
    public ServerResponse<UserVO> login(String email, String password) {
        String pwd=MD5Util.MD5(password);
        User user = userDao.login(email,pwd);
        if(user==null){
            return ServerResponse.createByErrorMessage("未找到该用户，用户名或密码错误");
        }

        String token = JWTUtil.sign(user.getName(),user.getPassword(),user.getId());
        user.setPassword(StringUtils.EMPTY);

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        userVO.setToken(token);

        return ServerResponse.createBySuccess(userVO,"登录成功");
    }

    @Override
    public ServerResponse<List<User>> listUserByDeptId(Integer deptId) {
        List<User> list = userDao.selectByDeptId(deptId);
        return ServerResponse.createBySuccess(list,ResponseString.SELECT_SUCCESS);
    }

    @Override
    public UserVO selectUserVO(Integer id) {
        User user = userDao.selectByPrimaryKey(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        List<Permissions> list= permissionDao.selectByDeptId(user.getDeptId());
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<list.size();i++){
            buffer.append(list.get(i).getPermission()).append(";");
        }
        userVO.setPermission(buffer.toString());
        return userVO;
    }


    private ServerResponse<String> update(User user){
        int res = userDao.updateByPrimaryKeySelective(user);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.UPDATE_FAIL);
    }
}
