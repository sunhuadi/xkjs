package com.xkjs.pojo;

import lombok.Data;
import org.attoparser.trace.MarkupTraceEvent;

import javax.xml.soap.Text;

@Data
public class Activity {
    int aId;
    Data startTime;
    Data endTime;
    Text detail;
    Text teacher;
}
