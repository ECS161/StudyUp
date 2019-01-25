package edu.studyup.data;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = -5273788106109654170L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boundingBox = request.getParameter("bounds");
		if (boundingBox == null || boundingBox.isEmpty()){
			return;
		}
		List<Double> bounds = Arrays.stream(boundingBox.split(",")).map(e -> Double.parseDouble(e.trim())).collect(Collectors.toList());
		response.setContentType("text/plain");
		response.getWriter().write(bounds.toString());
	}
}
