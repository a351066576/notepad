package com.m.notepad.domain;

import java.io.Serializable;

/**
 * @author 酸辣粉
 * @description 权限实体类
 * @date 2020/1/23
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 4825683057053852732L;

    public static Integer ROLE_ADMIN = 1;

    public static Integer ROLE_USER = 2;

    private Long id;

    private String authority;

    public Role() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
