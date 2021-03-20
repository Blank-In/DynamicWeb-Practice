package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Shop.ShopDAO;
import Shop.ShopDTO;

@WebServlet("/create")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idx = String.valueOf(ShopDAO.getLastUserIdx());
		request.setAttribute("idx", idx);
		
		RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
		
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ShopDTO dto=new ShopDTO();
		dto.setCustno(request.getParameter("custno"));
		dto.setCustname(request.getParameter("custname"));
		dto.setPhone(request.getParameter("phone"));
		dto.setAddress(request.getParameter("address"));
		dto.setJoindate(request.getParameter("joindate"));
		dto.setGrade(request.getParameter("grade"));
		dto.setCity(request.getParameter("city"));
		System.out.println(ShopDAO.insertUser(dto));
		request.setAttribute("rst", "true");
		RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
