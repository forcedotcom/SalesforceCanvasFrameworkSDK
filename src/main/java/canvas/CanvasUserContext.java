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

import java.util.Locale;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Describes contextual information about the current user.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class CanvasUserContext{

    private String userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String fullName;
    private Locale locale;
    private Locale language;
    private String timeZone;
    private String profileId;
    private String roleId;
    private String userType;
    private String currencyISOCode;
    private boolean accessibilityMode;
    private String profilePhotoUrl;
    private String profileThumbnailUrl;

    /**
     * The Salesforce user identifier.
     */
    @JsonProperty("userId")
    public String getUserId(){
        return this.userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    /**
     * The Salesforce username.
     */
    @JsonProperty("userName")
    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String username){
        this.userName = username;
    }

    /**
     * User's first name.
     */
    @JsonProperty("firstName")
    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * User's last name.
     */
    @JsonProperty("lastName")
    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Indicates whether user interface modifications for the visually impaired are on (true) or off (false).
     */
    @JsonProperty("accessibilityModeEnabled")
    public boolean isAccessibilityMode(){
        return this.accessibilityMode;
    }

    public void setAccessibilityMode(boolean accessibilityMode){
        this.accessibilityMode = accessibilityMode;
    }

    /**
     * The user's email address.
     */
    @JsonProperty("email")
    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    /**
     * User's full name.
     */
    @JsonProperty("fullName")
    public String getFullName(){
        return this.fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    /**
     * User\u2019s locale, which controls the formatting of dates and choice of symbols for currency.
     */
    @JsonProperty("locale")
    public Locale getLocale(){
        return this.locale;
    }

    public void setLocale(Locale locale){
        this.locale = locale;
    }

    /**
     * User's language, which controls the language for labels displayed in an application.
     */
    @JsonProperty("language")
    public Locale getLanguage(){
        return this.language;
    }

    public void setLanguage(Locale language){
        this.language = language;
    }

    /**
     * The user's configured timezone.
     */
    @JsonProperty("timeZone")
    public String getTimeZone(){
        return this.timeZone;
    }

    public void setTimeZone(String timezone){
        this.timeZone = timezone;
    }

    /**
     * Information about the user's profile identifier.
     */
    @JsonProperty("profileId")
    public String getProfileId(){
        return this.profileId;
    }

    public void setProfileId(String profileId){
        this.profileId = profileId;
    }

    /**
     * Role ID of the role currently assigned to the user.
     */
    @JsonProperty("roleId")
    public String getRoleId(){
        return this.roleId;
    }

    public void setRoleId(String roleId){
        this.roleId = roleId;
    }

    /**
     * Current user's license type in label form.
     */
    public String getUserType(){
        return this.userType;
    }

    public void setUserType(String userType){
        this.userType = userType;
    }

    /**
     * Current user's default currency ISO code (applies only if multi-currency is enabled for the org).
     */
    public String getCurrencyISOCode(){
        return this.currencyISOCode;
    }

    public void setCurrencyISOCode(String currencyISOCode){
        this.currencyISOCode = currencyISOCode;
    }

    /**
     * Returns the full profile photo of the current user.
     */
    public String getProfilePhotoUrl(){
        return this.profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl){
        this.profilePhotoUrl = profilePhotoUrl;
    }

    /**
     * Returns the thumbnail photo of the current user.
     */
    public String getProfileThumbnailUrl(){
        return this.profileThumbnailUrl;
    }

    public void setProfileThumbnailUrl(String profileThumbnailUrl){
        this.profileThumbnailUrl = profileThumbnailUrl;
    }

    @Override
    public String toString()
    {
        return userId+ ","+
               userName+ ","+
               firstName+","+
               lastName+ ","+
               email+ ","+
               fullName+ ","+
               locale+ ","+
               language+ ","+
               timeZone+ ","+
               profileId+ ","+
               roleId+ ","+
               userType+ ","+
               currencyISOCode+ ","+
               accessibilityMode+ ","+
               profilePhotoUrl+","+
               profileThumbnailUrl;

    }
}
