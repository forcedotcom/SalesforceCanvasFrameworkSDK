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

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * The canvas request is what is sent to the client on the very first request. In this canvas
 * request is information for authenticating and context about the user, organization and environment.
 * <p>
 * This class is serialized into JSON on then signed by the signature service to prevent tampering.
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class CanvasRequest {

    private String  algorithm;
    private Integer issuedAt;
    private String  userId;
    private CanvasContext canvasContext;
    private CanvasClient client;

    /**
     * The algorithm used to sign the request. typically HMAC-SHA256
     * @see platform.connect.service.SignRequestService.ALGORITHM
     */
    @JsonProperty("algorithm")
    public String getAlgorithm() {
        return algorithm;
    }

    @JsonProperty("algorithm")
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * The unix time this request was issued at.
     */
    @JsonProperty("issuedAt")
    public Integer getIssuedAt() {
        return issuedAt;
    }

    @JsonProperty("issuedAt")
    public void setIssuedAt(Integer issuedAt) {
        this.issuedAt = issuedAt;
    }

    /**
     * The Salesforce unique id for this user.
     * @return
     */
    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Context information about the user, org and environment.
     */
    @JsonProperty("context")
    public CanvasContext getContext() {
        return canvasContext;
    }

    /**
     * Client instance information required while using the Sfdc.canvas.client JavaScript API.
     */
    @JsonProperty("context")
    public void setContext(CanvasContext canvasContext) {
        this.canvasContext = canvasContext;
    }

    /**
     * Unique information about this client (including oauth token). This information (in JSON) format needs to be
     * included on all client side SDK calls. 
     */
    @JsonProperty("client")
    public CanvasClient getClient() {
        return client;
    }

    @JsonProperty("client")
    public void setClient(CanvasClient client) {
        this.client = client;
    }
}

