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
 * Environmental information about the canvas application.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class CanvasEnvironmentContext {
    private String locationUrl;
    private String uiTheme;
    private Dimensions dimensions;

    /**
     * Returns the url of the current location.
     */
    @JsonProperty("locationUrl")
    public String getLocationUrl() {
        return this.locationUrl;
    }

    public void setLocationUrl(String referrerUrl) {
        this.locationUrl = referrerUrl;
    }

    /**
     * Returns the value Theme2 if the user is using the newer user interface theme of the online application, labeled
     * \u201cSalesforce.\u201d Returns Theme1 if the user is using the older user interface theme, labeled
     * \u201cSalesforce Classic.\u201d
     * 
     * @see common.html.styles.UiSkin
     */
    @JsonProperty("uiTheme")
    public String getUiTheme() {
        return this.uiTheme;
    }

    public void setUiTheme(String uiTheme) {
        this.uiTheme = uiTheme;
    }

    @JsonProperty("dimensions")
    public Dimensions getDimensions() {
        return this.dimensions;
    }

    @JsonProperty("dimensions")
    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString()
    {
        return locationUrl + ", " +
               uiTheme + "," +
               dimensions.toString();
    }
    
    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class Dimensions{
        /**
         * The width of the iframe
         */
        private String width;
        /**
         * The height of the iframe.
         */
        private String height;
        
        @JsonProperty("width")
        public String getWidth() {
            return this.width;
        }
        @JsonProperty("width")
        public void setWidth(String width) {
            this.width = width;
        }

        @JsonProperty("height")
        public String getHeight() {
            return this.height;
        }
        @JsonProperty("height")
        public void setHeight(String height) {
            this.height = height;
        }
        
        @Override
        public String toString(){
            return "(w:" + width + ",h:" + height + ")";
        }
    }
    

}
