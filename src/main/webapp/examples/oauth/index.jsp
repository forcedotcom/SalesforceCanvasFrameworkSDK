<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>

    <title>Hello OAuth Canvas Example</title>

    <link rel="stylesheet" type="text/css" href="/sdk/css/connect.css" />

    <!-- Include all the canvas JS dependencies in one file -->
    <script type="text/javascript" src="/sdk/js/canvas-all.js"></script>

    <script>
        function loginHandler(e) {
            var uri;
            if (!Sfdc.canvas.oauth.loggedin()) {
                uri = Sfdc.canvas.oauth.loginUrl();
                Sfdc.canvas.oauth.login({
                    uri: uri,
                    params: {
                        response_type: "token",
                        client_id: "<%= System.getenv("CANVAS_CONSUMER_SECRET") %>",
                        redirect_uri: encodeURIComponent("https://localhost:8443/sdk/callback.html")
                    }
                });
            } else {
                Sfdc.canvas.oauth.logout();
                login.innerHTML = "Login";
                Sfdc.canvas.byId("oauth").innerHTML = "";
            }
            return false;
        }
        
        // Bootstrap the page once the DOM is ready.
        Sfdc.canvas(function() {
            // On Ready...
            var login = Sfdc.canvas.byId("login"),
                loggedIn = Sfdc.canvas.oauth.loggedin(),
                token = Sfdc.canvas.oauth.token();
            login.innerHTML = (loggedIn) ? "Logout" : "Login";
            
            if (loggedIn) {
                // Only displaying part of the OAuth token for better formatting.
                Sfdc.canvas.byId("oauth").innerHTML = Sfdc.canvas.oauth.token().substring(1,40) + "...";
            }
            login.onclick = loginHandler;
        });
    </script>
</head>
<body>
    <h1 id="header">Force.com Canvas OAuth App</h1>
    <div>
        access_token = <span id="oauth"></span>
    </div>
    <div>
        <a id="login" href="#">Login</a><br />
    </div>
</body>
</html>
