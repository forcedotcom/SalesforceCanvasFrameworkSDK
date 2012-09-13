/**
 * Copyright (c) 2011, salesforce.com, inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 *
 *    Redistributions of source code must retain the above copyright notice, this list of conditions and the
 *    following disclaimer.
 *
 *    Redistributions in binary form must reproduce the above copyright notice, this list of conditions and
 *    the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 *    Neither the name of salesforce.com, inc. nor the names of its contributors may be used to endorse or
 *    promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package canvas;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Describes all contextual information around external references, or links to external resources.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class CanvasLinkContext {
    private String enterpriseUrl;
    private String metadataUrl;
    private String partnerUrl;
    private String restUrl;
    private String sobjectUrl;
    private String searchUrl;
    private String queryUrl;
    private String recentItemsUrl;
    private String userProfileUrl;
    private String chatterFeedsUrl;
    private String chatterGroupsUrl;
    private String chatterUsersUrl;
    private String chatterFeedItemsUrl;

    /**
     * Provide the url for enterprise-wide external clients.
     */
    @JsonProperty("enterpriseUrl")
    public String getEnterpriseUrl() {
        return this.enterpriseUrl;
    }

    public void setEnterpriseUrl(String enterpriseUrl) {
        this.enterpriseUrl = enterpriseUrl;
    }

    /**
     * Provide the base url for the metadata api to access information about custom objects, apex classes, etc.
     */
    @JsonProperty("metadataUrl")
    public String getMetadataUrl() {
        return this.metadataUrl;
    }

    public void setMetadataUrl(String metadataUrl) {
        this.metadataUrl = metadataUrl;
    }

    /**
     * Access to the partner api for developing client applications for multiple organizations.
     */
    @JsonProperty("partnerUrl")
    public String getPartnerUrl() {
        return this.partnerUrl;
    }

    public void setPartnerUrl(String partnerUrl) {
        this.partnerUrl = partnerUrl;
    }

    /**
     * Access to the base url for RESTful services.
     */
    @JsonProperty("restUrl")
    public String getRestUrl() {
        return this.restUrl;
    }

    public void setRestUrl(String restUrl) {
        this.restUrl = restUrl;
    }

    /**
     * Access to custom sobject definitions.
     */
    @JsonProperty("sobjectUrl")
    public String getSobjectUrl() {
        return this.sobjectUrl;
    }

    public void setSobjectUrl(String sobjectUrl) {
        this.sobjectUrl = sobjectUrl;
    }

    /**
     * Access to search api.
     */
    @JsonProperty("searchUrl")
    public String getSearchUrl() {
        return this.searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    /**
     * Access to the SOQL query api.
     */
    @JsonProperty("queryUrl")
    public String getQueryUrl() {
        return this.queryUrl;
    }

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }

    /**
     * Access to the recent items feed.
     */
    @JsonProperty("recentItemsUrl")
    public String getRecentItemsUrl() {
        return this.recentItemsUrl;
    }

    public void setRecentItemsUrl(String recentItemsUrl) {
        this.recentItemsUrl = recentItemsUrl;
    }

    /**
     * Retrieve more information about the current user.
     */
    @JsonProperty("userUrl")
    public String getUserUrl() {
        return this.userProfileUrl;
    }

    public void setUserUrl(String userProfileUrl) {
        this.userProfileUrl = userProfileUrl;
    }

    /**
     * Access to Chatter Feeds. Note: Requires user profile permissions, otherwise this will be null.
     */
    @JsonProperty("chatterFeedsUrl")
    public String getChatterFeedsUrl() {
        return this.chatterFeedsUrl;
    }

    public void setChatterFeedsUrl(String chatterFeedsUrl) {
        this.chatterFeedsUrl = chatterFeedsUrl;
    }

    /**
     * Access to Chatter Groups. Note: Requires user profile permissions, otherwise this will be null.
     */
    @JsonProperty("chatterGroupsUrl")
    public String getChatterGroupsUrl() {
        return this.chatterGroupsUrl;
    }

    public void setChatterGroupsUrl(String chatterGroupsUrl) {
        this.chatterGroupsUrl = chatterGroupsUrl;
    }

    /**
     * Access to Chatter Users. Note: Requires user profile permissions, otherwise this will be null.
     */
    @JsonProperty("chatterUsersUrl")
    public String getChatterUsersUrl() {
        return this.chatterUsersUrl;
    }

    public void setChatterUsersUrl(String chatterUsersUrl) {
        this.chatterUsersUrl = chatterUsersUrl;
    }

    /**
     * Access to individual Chatter Feed items. Note: Requires user profile permissions, otherwise this will be null.
     */
    @JsonProperty("chatterFeedItemsUrl")
    public String getChatterFeedItemsUrl() {
        return this.chatterFeedItemsUrl;
    }

    public void setChatterFeedItemsUrl(String chatterFeedItemsUrl) {
        this.chatterFeedItemsUrl = chatterFeedItemsUrl;
    }
    
    @Override
    public String toString()
    {
        return   enterpriseUrl+ ", " +
                 metadataUrl+ ", " +
                 partnerUrl+ ", " +
                 restUrl+ ", " +
                 sobjectUrl+ ", " +
                 searchUrl+ ", " +
                 queryUrl+ ", " +
                 recentItemsUrl+ ", " +
                 userProfileUrl+ ", " +
                 chatterFeedsUrl+ ", " +
                 chatterGroupsUrl+ ", " +
                 chatterUsersUrl+ ", " +
                 chatterFeedItemsUrl;
    }

}
