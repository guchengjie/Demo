package com.bbs.entity;

import java.io.Serializable;
/**
 * 用于存放用户信息的实体对象
 */
public class Userinfo implements Serializable
{
    private Integer userid;
    private String loginname;
    private String loginpwd;
    private String email;
    private String head;
    private String regtime;
    private Integer state;
    private Integer point;
    public Integer getUserid()
    {
        return userid;
    }
    public void setUserid(Integer userid)
    {
        this.userid = userid;
    }
    public String getLoginname()
    {
        return loginname;
    }
    public void setLoginname(String loginname)
    {
        this.loginname = loginname;
    }
    public String getLoginpwd()
    {
        return loginpwd;
    }
    public void setLoginpwd(String loginpwd)
    {
        this.loginpwd = loginpwd;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getHead()
    {
        return head;
    }
    public void setHead(String head)
    {
        this.head = head;
    }
    public String getRegtime()
    {
        return regtime;
    }
    public void setRegtime(String regtime)
    {
        this.regtime = regtime;
    }
    public Integer getState()
    {
        return state;
    }
    public void setState(Integer state)
    {
        this.state = state;
    }
    public Integer getPoint()
    {
        return point;
    }
    public void setPoint(Integer point)
    {
        this.point = point;
    }
    public Userinfo(Integer userid, String loginname, String loginpwd, String email, String head, String regtime, Integer state, Integer point)
    {
        this.userid = userid;
        this.loginname = loginname;
        this.loginpwd = loginpwd;
        this.email = email;
        this.head = head;
        this.regtime = regtime;
        this.state = state;
        this.point = point;
    }
    public Userinfo()
    {
     
    }

}
