package com.example.soapapp.endpoint;

import com.example.soapapp.payload.RequestWrapper;
import com.example.soapapp.payload.ResponseWrapper;
import com.example.soapapp.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Endpoint
public class AppEndpoint {

    @Autowired
    AppService appService;

    @PayloadRoot(namespace = "http://www.example.org/soapapp/payload",localPart = "request")
    @ResponsePayload
    public ResponseWrapper processRequest(@RequestPayload RequestWrapper requestWrapper) throws IOException, NoSuchAlgorithmException {


        ResponseWrapper responseWrapper = new ResponseWrapper();

        String hashcode = appService.getHash(requestWrapper.getFilename());
        responseWrapper.setHashcode(hashcode);

        System.out.println(responseWrapper.getHashcode());

        return responseWrapper;
    }
}
