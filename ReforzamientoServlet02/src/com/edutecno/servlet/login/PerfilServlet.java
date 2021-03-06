package com.edutecno.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PerfilServlet
 */
@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("enlaces.html").include(request, response);
		Cookie ck[] = request.getCookies();
		if (ck != null) {
			String name = ck[0].getValue();
			if (!name.equals("") || name != null) {
				out.print("<b>Bienvenido a su perfil</b>");
				out.print("<br>Hola, " + name);
			}
		} else {
			out.print("Favor loguearse");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

}
