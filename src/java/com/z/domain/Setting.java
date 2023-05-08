package com.z.domain;

import datasource.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "settings")
@XmlRootElement
@NamedQueries({
    @javax.persistence.NamedQuery(name = "Setting.findAll", query = "SELECT s FROM Setting s")
    , @javax.persistence.NamedQuery(name = "Setting.findBySettingId", query = "SELECT s FROM Setting s WHERE s.settingId = :settingId")
    , @javax.persistence.NamedQuery(name = "Setting.findByPath", query = "SELECT s FROM Setting s WHERE s.path = :path")
    , @javax.persistence.NamedQuery(name = "Setting.findByDomain", query = "SELECT s FROM Setting s WHERE s.domain = :domain")
    , @javax.persistence.NamedQuery(name = "Setting.findByADServerIP", query = "SELECT s FROM Setting s WHERE s.aDServerIP = :aDServerIP")
    , @javax.persistence.NamedQuery(name = "Setting.findByADUser", query = "SELECT s FROM Setting s WHERE s.aDUser = :aDUser")
    , @javax.persistence.NamedQuery(name = "Setting.findByADPassword", query = "SELECT s FROM Setting s WHERE s.aDPassword = :aDPassword")
    , @javax.persistence.NamedQuery(name = "Setting.findByDefaultOU", query = "SELECT s FROM Setting s WHERE s.defaultOU = :defaultOU")
    , @javax.persistence.NamedQuery(name = "Setting.findByAdditionalOU", query = "SELECT s FROM Setting s WHERE s.additionalOU = :additionalOU")
    , @javax.persistence.NamedQuery(name = "Setting.findByMailSenderID", query = "SELECT s FROM Setting s WHERE s.mailSenderID = :mailSenderID")
    , @javax.persistence.NamedQuery(name = "Setting.findByMailSenderName", query = "SELECT s FROM Setting s WHERE s.mailSenderName = :mailSenderName")})
public class Setting
        implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "setting_id")
    private Integer settingId;
    @Id
    @Basic(optional = false)
    @Column(name = "setting_id")
    private Integer max_sms_trial;
    @Id
    @Basic(optional = false)
    @Column(name = "setting_id")
    private Integer max_users;
    @Id
    @Basic(optional = false)
    @Column(name = "setting_id")
    private Integer max_email;
    @Column(name = "path")
    private String path;
    @Column(name = "path")
    private String msg;
    @Column(name = "path")
    private String op;
    @Column(name = "Domain")
    private String domain;
    @Column(name = "ADServerIP")
    private String aDServerIP;
    @Column(name = "ADUser")
    private String aDUser;
    @Column(name = "ADPassword")
    private String aDPassword;
    @Column(name = "DefaultOU")
    private String defaultOU;
    @Column(name = "DefaultOU")
    private String app_title;
    @Column(name = "DefaultOU")
    private String app_footer;
    @Column(name = "AdditionalOU")
    private String additionalOU;
    @Column(name = "AdditionalOU")
    private String mail_host;
    @Column(name = "MailSenderID")
    private String mailSenderID;
    @Column(name = "MailSenderName")
    private String mailSenderName;
    @Column(name = "MailSenderName")
    private String app_moto;
    @Lob
    @Column(name = "BULK_SMS_URL")
    private String bulkSmsUrl;
    @Lob
    @Column(name = "BULK_SMS_URL")
    private String base_url;

    public Setting() {
        op = "Update";
    }

    public String getApp_moto() {
        return app_moto;
    }

    public void setApp_moto(String app_moto) {
        this.app_moto = app_moto;
    }

    public String getMail_host() {
        return mail_host;
    }

    public void setMail_host(String mail_host) {
        this.mail_host = mail_host;
    }

    public String getApp_title() {
        return app_title;
    }

    public Integer getMax_sms_trial() {
        return max_sms_trial;
    }

    public void setMax_sms_trial(Integer max_sms_trial) {
        this.max_sms_trial = max_sms_trial;
    }

    public Integer getMax_users() {
        return max_users;
    }

    public void setMax_users(Integer max_users) {
        this.max_users = max_users;
    }

    public Integer getMax_email() {
        return max_email;
    }

    public void setMax_email(Integer max_email) {
        this.max_email = max_email;
    }

    public void setApp_title(String app_title) {
        this.app_title = app_title;
    }

    public String getApp_footer() {
        return app_footer;
    }

    public void setApp_footer(String app_footer) {
        this.app_footer = app_footer;
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getaDServerIP() {
        return aDServerIP;
    }

    public void setaDServerIP(String aDServerIP) {
        this.aDServerIP = aDServerIP;
    }

    public String getaDUser() {
        return aDUser;
    }

    public void setaDUser(String aDUser) {
        this.aDUser = aDUser;
    }

    public String getaDPassword() {
        return aDPassword;
    }

    public void setaDPassword(String aDPassword) {
        this.aDPassword = aDPassword;
    }

    public Setting(Integer settingId) {
        op = "Update";
        this.settingId = settingId;
    }

    public Integer getSettingId() {
        return settingId;
    }

    public void setSettingId(Integer settingId) {
        this.settingId = settingId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getADServerIP() {
        return aDServerIP;
    }

    public void setADServerIP(String aDServerIP) {
        this.aDServerIP = aDServerIP;
    }

    public String getADUser() {
        return aDUser;
    }

    public void setADUser(String aDUser) {
        this.aDUser = aDUser;
    }

    public String getADPassword() {
        return aDPassword;
    }

    public void setADPassword(String aDPassword) {
        this.aDPassword = aDPassword;
    }

    public String getDefaultOU() {
        return defaultOU;
    }

    public void setDefaultOU(String defaultOU) {
        this.defaultOU = defaultOU;
    }

    public String getAdditionalOU() {
        return additionalOU;
    }

    public void setAdditionalOU(String additionalOU) {
        this.additionalOU = additionalOU;
    }

    public String getMailSenderID() {
        return mailSenderID;
    }

    public void setMailSenderID(String mailSenderID) {
        this.mailSenderID = mailSenderID;
    }

    public String getMailSenderName() {
        return mailSenderName;
    }

    public void setMailSenderName(String mailSenderName) {
        this.mailSenderName = mailSenderName;
    }

    public String getBulkSmsUrl() {
        return bulkSmsUrl;
    }

    public void setBulkSmsUrl(String bulkSmsUrl) {
        this.bulkSmsUrl = bulkSmsUrl;
    }

    public int hashCode() {
        int hash = 0;
        hash += (settingId != null ? settingId.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Setting)) {
            return false;
        }
        Setting other = (Setting) object;
        return ((settingId != null) || (settingId == null)) && ((settingId == null) || (settingId.equals(settingId)));
    }

    public String toString() {
        return "resources.Setting[ settingId=" + settingId + " ]";
    }
}
