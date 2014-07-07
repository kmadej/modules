package org.motechproject.hub.mds;

// Generated Apr 21, 2014 6:59:44 PM by Hibernate Tools 3.4.0.CR1

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

/**
 * HubSubscriberTransaction generated by hbm2java
 */
@Entity
public class HubSubscriberTransaction implements java.io.Serializable {

    private static final long serialVersionUID = -2823908898058704053L;

    @Field(required = true)
    private Integer hubDistributionStatusId;

    @Field(required = true)
    private Integer hubSubscriptionId;

    @Field
    private Integer contentId;

    public Integer getHubDistributionStatusId() {
        return hubDistributionStatusId;
    }

    public void setHubDistributionStatusId(Integer hubDistributionStatusId) {
        this.hubDistributionStatusId = hubDistributionStatusId;
    }

    public Integer getHubSubscriptionId() {
        return hubSubscriptionId;
    }

    public void setHubSubscriptionId(Integer hubSubscriptionId) {
        this.hubSubscriptionId = hubSubscriptionId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public HubSubscriberTransaction() {
    }

    public HubSubscriberTransaction(Integer hubDistributionStatusId,
            Integer hubSubscriptionId, Integer contentId) {
        this.hubDistributionStatusId = hubDistributionStatusId;
        this.hubSubscriptionId = hubSubscriptionId;
        this.contentId = contentId;
    }

}