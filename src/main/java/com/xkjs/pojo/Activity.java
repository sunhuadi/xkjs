package com.xkjs.pojo;

import lombok.Data;
import org.attoparser.trace.MarkupTraceEvent;

import javax.xml.soap.Text;

@Data
public class Activity {
    int aid;
    java.sql.Timestamp startDate;
    java.sql.Timestamp endDate;
    String detail;
    String teacher;
    String sponsor;
    String title;
}
