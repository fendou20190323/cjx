package com.lss.common.base;

import com.alibaba.fastjson.JSONObject;
import com.lss.common.util.JWTUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangyg
 */
@Transactional
public class BaseServiceImpl implements BaseService {
    /**
     * 线程安全类
     *
     * @return HttpServletRequest
     */
    public String getCurrentUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
            JSONObject jsonObject=JWTUtils.getInstance().getTokenSub(request.getHeader("accessToken"));
            return jsonObject.getString("userId");
        } catch (Exception e) {
            return null;
        }
    }

    public JSONObject getCurrentUserInfo() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
            return JWTUtils.getInstance().getTokenSub(request.getHeader("accessToken"));
        } catch (Exception e) {
            return null;
        }
    }

    public String getCurrentTenantId() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
            JSONObject jsonObject=JWTUtils.getInstance().getTokenSub(request.getHeader("accessToken"));
            return jsonObject.getString("tenantId");
        } catch (Exception e) {
            return null;
        }
    }

}
