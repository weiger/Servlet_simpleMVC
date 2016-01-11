<%@ page contentType="text/html" %>
<%@ page import="java.util.*" %>

<html>
	<head> 
		<title> MVC Demo </title>
		
		<script type="text/javascript">
			function validate(f){
				if(!(/^\w{1,15}$/.test(f.userid.value))){
					alert("id should have 5-15 long!");
					f.userid.focus();
					f.userid.select();
					return false;
				}
			
				if(!(/^\w{1,15}$/.test(f.userpassword.value))){
					alert("5-15 long!");
					f.userpassword.focus();
					f.userpassword.select();
					return false;
				}
				return true;
			}
		</script>
	</head>
	
	<body>
		<center>
			<h2><font color="red"> Login </font></h2>
			
			<%
				List<String> info = (List<String>) request.getAttribute("info");
				if(info != null){
					Iterator<String> it = info.iterator();
					while(it.hasNext()){
			%>
						<h4><%= it.next() %></h4>
			<%		
					}
				}
			%>
			
			<form action="LoginServlet" method="post" onSubmit="return validate(this)" >
				User Id: <input type="text" name="userid"><br>
				Password:<input type="password" name="userpassword"><br>
				<input type="submit" value="Submit">
				<input type="reset" value="Reset">
			</form>
		</center>
	</body>
</html>