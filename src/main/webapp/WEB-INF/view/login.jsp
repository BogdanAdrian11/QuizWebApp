<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>login</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="/resources/style.css"
	title="style" />
</head>
<body>
	<div id="main">
		<div id="header">
			<div id="logo">
				<div id="logo_text">
					<!-- class="logo_colour", allows you to change the colour of the text -->
					<h1>
						<a href="/index">quiz<span class="logo_colour">webapp</span></a>
					</h1>
					<h2>simple quizzes and tests</h2>
				</div>
			</div>
			<div id="menubar">
				<ul id="menu">
					<!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
					<li><a href="/index">Home</a></li>
					<li class="selected"><a href="/login">Login</a></li>
					<li><a href="/quizzes">Quizzes</a></li>
					<li><a href="/another_page.html">Another Page</a></li>
					<li><a href="/contact">Contact Us</a></li>
				</ul>
			</div>
		</div>
		<div id="site_content">
			<div id="content">
				<p>
					<font color="red">${errorMessage}</font>
				</p>
				<form action="#" method="POST">
					Name : <input name="name" type="text" /> 
					Password : <input name="password" type="password" /> 
					<input type="submit" />
				</form>
			</div>
		</div>
		<div id="content_footer"></div>
		<div id="footer"></div>
	</div>
</body>
</html>