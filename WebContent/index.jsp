<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="edu.studyup.map.Lookup" %>
<%@ page import="edu.studyup.entity.Location" %>
<html>
<head>
	<meta name="viewport" content="initial-scale=1, maximum-scale=1">
	<link rel='stylesheet' href='webjars/bootstrap/4.2.1/css/bootstrap.min.css'>
	<link rel='stylesheet' href='CSS/Main.css'>
	<title>StudyUp!</title>
</head>
<body>
	<!-- Navbar CODE -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light static-top">
		<div class="container">
			<a class="navbar-brand" href="#">
				<img id="logo" src="Images/Logo.png" alt="StudyUp!">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active">
						<a class="nav-link" href="#Home">Home
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#About">About</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
		<section id="Home">
			<h1 class="mt-4">Meet up to up your grades!</h1>
			<p>Alas, this page does nearly nothing :( Let's make it beautiful this quarter.</p>
			<div id="map" class="map"></div>
			<form action="index.jsp" method="GET">
				<div class="form-group">
					<input name="place" id="place-input" class="place form-control"
						placeholder="Search for a place"
						value="<%=request.getParameter("place") == null ? "" : request.getParameter("place")%>">
					<button type="submit" id="place-submit" class="place btn btn-dark">Submit</button>
				</div>
			</form>
		</section>
		<br/>
		<section id="About">
			<h1 class="mt-4">About</h1>
			<p>This simple web-app will be our basis for teaching various programming tools over the course of this quarter.
			During these ten weeks, we will teach you how it works and extend and improve it together until it runs in the cloud
			and communicates with other web-apps through shared data-storage.
			Your Github fork will be used to introduce you to Git and Github, modern code review, continuous integration and more.
			</p>
			<p>If you have time to spare, you are fully welcome to improve this page with your own CSS and JS, or even fix that awful logo :)
			There is a very small chance that changes we push on the main branch (to move the project forward) will conflict with your edits,
			so if you want to do this, please add your changes to separate JS/CSS files.
			</p>
		</section>
	</div>

	<!-- JS CODE -->
	<script type="text/javascript" src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/4.2.1/js/bootstrap.bundle.js"></script>
	<script src="https://cdn.rawgit.com/openlayers/openlayers.github.io/master/en/v5.3.0/build/ol.js"></script>
	<script src="JS/Main.js"></script>
	
	<%
	String place = request.getParameter("place");
	if (place != null && !place.isEmpty()) {
       	Location loc = Lookup.lookupPlace(place);
       	if (loc != null) {
        	double lat = loc.lat;
        	double lon = loc.lon;
        	double[] bounds = loc.bounds; %>
        	<script>gotoLoc(<%=lat%>, <%=lon%>, [<%=bounds[0]%>, <%=bounds[1]%>, <%=bounds[2]%>, <%=bounds[3]%>]);</script>
       	<%}
       }%>
</body>
</html>
