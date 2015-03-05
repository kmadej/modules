package org.motechproject.csd.service;

import ihe.iti.csd._2013.CSD;
import ihe.iti.csd._2013.Facility;
import ihe.iti.csd._2013.GetModificationsRequest;
import ihe.iti.csd._2013.GetModificationsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.addressing.server.annotation.Action;


@Endpoint
public class FooBar {

    private static final Logger LOGGER = LoggerFactory.getLogger(FooBar.class);

    @PayloadRoot(namespace = "urn:ihe:iti:csd:2013", localPart = "getModificationsRequest")
    @ResponsePayload
    public GetModificationsResponse getMod1(@RequestPayload GetModificationsRequest request) {
        LOGGER.debug("getMod1");
        GetModificationsResponse response = new GetModificationsResponse();

        Facility facility = new Facility();
        facility.setPrimaryName("Clinique Foobar");
        CSD.FacilityDirectory facilityDirectory = new CSD.FacilityDirectory();
        facilityDirectory.getFacility().add(facility);
        CSD csd = new CSD();
        csd.setFacilityDirectory(facilityDirectory);

        response.setCSD(csd);
        return response;
    }

    @Action(value = "urn:ihe:iti:csd:2013:GetDirectoryModificationsRequest")
    public GetModificationsResponse getMod2(@RequestPayload GetModificationsRequest request) {
        LOGGER.debug("getMod2");
        GetModificationsResponse response = new GetModificationsResponse();

        Facility facility = new Facility();
        facility.setPrimaryName("Clinique Foobar");
        CSD.FacilityDirectory facilityDirectory = new CSD.FacilityDirectory();
        facilityDirectory.getFacility().add(facility);
        CSD csd = new CSD();
        csd.setFacilityDirectory(facilityDirectory);

        response.setCSD(csd);
        return response;
    }
}
