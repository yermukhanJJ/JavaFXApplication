package com.example.soapapp.payload;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public RequestWrapper createRequestWrapper() {
        return new RequestWrapper();
    }

    public ResponseWrapper createResponseWrapper() {
        return new ResponseWrapper();
    }
}
