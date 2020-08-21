<html>
   <body>
   
      <form action = "/Router/book/" method = "POST">
         ID: <input type = "text" name = "id" />
         <input type = "submit" onclick="return getID();" />
      </form>
      
	  <a href="/Router/about">about</a>
	  <script>
		function getID()
		{
			alert("Submit button clicked!");

		
		}
      </script>
	  
   </body>
</html>