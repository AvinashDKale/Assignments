function login() {
  var mail = document.getElementById("username").value;
  var pass = document.getElementById("password").value;
  

  let submitOk = true;

  if (username.length == 0) {
    alert("Invalid email");
    submitOk = false;
  }

  if (pass.length < 10 || submitOk == false) {
    alert("Invalid password");
    submitOk = false;
  }
if (submitOk == true) {
    
      window.open("adminbooks.html");
    } 
    
    
  }
