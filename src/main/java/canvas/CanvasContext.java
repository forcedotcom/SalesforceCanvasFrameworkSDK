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
 * Describes all contextual information related to canvas applications.
 * 
 * <p>
 * Some information within the context depends on what oauth scopes are allowed
 * on the canvas application. Some/all items may be null if the oauth scope is
 * not set accordingly.
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class CanvasContext {
    
    private CanvasUserContext userContext = null;
    private CanvasOrganizationContext orgContext = null;
    private CanvasLinkContext linkContext = null;
    private CanvasEnvironmentContext envContext = null;

    
    /**
     * Provides the context about the current user.
     * 
     * @return The current user context, or null if the oauth scope
     * will not allow.
     */
    @JsonProperty("user")
    public CanvasUserContext getUserContext() {
        return this.userContext;
    }    
    
    /**
     * Sets the context about the current user.
     */
    @JsonProperty("user")
    public void setUserContext(CanvasUserContext userContext)
    {
        this.userContext = userContext;
    }
    
    /**
     * Provides the context about the current organization.
     * 
     * @return The current organization context, or null if the oauth scope
     * will not allow.
     */
    @JsonProperty("organization")
    public CanvasOrganizationContext getOrganizationContext() {
        return orgContext;
    }    
    
    /**
     * Sets the context about the current organization.
     */
    @JsonProperty("organization")
    public void setOrganizationContext(CanvasOrganizationContext orgContext)
    {
        this.orgContext = orgContext;
    }
    
    /**
     * Provides the context about the current environment (page, url, etc).
     */
    @JsonProperty("environment")
    public CanvasEnvironmentContext getEnvironmentContext() {
        if (null == this.envContext){
            return new CanvasEnvironmentContext();
        }
        return envContext;
    }
    
    @JsonProperty("environment")
    public void setEnvironmentContext(CanvasEnvironmentContext envContext){
        this.envContext = envContext;
    }
    
    /**
     * Provides links to external resources within sfdc.
     */
    @JsonProperty("links")
    public CanvasLinkContext getLinkContext() {
        return linkContext;
    }
    
    /**
     * Sets the link context for this request.
     * @param linkContext
     */
    @JsonProperty("links")
    public void setLinkContext(CanvasLinkContext linkContext)
    {
        this.linkContext = linkContext;
    }
    
    @Override
    public String toString()
    {
        return String.format("Canvas Context:\n\t" + 
                             "User Context:\n\t\t%s\n\t"+
                             "Org Context:\n\t\t%s\n\t"+
                             "Environment Context:\n\t\t%s\n\t"+
                             "Link Context:\n\t\t%s\n", 
                             null != userContext?userContext.toString():"null",
                             null != orgContext?orgContext.toString():"null",
                             null != envContext?envContext.toString():"null",
                             null != linkContext?linkContext.toString():"null");
    }
}
