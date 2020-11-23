// your js code goes here...
var span1=document.createElement("span");
span1.setAttribute("id","span1");
span1.innerHTML="The username field must contain only alphanumeric characters";
span1.style.display="none";

var username = document.getElementById("username");
username.parentNode.insertBefore(span1, username.nextSibling);


//focus on input
username.onfocus=function(){
	span1.innerHTML="The username field must contain only alphanumeric characters"
	span1.style.display="inline"
}
//doesn't focus on input
username.onblur=function(){
	var letterNumber = /^[0-9a-zA-Z]+$/;
	if (username.value==null||username.value==""){span1.style.display="none";}
	else{
		if (username.value.match(letterNumber)){
			span1.className="ok";
			span1.innerHTML="OK";
			span1.style.display="inline";
		}
		else{
			span1.className="error";
			span1.innerHTML="Error";
			span1.style.display="inline";
		}
	}
}

var span2=document.createElement("span");
span2.setAttribute("id","span2");
span2.innerHTML="The password field should be at least six characters long";
span2.style.display="none";

var password = document.getElementById("password");
password.parentNode.insertBefore(span2, password.nextSibling);



password.onfocus=function(){
	span2.innerHTML="The password field should be at least six characters long";
	span2.className="info";
	span2.style.display="inline";
}

password.onblur=function(){
	if (password.value==null||password.value==""){span2.style.display="none";}
	else{
		if (password.value.length>6){
			span2.innerHTML="OK";
			span2.className="ok";
			span2.style.display="inline";
		}
		else{
			span2.innerHTML="Error";
			span2.className="error";
			span2.style.display="inline";
		}
	}
}

var span3=document.createElement("span");
span3.setAttribute("id","span3");
span3.innerHTML="The email field should be a valid email address (abc@def.xyz)";
span3.style.display="none";

var email = document.getElementById("email");
email.parentNode.insertBefore(span3, email.nextSibling);



email.onfocus=function(){
	span3.innerHTML="The email field should be a valid email address (abc@def.xyz)";
	span3.className="info";
	span3.style.display="inline";
}

email.onblur=function(){
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (email.value==null||email.value==""){span3.style.display="none";}
	else{
		if (email.value.match(mailformat)){
			span3.innerHTML="OK";
			span3.className="ok";
			span3.style.display="inline";
		}
		else{
			span3.innerHTML="Error";
			span3.className="error";
			span3.style.display="inline";
		}
	}
}