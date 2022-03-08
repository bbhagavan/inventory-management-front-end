<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>hello</title>
<style type="text/css">
	body{
		text-align: center;
	}
	form{
		width: 250px;
		margin: auto;
	}
	form > div {
		display: flex;
		justify-content: space-between;
		margin: 0 0 10px; 
	}	
</style>
</head>
<body>
	<h2>Registration Form</h2>
	<form method="post" action="<%= request.getContextPath() %>/addemployee">
		<div>
			<label>Emp. Id : </label>
			<input type="text" name="id" placeholder="Enter your employee Id"/>
		</div>
		
		<div>
			<label>Name : </label>
			<input type="text" name="name" placeholder="Enter your name"/>
		</div>
		
		<div>
			<label>Gender : </label>
			<label><input type="radio" name="gender" value="Male"/>Male</label>
			<label><input type="radio" name="gender" value="Female" />Female</label>	
		</div>
		
		<div>
			<label>Date Of Birth : </label>
			<input type="date" name="dob"/><br>
		</div>
		
		<input type="submit"/>
	</form>
</body>
</html>