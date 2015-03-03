package org.motechproject.csd.service;

import ihe.iti.csd._2013.GetModificationsRequest;
import ihe.iti.csd._2013.GetModificationsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;


@Endpoint
public class FooBar {
    private SaajSoapMessageFactory messageFactory;

    @Autowired
    public FooBar(SaajSoapMessageFactory messageFactory) {
        this.messageFactory = messageFactory;
        this.messageFactory.setSoapVersion(SoapVersion.SOAP_12);
    }

    @PayloadRoot(namespace = "http://localhost:8080/motech-platform-server/module/csd/foobar", localPart = "getFacilityRequest")
    @ResponsePayload
    public GetModificationsResponse getFacility(@RequestPayload GetModificationsRequest request) {
        GetModificationsResponse response = new GetModificationsResponse();

        return response;
    }
}
