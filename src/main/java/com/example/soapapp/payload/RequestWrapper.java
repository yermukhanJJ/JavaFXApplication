package com.example.soapapp.payload;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class RequestWrapper {

    private String Filename;

    @XmlElement(name = "file")
    public String getFilename() {
        return Filename;
    }

    public void setFilename(String filename) {
        Filename = filename;
    }
}
