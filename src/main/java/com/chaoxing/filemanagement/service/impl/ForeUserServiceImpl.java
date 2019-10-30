package com.chaoxing.filemanagement.service.impl;

import com.chaoxing.filemanagement.common.ResponseString;
import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.dao.DeptMapper;
import com.chaoxing.filemanagement.dao.ForeUserMapper;
import com.chaoxing.filemanagement.dao.PermissionsMapper;
import com.chaoxing.filemanagement.dao.UserMapper;
import com.chaoxing.filemanagement.po.ForeUser;
import com.chaoxing.filemanagement.po.Permissions;
import com.chaoxing.filemanagement.po.User;
import com.chaoxing.filemanagement.service.ForeUserService;
import com.chaoxing.filemanagement.service.UserService;
import com.chaoxing.filemanagement.util.JWTUtil;
import com.chaoxing.filemanagement.util.MD5Util;
import com.chaoxing.filemanagement.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Create by tachai on 2019-10-22 08:40
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Service("ForeUserServiceImpl")
public class ForeUserServiceImpl implements ForeUserService {

    @Autowired
    private ForeUserMapper userDao;
    @Autowired
    private DeptMapper deptDao;

    @Override
    public ServerResponse<String> addUser(ForeUser user) {
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
        ForeUser user = userDao.selectByPrimaryKey(id);
        user.setIsDelete(ResponseString.IS_DELETE);

        return update(user);
    }

    @Override
    public ServerResponse<String> updateUser(ForeUser user) {
        return update(user);
    }

    @Override
    public ServerResponse<ForeUser> selectById(Integer id) {
        ForeUser user = userDao.selectByPrimaryKey(id);
        return ServerResponse.createBySuccess(user,ResponseString.SELECT_SUCCESS);
    }

    @Override
    public ServerResponse<UserVO> login(String email, String password) {
        String pwd=MD5Util.MD5(password);
        ForeUser user = userDao.login(email,pwd);
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
    public ServerResponse<List<ForeUser>> listUserByDeptId(Integer deptId) {
        List<ForeUser> list = userDao.selectByDeptId(deptId);
        return ServerResponse.createBySuccess(list,ResponseString.SELECT_SUCCESS);
    }

    @Override
    public ServerResponse<List<UserVO>> listUser() {


        List<ForeUser> list = userDao.listUser();
        List<UserVO> userVOList = new ArrayList<>();
        list.forEach(e->{
            UserVO vo = new UserVO();

            BeanUtils.copyProperties(e,vo);
            vo.setName(deptDao.selectByPrimaryKey(e.getDeptId()).getName());
            userVOList.add(vo);
        });
        return ServerResponse.createBySuccess(userVOList,ResponseString.SELECT_SUCCESS);
    }



    private ServerResponse<String> update(ForeUser user){
        int res = userDao.updateByPrimaryKeySelective(user);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.UPDATE_FAIL);
    }
}
