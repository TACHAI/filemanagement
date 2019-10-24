package com.chaoxing.filemanagement.vo;

import com.chaoxing.filemanagement.po.User;
import lombok.Data;

/**
 * Create by tachai on 2019-10-23 15:44
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Data
public class UserVO extends User {
    private String token;

    private String permission;
}
