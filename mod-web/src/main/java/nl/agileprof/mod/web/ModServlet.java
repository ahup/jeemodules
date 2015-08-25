package nl.agileprof.mod.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.agileprof.core.TestEJBInterface;

@WebServlet(urlPatterns = "/test")
public class ModServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private TestEJBInterface testEJBInterface;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print(testEJBInterface.test());
	}

}
