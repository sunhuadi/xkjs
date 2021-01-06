package com.xkjs.pojo;

import lombok.Data;
import org.thymeleaf.model.IText;

import javax.xml.soap.Text;

@Data
public class User {
    int uid;
    String name;
    String password;
    String username;
    String role;
}
