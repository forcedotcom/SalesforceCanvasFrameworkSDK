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
/**
*@namespace Sfdc.canvas.cookies
*@name Sfdc.canvas.cookies
*/
(function ($$) {

    "use strict";

    var module =  (function() {

        function isSecure()
        {
            return window.location.protocol === 'https:';
        }

        /**
       * @name Sfdc.canvas.cookies#set
       * @function
       * @description Create a cookie
       * @param {String} name Cookie name
       * @param {String} value Cookie value
       * @param {Integer} [days] Number of days for the cookie to remain active.
                If not provided, the cookie never expires
       */
       function set(name, value, days) {
           var expires = "", date;
           if (days) {
               date = new Date();
               date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
               expires = "; expires=" + date.toGMTString();
           }
           else {
               expires = "";
           }
           document.cookie = name + "=" + value + expires + "; path=/" +  ((isSecure() === true) ? "; secure" : "");
       }
       
       /**
       * @name Sfdc.canvas.cookies#get
       * @function
       * @description Get the cookie with the specified name
       * @param {String} name The name of the cookie to retrieve
       * @returns The value of the cookie if the name is found, otherwise null
       */
       function get(name) {
           var nameEQ, ca, c, i;

           if ($$.isUndefined(name)) {
               return document.cookie.split(';');
           }

           nameEQ = name + "=";
           ca = document.cookie.split(';');
           for (i = 0; i < ca.length; i += 1) {
               c = ca[i];
               while (c.charAt(0) === ' ') {c = c.substring(1, c.length);}
               if (c.indexOf(nameEQ) === 0) {
                   return c.substring(nameEQ.length, c.length);
               }
           }
           return null;
       }
       
       /**
       * @name Sfdc.canvas.cookies#remove
       * @function
       * @description Remove the specified cookie by setting the expiry date to one day ago
       * @param {String} name The name of the cookie to remove.
       */
       function remove(name) {
           set(name, "", -1);
       }

       return {
            set : set,
            get : get,
            remove : remove
        };
    }());


    $$.module('Sfdc.canvas.cookies', module);

}(Sfdc.canvas));