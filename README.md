Salesforce Canvas Framework SDK.
============================

####Note
The Canvas Framework feature is currently available through a pilot program. For information on enabling it for your organization, contact salesforce.com. Any unreleased services or features referenced in this or other press releases or public statements are not currently available and may not be delivered on time or at all. Customers who purchase our services should make their purchase decisions based upon features that are currently available. More information about our safe habor statement can be found on our [web site](http://www.salesforce.com/company/investor/safe_harbor.jsp) 

###Introduction

Canvas Framework is a mechanism for consuming third party applications within Salesforce. It's goal is to connect applications at a UI level instead of just an API level. The purpose of this GitHub repository is to provide third party applications with a Java/JavaScript SDK and examples so they can easily integrate canvas style applications into Salesforce, while developing in the technology and platform of their choice. 

The best place to get started with building canvas applications is the
[online developer's guide](http://www.salesforce.com/us/developer/docs/platform_connect/index.htm). [(pre-release here)](http://www.salesforce.com/us/developer/docs/platform_connectpre/index.htm).

While we currently provide examples in Java and Ruby, you can develop in whatever language you prefer. Most of the integration with Salesforce is through JavaScript and REST. You can also run and test your application locally, from your own host, or from [Heroku](http://www.heroku.com/).


### Examples

While this SDK contains some very basic java examples, it doesn't contain all the examples. We recommend you explore the [Heroku Quick Start](http://www.salesforce.com/us/developer/docs/platform_connectpre/index_Left.htm#CSHID=quick_start_simple_create_app.htm|StartTopic=Content%2Fquick_start_simple_create_app.htm|SkinName=webhelp), for additional examples in Java and other languages.

For other Force.com examples and resource, check out [Force.com](http://Developer.force.com/)

### Pre Requisites

Below are some useful commands and links for your convinience, but before you use them you will need to make sure you have the following software installed on your computer. You can check that [here](http://www.salesforce.com/us/developer/docs/platform_connectpre/index_Left.htm#CSHID=quick_start_prereqs.htm|StartTopic=Content%2Fquick_start_prereqs.htm|SkinName=webhelp).

### How to Clone the SDK Repository

	git clone git@github.com:forcedotcom/SalesforceCanvasFrameworkSDK.git

### How to Build Canvas locally

If you prefer, you can build and test your application locally before you push to Heroku or any other server. If you do decide to test locally you will also need to generate a local keystore so you do SSL.

    mvn package
    
### First time keystore generation 
Only needed if running locally to support SSL (https). Hekoku uses [piggyback SSL](https://devcenter.heroku.com/articles/ssl) so it is not needed there.

      > keytool -keystore keystore -alias jetty -genkey -keyalg RSA
      Enter keystore password: 123456
      Re-enter new password: 123456
      What is your first and last name?
        [Unknown]:  John Doe
      What is the name of your organizational unit?
        [Unknown]:  myorgunit
      What is the name of your organization?
        [Unknown]:  myorg
      What is the name of your City or Locality?
        [Unknown]:  San Fancisco
      What is the name of your State or Province?
        [Unknown]:  CA
      What is the two-letter country code for this unit?
        [Unknown]:  us
      Is CN=salesforce.com, OU=platform, O=chimera, L=San Fancisco, ST=CA, C=us correct?
        [no]:  yes

      Enter key password for <jetty>
	(RETURN if same as keystore password):  
      Re-enter new password: 


### How to Run Canvas locally

Again, if running and testing locally, this will start your java web server.

    sh target/bin/webapp

### Canvas URL


    If you are running locally 
    https://localhost:8443/examples/hello-world.jsp
    
    Or if you are running on Heroku
    https://<your-heroku-app>.herokuapp.com/examples/hello-world.jsp

### Canvas Callback URLs

    If you are running locally
    https://localhost:8443/sdk/callback.html
    
    Or if you are running on Heroku
    https://<your-heroku-app>.herokuapp.com/sdk/callback.html

### How to push new changes to heroku

To commit your changes into your local git repository and push those changes to Heroku, you can do the following. (Note: Your repository name may be diffferent than 'heroku', use git remote -v to confirm)

      git add -A
      git commit -m "My change comments"
      git push heroku master

### How to get Heroku logs

To access your logs on Heroku you can perform the following. For more information on Heroku logs click [here](https://devcenter.heroku.com/articles/logging)

      heroku logs --tail



