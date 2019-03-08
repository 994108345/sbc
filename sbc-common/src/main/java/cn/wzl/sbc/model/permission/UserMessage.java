package cn.wzl.sbc.model.permission;

import java.util.Date;

/**
 * @author ：wzl
 * @date ：Created in 2019/3/8 11:04
 * @description：用户信息父类
 */
public class UserMessage {
    private Integer usrInfoId;

    private String usrInfoUserCode;

    private String usrInfoUserName;

    private String usrInfoPassWord;

    private Date usrInfoCreateDate;

    private Date usrInfoLastModifiedDate;

    private String usrInfoCreateUser;

    private String usrInfoLastModifiedUser;

    public Integer getUsrInfoId() {
        return usrInfoId;
    }

    public void setUsrInfoId(Integer usrInfoId) {
        this.usrInfoId = usrInfoId;
    }

    public String getUsrInfoUserCode() {
        return usrInfoUserCode;
    }

    public void setUsrInfoUserCode(String usrInfoUserCode) {
        this.usrInfoUserCode = usrInfoUserCode;
    }

    public String getUsrInfoUserName() {
        return usrInfoUserName;
    }

    public void setUsrInfoUserName(String usrInfoUserName) {
        this.usrInfoUserName = usrInfoUserName;
    }

    public String getUsrInfoPassWord() {
        return usrInfoPassWord;
    }

    public void setUsrInfoPassWord(String usrInfoPassWord) {
        this.usrInfoPassWord = usrInfoPassWord;
    }

    public Date getUsrInfoCreateDate() {
        return usrInfoCreateDate;
    }

    public void setUsrInfoCreateDate(Date usrInfoCreateDate) {
        this.usrInfoCreateDate = usrInfoCreateDate;
    }

    public Date getUsrInfoLastModifiedDate() {
        return usrInfoLastModifiedDate;
    }

    public void setUsrInfoLastModifiedDate(Date usrInfoLastModifiedDate) {
        this.usrInfoLastModifiedDate = usrInfoLastModifiedDate;
    }

    public String getUsrInfoCreateUser() {
        return usrInfoCreateUser;
    }

    public void setUsrInfoCreateUser(String usrInfoCreateUser) {
        this.usrInfoCreateUser = usrInfoCreateUser;
    }

    public String getUsrInfoLastModifiedUser() {
        return usrInfoLastModifiedUser;
    }

    public void setUsrInfoLastModifiedUser(String usrInfoLastModifiedUser) {
        this.usrInfoLastModifiedUser = usrInfoLastModifiedUser;
    }
}
