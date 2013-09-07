Salesforce Force.com Canvas SDK
============================

### Version

Master now points to version v29.0 (Winter '14), Note: Version 27.0 (Spring '13) required a mandatory upgrade and some small coding changes, please see the [Spring '13 release notes](https://na1.salesforce.com/help/doc/en/salesforce_spring13_release_notes.pdf) and the examples). Use these commands if you still need a previous release (specify the version you need): 
	
	// Clone the entire repository
	git clone git@github.com:forcedotcom/SalesforceCanvasFrameworkSDK.git
	
	// List the Tags
	git tag
	
	// Check out the previous version
	git checkout v26.0

###Introduction

Force.com Canvas is a mechanism for consuming third-party applications within Salesforce. Its goal is to connect applications at a UI level instead of just an API level. The purpose of this GitHub repository is to provide third-party applications with a Java/JavaScript SDK and examples so you can easily integrate canvas-style applications into Salesforce, while developing in the technology and platform of your choice. 

The best place to get started building canvas applications is the [online developer's guide](http://www.salesforce.com/us/developer/docs/platform_connect/index.htm).

Currently, we provide Java examples in this repository, but you can develop in whatever language you prefer. Most of the integration with Salesforce is through JavaScript and REST. You can also run and test your application locally from your own host, or from [Heroku](http://www.heroku.com/).


### Examples

This SDK contains some basic Java examples. We recommend you explore the [Heroku Quick Start](http://www.salesforce.com/us/developer/docs/platform_connect/index_Left.htm#CSHID=quick_start_simple_create_app.htm|StartTopic=Content%2Fquick_start_simple_create_app.htm|SkinName=webhelp), for additional examples in Java and Ruby.

For other examples and resources, check out [DeveloperForce.com](http://wiki.developerforce.com/page/Force.com_Canvas)

### Documentation
The Force.com Canvas Winter '14 (v.29.0) documentation:
  - [Release Notes](https://na1.salesforce.com/help/doc/en/salesforce_winter14_release_notes.pdf)
  - [Force.com Canvas Developer's Guide](http://www.salesforce.com/us/developer/docs/platform_connect/canvas_framework.pdf)

### Prerequisites

Below are some useful commands and links for your convenience. Before you use them, you'll need to make sure you have the necessary software installed on your computer [here](http://www.salesforce.com/us/developer/docs/platform_connect/index_Left.htm#CSHID=quick_start_prereqs.htm|StartTopic=Content%2Fquick_start_prereqs.htm|SkinName=webhelp).

### How to clone the SDK repository

	git clone git@github.com:forcedotcom/SalesforceCanvasFrameworkSDK.git
	git submodule init
	git submodule update

### How to build canvas locally

If you prefer, you can build and test your application locally before you push to Heroku or any other server. If you decide to test locally, you'll also need to generate a local keystore so you can do SSL.

    mvn package
    
### First time keystore generation 
This is only needed to support SSL (https) when running locally. Heroku uses [piggyback SSL](https://devcenter.heroku.com/articles/ssl) so it's not needed there.

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


### How to run canvas locally

If you're running and testing locally, this will start your Java Web server.

    sh target/bin/webapp

### Canvas URL


    If you're running locally 
    https://localhost:8443/examples/hello-world.jsp
    
    Or if you're running on Heroku
    https://<your-heroku-app>.herokuapp.com/examples/hello-world.jsp

### Canvas callback URLs

    If you're running locally
    https://localhost:8443/sdk/callback.html
    
    Or if you're running on Heroku
    https://<your-heroku-app>.herokuapp.com/sdk/callback.html

### How to push new changes to Heroku

To commit your changes into your local git repository and push those changes to Heroku, use these commands. Note that your repository name may be diffferent than 'heroku', use git remote -v to confirm.

      git add -A
      git commit -m "My change comments"
      git push heroku master

### How to get Heroku logs

To access your logs on Heroku, use the following command. For more information on Heroku logs click [here](https://devcenter.heroku.com/articles/logging).

      heroku logs --tail

### Versions
- 28.0 (Summer '13)
- 27.0 (Spring '13 - pilot)
- 26.0 (Winter '12 - pilot)
         

