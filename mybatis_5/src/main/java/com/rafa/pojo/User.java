package com.rafa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String user_name;
    private String pubKey;

}
