<html>
<body>
<script >
 var d = new Date();
 var entrytime = d.getMinutes();
 console.log(entrytime);
</script>
<div class="container">
	
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="name" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="pwd" required>

    <button type="submit" onclick="myfunction()">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
   
  </div>
  
  <script>
  function myfunction()
  {
	  var date=new Date();
	  var currTime=data.getMinutes();
	  
	 console.log(currTime);
	  if(currTime - entrytime >=5)
		  {
		     return "form";
		  }
  }
  </script>
</body>
</html>