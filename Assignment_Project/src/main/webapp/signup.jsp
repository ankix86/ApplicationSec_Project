<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Sign-up Form</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<img class="bg-img" src="https://wallpapercave.com/wp/wp4507701.jpg" alt="Background Image" />

<div class="form-container">
    <h2>User Sign-up Form</h2>
   
	<form action="<%=request.getContextPath()%>/SignupServlet"
			method="post">            
			<label for="userName" class="required-label">User Name</label>
            <input type="text" id="userName" name="userName"
                maxlength="10"
                pattern="[A-Za-z]{1,10}"
                title="Only alphabets, max 10 characters"
                required />

            <label for="userEmail" class="required-label">User Email</label>
            <input type="email" id="userEmail" name="userEmail"
                required />

            <label for="password" class="required-label">Password</label>
            <input type="password" id="password" name="password"
                minlength="7" maxlength="10"
                pattern="[A-Za-z0-9$%&*]{7,10}"
                title="7-10 characters. Only letters, numbers, $, %, &, *"
                required />

            <label for="confirmPassword" class="required-label">Confirm Password</label>
            <input type="password" id="confirmPassword" name="confirmPassword"
                minlength="7" maxlength="10"
                pattern="[A-Za-z0-9$%&*]{7,10}"
                title="Please re-enter your password"
                required />

            <label for="preferredName">Preferred Name</label>
            <input type="text" id="preferredName" name="preferredName"
                maxlength="20"
                title="At most 20 characters">

            <label for="name" class="required-label">Name</label>
            <input type="text" id="name" name="name"
                maxlength="20"
                title="At most 20 characters"
                required />

            <input type="submit" value="Sign Up" />
        </form>
	</div>
</body>
</html>