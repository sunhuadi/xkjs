package com.xkjs.pojo;

import lombok.Data;

import javax.xml.soap.Text;
import java.util.Date;

@Data
public class Notice {
    int id;
    Text title;
    Date releaseTime;
    Text detail;
}
