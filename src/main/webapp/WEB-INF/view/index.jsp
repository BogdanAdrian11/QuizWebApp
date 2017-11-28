<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>index</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="/style.css" title="style" />
</head>

<body>
	<div id="main">
		<div id="header">
			<div id="logo">
				<div id="logo_text">
					<!-- class="logo_colour", allows you to change the colour of the text -->
					<h1>
						<a href="index">quiz<span class="logo_colour">webapp</span></a>
					</h1>
					<h2>simple quizzes and tests</h2>
				</div>
			</div>
			<div id="menubar">
				<ul id="menu">
					<!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
					<li class="selected"><a href="/index">Home</a></li>
					<li><a href="/login">Login</a></li>
					<li><a href="/quizzes">Quizzes</a></li>
					<li><a href="/admin">Admin</a></li>
					<li><a href="/contact">Contact Us</a></li>
				</ul>
			</div>
		</div>
		<div id="site_content">
			<div id="content">
				<!-- insert the page content here -->
				<h1>Take a quiz</h1>
				<c:forEach items="${quizzes}" var="quiz" varStatus="myIndex">
					<c:choose>
						<c:when test="${myIndex.index%2==0}">
							<span class="left"><img src="/question.png"
								alt="example graphic" /></span>
							<br />
							<br />
							<br />
							<a href="/questions/${quiz.id}">${quiz.name}</a>
						</c:when>
						<c:otherwise>
							<span class="right"><img src="/question.png"
								alt="example graphic" /> </span>
							<br />
							<br />
							<br />
							<span class="right"> <a href="/questions/${quiz.id}">${quiz.name}</a>
							</span>
						</c:otherwise>
					</c:choose>
					<br />
					<br />
					<p>
						<br />
					</p>
				</c:forEach>
			</div>
		</div>
		<div id="content_footer"></div>
		<div id="footer"></div>
	</div>
</body>
</html>
