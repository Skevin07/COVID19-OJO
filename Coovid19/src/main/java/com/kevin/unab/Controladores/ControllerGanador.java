package com.kevin.unab.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kevin.unab.DAO.ClsBeneficiario;
import com.kevin.unab.Entidades.Persona;
import com.kevin.unab.Negocio.ClsConsultar;

/**
 * Servlet implementation class ControllerGanador
 */
public class ControllerGanador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerGanador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		HttpSession seccion = request.getSession(true); 
		String esBeneficiario = request.getParameter("soybeneficiario"); 
		String noesBeneficiario = request.getParameter("nosoybeneficiario");

		String fully = "";

		if (esBeneficiario != null || noesBeneficiario != null) {
			response.sendRedirect("index.jsp");
			seccion.invalidate();
		} else {

			String dui = request.getParameter("dui");
			Persona person = new Persona();
			person.setDUI(dui);
			ClsConsultar consultaDUI = new ClsConsultar();
			ClsBeneficiario clsBeneficiario = new ClsBeneficiario();

			fully = clsBeneficiario.MostrarBeneficiario(person);

			int esbenefi = consultaDUI.SoyBeneficiario(person);

			if (esbenefi == 0) {
				response.sendRedirect("NoSoyBeneficiario.jsp");
				seccion.setAttribute("nobeneficiario", esbenefi);

			} else if (esbenefi == 1) {

				response.sendRedirect("SoyBeneficiario.jsp");
				seccion.setAttribute("beneficiario", esbenefi);
				seccion.setAttribute("fully", fully);
				System.out.println("Beneficiario: " + fully);
			}
		}
	}

}
