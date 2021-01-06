package com.xkjs.pojo;

import lombok.Data;
import org.attoparser.trace.MarkupTraceEvent;

import javax.xml.soap.Text;

@Data
public class Activity {
    int Id;
    java.sql.Timestamp startData;
    java.sql.Timestamp endData;
    String detail;
    String teacher;
    String sponsor;
    String title;
}
