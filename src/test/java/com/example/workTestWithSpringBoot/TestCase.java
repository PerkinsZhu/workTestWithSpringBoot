package com.example.workTestWithSpringBoot;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.apache.shiro.mgt.SecurityManager;

public class TestCase {
    @Test
    public void demoIni() {
        //init配置文件初始化SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");

        try {
            subject.login(token);

        } catch (AuthenticationException ex) {
            ex.printStackTrace();
        }

        org.junit.Assert.assertEquals(true, subject.isAuthenticated());

        subject.logout();
    }

    @Test
    public void demoCustomRealm(){
        //init配置文件初始化SecurityManager工厂
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("admin","123456");

        try{
            subject.login(token);
        }catch (AuthenticationException ex){

        }

        org.junit.Assert.assertEquals(true,subject.isAuthenticated());

        subject.logout();
    }


    @Test
    public void demoJdbcRealm(){
        //init配置文件初始化SecurityManager工厂
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        SecurityManager securityManager=factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject=SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken("admin","123");

        try{
            subject.login(token);
        }catch (AuthenticationException ex){

        }

        org.junit.Assert.assertEquals(true,subject.isAuthenticated());

        subject.logout();
    }
}
