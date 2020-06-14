package com.mh.hisplat.entry;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@Builder
public class CacheUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer uId;

    private String username;

//   private String password;

    private String phone;

    private String name;

    private Integer sex;

    private String idNum;

    private String email;

    private String address;

    private Integer provinceCode;

    private Integer cityCode;

    private Date birthday;

    private Date createTime;

    private Date updateTime;

    private Integer rId;

    private String token;
}
