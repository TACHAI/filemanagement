package com.chaoxing.filemanagement.vo;

import com.google.gson.Gson;
import lombok.Data;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by tachai on 2019-10-29 13:43
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Data
public class DeptVO {
    private Integer id;
    private String deptName;
    private List<DeptVO> deptVO;

/*
    HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
    PrintWriter out = null;
    Gson res = new Gson();
    Map<String, Object> map = new HashMap<>();
            map.put("status",1);
            map.put("msg","token验证失效");
    out= httpServletResponse.getWriter();
            out.append(res.toJson(map));
*/

}
