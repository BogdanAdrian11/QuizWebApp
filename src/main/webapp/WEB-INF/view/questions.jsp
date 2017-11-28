<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>questions</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="/style.css"
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
					<li><a href="/login">Login</a></li>
					<li><a href="/quizzes">Quizzes</a></li>
					<li><a href="/admin">Admin</a></li>
					<li><a href="/contact">Contact Us</a></li>
				</ul>
			</div>
		</div>
		<div id="site_content">
			<div id="content">
				<h1>${quiz.name}</h1>
				<form:form method="POST" modelAttribute="quiz" action="#">
					<c:forEach items="${quiz.questions}" var="question">
						<td>${question.content}<br> <br></td>
						<c:forEach items="${question.choices}" var="choice">
							<c:choose>
								<c:when test="${question.type == 'MultipleChoice'}">
									<input type="checkbox" name="result" value="${choice.id}" /> ${choice.content}<br>
								</c:when>
								<c:when test="${question.type == 'SingleChoice'}">
									<input type="radio" name="result" value="${choice.id}" /> ${choice.content}<br>
								</c:when>
							</c:choose>
						</c:forEach>
						<br>
					</c:forEach>
					<input type="submit" value="Submit" />
				</form:form>
			</div>
		</div>
		<div id="content_footer"></div>
		<div id="footer"></div>
	</div>
</body>
</html>