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

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CanvasEnvironmentContext {

    private String locationUrl;
    private String uiTheme;
    private Dimensions dimensions;
    private SystemVersion version;
    private Record record;
    private Map<String,Object> parameters;

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

    @JsonProperty("version")
    public SystemVersion getSystemVersion() {
        return this.version;
    }

    @JsonProperty("version")
    public void setSystemVersion(SystemVersion systemVersion) {
        this.version = systemVersion;
    }
    
    @JsonProperty("record")
    public Record getRecord() {
        if (record == null) {
            record = new Record();
        }
        return record;
    }

    @JsonProperty("record")
    public void setRecord(Record r) {
        record = r;
    }

    @JsonProperty("parameters")
    public Map<String, Object> getParameters() {
        if (null == this.parameters){
            this.parameters = new HashMap<String, Object>();
        }
        return this.parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString()
    {
        return locationUrl + ", " +
               uiTheme + "," +
               dimensions.toString() + "," +
               version.toString();
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
            return String.format("(w:%s,h:%s)",width,height);
        }
    }

    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class SystemVersion{

        private String api;
        private String season;

        // Needs default ctor for Jackson to construct.
        public SystemVersion(){
        }

        @JsonProperty("api")
        public String getApiVersion() {
            return this.api;
        }

        @JsonProperty("api")
        public void setApiVersion(String apiVersion) {
            this.api = apiVersion;
        }

        @JsonProperty("season")
        public String getSeason() {
            return this.season;
        }

        @JsonProperty("season")
        public void setSeason(String season) {
            this.season = season;
        }

        @Override
        public String toString(){
            return String.format("%s - %s",api,season);
        }

    }

    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class Record {

        private RecordAttributes attributes;
        private Map<String, String> fields = new HashMap<>();

        @JsonProperty("attributes")
        public RecordAttributes getAttributes() {
            return attributes;
        }

        @JsonProperty("attributes")
        public void setAttributes(RecordAttributes attributes) {
            this.attributes = attributes;
        }

        @JsonAnyGetter
        public Map<String,String> getFields() {
            return fields;
        }

        @JsonAnySetter
        public void setField(String key, String value) {
            fields.put(key, value);
        }
    }

    @JsonIgnoreProperties(ignoreUnknown=true)
    public static class RecordAttributes {

        private String type;
        private String url;

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String t) {
            type = t;
        }

        @JsonProperty("url")
        public String getUrl() {
            return url;
        }

        @JsonProperty("url")
        public void setUrl(String u) {
            url = u;
        }
    }
}
