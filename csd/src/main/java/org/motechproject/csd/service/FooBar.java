package org.motechproject.csd.service;

import ihe.iti.csd._2013.GetModificationsRequest;
import ihe.iti.csd._2013.GetModificationsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class FooBar {
    @PayloadRoot(namespace = "http://localhost:8080/motech-platform-server/module/csd/foobar", localPart = "getFacilityRequest")
    @ResponsePayload
    public GetModificationsResponse getFacility(@RequestPayload GetModificationsRequest request) {
        GetModificationsResponse response = new GetModificationsResponse();

        return response;
    }
}
