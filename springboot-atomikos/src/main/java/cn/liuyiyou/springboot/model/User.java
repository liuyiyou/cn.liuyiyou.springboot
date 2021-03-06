package cn.liuyiyou.springboot.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.id
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private Long id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.company_id
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private Long companyId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.office_id
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private Long officeId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.city_id
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private Long cityId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.city_name
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String cityName;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.login_name
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String loginName;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.password
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String password;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.no
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String no;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.name
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String name;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.nick_name
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String nickName;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.email
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String email;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.phone
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String phone;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.mobile
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String mobile;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.user_type
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String userType;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.photo
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String photo;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.crm_uid
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private Long crmUid;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.inpass_uid
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private Long inpassUid;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.workstation_id
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private Long workstationId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.login_ip
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String loginIp;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.login_date
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private Date loginDate;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.login_flag
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String loginFlag;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.create_by
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private Long createBy;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.create_date
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private Date createDate;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.update_by
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private Long updateBy;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.update_date
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private Date updateDate;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.remarks
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String remarks;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column t_user.del_flag
     *
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    private String delFlag;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.id
     *
     * @return the value of t_user.id
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.company_id
     *
     * @return the value of t_user.company_id
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.company_id
     *
     * @param companyId the value for t_user.company_id
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.office_id
     *
     * @return the value of t_user.office_id
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.office_id
     *
     * @param officeId the value for t_user.office_id
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.city_id
     *
     * @return the value of t_user.city_id
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.city_id
     *
     * @param cityId the value for t_user.city_id
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.city_name
     *
     * @return the value of t_user.city_name
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.city_name
     *
     * @param cityName the value for t_user.city_name
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.login_name
     *
     * @return the value of t_user.login_name
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.login_name
     *
     * @param loginName the value for t_user.login_name
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.password
     *
     * @return the value of t_user.password
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.password
     *
     * @param password the value for t_user.password
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.no
     *
     * @return the value of t_user.no
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getNo() {
        return no;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.no
     *
     * @param no the value for t_user.no
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.name
     *
     * @return the value of t_user.name
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.name
     *
     * @param name the value for t_user.name
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.nick_name
     *
     * @return the value of t_user.nick_name
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.nick_name
     *
     * @param nickName the value for t_user.nick_name
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.email
     *
     * @return the value of t_user.email
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.email
     *
     * @param email the value for t_user.email
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.phone
     *
     * @return the value of t_user.phone
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.phone
     *
     * @param phone the value for t_user.phone
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.mobile
     *
     * @return the value of t_user.mobile
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.mobile
     *
     * @param mobile the value for t_user.mobile
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.user_type
     *
     * @return the value of t_user.user_type
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getUserType() {
        return userType;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.user_type
     *
     * @param userType the value for t_user.user_type
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.photo
     *
     * @return the value of t_user.photo
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.photo
     *
     * @param photo the value for t_user.photo
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.crm_uid
     *
     * @return the value of t_user.crm_uid
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public Long getCrmUid() {
        return crmUid;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.crm_uid
     *
     * @param crmUid the value for t_user.crm_uid
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setCrmUid(Long crmUid) {
        this.crmUid = crmUid;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.inpass_uid
     *
     * @return the value of t_user.inpass_uid
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public Long getInpassUid() {
        return inpassUid;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.inpass_uid
     *
     * @param inpassUid the value for t_user.inpass_uid
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setInpassUid(Long inpassUid) {
        this.inpassUid = inpassUid;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.workstation_id
     *
     * @return the value of t_user.workstation_id
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public Long getWorkstationId() {
        return workstationId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.workstation_id
     *
     * @param workstationId the value for t_user.workstation_id
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setWorkstationId(Long workstationId) {
        this.workstationId = workstationId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.login_ip
     *
     * @return the value of t_user.login_ip
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.login_ip
     *
     * @param loginIp the value for t_user.login_ip
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.login_date
     *
     * @return the value of t_user.login_date
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.login_date
     *
     * @param loginDate the value for t_user.login_date
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.login_flag
     *
     * @return the value of t_user.login_flag
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getLoginFlag() {
        return loginFlag;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.login_flag
     *
     * @param loginFlag the value for t_user.login_flag
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.create_by
     *
     * @return the value of t_user.create_by
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.create_by
     *
     * @param createBy the value for t_user.create_by
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.create_date
     *
     * @return the value of t_user.create_date
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.create_date
     *
     * @param createDate the value for t_user.create_date
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.update_by
     *
     * @return the value of t_user.update_by
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.update_by
     *
     * @param updateBy the value for t_user.update_by
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.update_date
     *
     * @return the value of t_user.update_date
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.update_date
     *
     * @param updateDate the value for t_user.update_date
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.remarks
     *
     * @return the value of t_user.remarks
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.remarks
     *
     * @param remarks the value for t_user.remarks
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column t_user.del_flag
     *
     * @return the value of t_user.del_flag
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column t_user.del_flag
     *
     * @param delFlag the value for t_user.del_flag
     * @mbg.generated Wed Jul 26 20:22:10 CST 2017
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}