<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>

		<form action="addEmployee" method="post">
			<label>Enter Id<input type="text" name="id"/></label><br/>
			<label>Enter Name<input type="text" name="name"/></label><br/>
			<label>Enter Gender</label>
				<input type="radio" name="gender" value="Male"/>male
				<input type="radio" name="gender" value="Female"/>female<br/>
			<label>Enter Id<input type="date" name="dob"/></label><br/>
			<input type="submit"/>
		</form>
		<br>
		<form action="getEmployees">
			<label>Enter Id<input type="text" name="id"/></label><br/>
			<input type="submit"/>
		</form>
	</body>
</html>