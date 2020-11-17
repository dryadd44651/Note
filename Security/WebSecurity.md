### Background
web->Stateless->use session(cookie)->Store State->cannot forge authenticator and Same Origin Policy for Security

Webpage resources maintained by the browser
> Cookies
> Document Object Model (DOM) objects

### Same Origin Policy
Same Origin Policy: only same origin can get resources
Origin = domain name + protocol + port

Problems: not enforced in older browsers, same origin different pages can access, can be bypassed XSS attacks, can't share resource

Cross Site Scripting (XSS): using inputs to execute scripts and get cookies, DOM.

### Cross site request forgery (CSRF or XSRF)
XSRF: inject the code to webpage with session
ex: 
1. User logs in to  bank.com.    Forgets to sign off.
2. Session cookie remains in browser state
3. Then user visits another site containing:
```
  <form  name=F  action=http://bank.com/BillPay.php>
  <input  name=recipient   value=badguy> …
  <script> document.F.submit(); </script> 
```
4. Browser sends user auth cookie with request
5. Transaction will be fulfilled

Prevention:
Server side:
> use cookie(token) + hidden fields to authenticate
> hidden fields values need to be unpredictable and user-specific
> check the request referer(from input is not illigal)
User side:
> logging off one site before using others

### SQL Injection
SELECT * FROM Users WHERE UserId = 105 OR 1=1;

SELECT * FROM Users WHERE UserId = 105; DROP TABLE Suppliers;

### Information Leakage
weekness of web(not a attack)

Developer comments left in page responses:
```
        <TABLE border="0" cellPadding="0" cellSpacing="0" height="59" width="591">
        <TBODY>
           <TR>
                <!--If the image files fail to load, check/restart 192.168.0.110 -->
                <TD bgColor="#ffffff" colSpan="5" height="17" width="587"> </TD>
           </TR>
```
Improper application or server configurations:
> ex: show the error statment to user-> got prior knowledge->inject the code

Differences in page response behaviors:
> ex: show message wrong password or not such account -> attacker can try and find the valid one.
