package org.motechproject.commcare.domain;

import java.util.Objects;

/**
 * Domain class representing case metadata, retrieved from CommCareHQ server.
 */
public class CommcareMetadataInfo {

    private int limit;
    private String nextPageQueryString;
    private int offset;
    private String previousPageQueryString;
    private int totalCount;

    public CommcareMetadataInfo() { }

    public CommcareMetadataInfo(int limit, String nextPageQueryString, int offset, String previousPageQueryString, int totalCount) {
        this.limit = limit;
        this.nextPageQueryString = nextPageQueryString;
        this.offset = offset;
        this.previousPageQueryString = previousPageQueryString;
        this.totalCount = totalCount;
    }

    public String getPreviousPageQueryString() {
        return previousPageQueryString;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getOffset() {
        return offset;
    }

    public String getNextPageQueryString() {
        return nextPageQueryString;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setNextPageQueryString(String nextPageQueryString) {
        this.nextPageQueryString = nextPageQueryString;
    }

    public void setPreviousPageQueryString(String previousPageQueryString) {
        this.previousPageQueryString = previousPageQueryString;
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, nextPageQueryString, offset, previousPageQueryString, totalCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof CommcareMetadataInfo)) {
            return false;
        }

        CommcareMetadataInfo other = (CommcareMetadataInfo) o;

        return Objects.equals(limit, other.limit) && Objects.equals(nextPageQueryString, other.nextPageQueryString)
                && Objects.equals(offset, other.offset) && Objects.equals(previousPageQueryString, other.previousPageQueryString)
                && Objects.equals(totalCount, other.totalCount);
    }
}
