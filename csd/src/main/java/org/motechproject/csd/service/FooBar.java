package org.motechproject.csd.service;

import ihe.iti.csd._2013.GetModificationsRequest;
import ihe.iti.csd._2013.GetModificationsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class FooBar {

    @PayloadRoot(namespace = "urn:ihe:iti:csd:2013", localPart = "getModificationsRequest")
    @ResponsePayload
    public GetModificationsResponse getFacility(@RequestPayload GetModificationsRequest request) {
        GetModificationsResponse response = new GetModificationsResponse();

        return response;
    }
}
