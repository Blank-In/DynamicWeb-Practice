package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Shop.*;

@WebServlet("/edit")
public class EditController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		System.out.println("memberInsert");
		ShopDTO dto=new ShopDTO();
		dto.setCustno(req.getParameter("custno"));
		dto.setCustname(req.getParameter("custname"));
		dto.setPhone(req.getParameter("phone"));
		dto.setAddress(req.getParameter("address"));
		dto.setJoindate(req.getParameter("joindate"));
		dto.setGrade(req.getParameter("grade"));
		dto.setCity(req.getParameter("city"));
		ShopDAO.updateUser(dto,Integer.parseInt(req.getParameter("originno")));
		resp.sendRedirect("index.jsp");
	}
}
