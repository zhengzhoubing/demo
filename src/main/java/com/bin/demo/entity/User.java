package com.bin.demo.entity;

/**
 * package: com.bin.demo.entity
 * class: User
 * description: TODO用一句话描述该文件做什么
 * date 2020/1/15 15:43
 *
 * @author ZhengZhouBin
 **/
public class User {
    private Long userId;

    private String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
