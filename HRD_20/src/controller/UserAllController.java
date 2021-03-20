package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Shop.ShopDAO;
import Shop.ShopDTO;

@WebServlet("/userAll")
public class UserAllController extends HttpServlet{
	private static final long serialVersionUID=1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ShopDTO> list=ShopDAO.getUserAll();
		req.setAttribute("list", list);
		RequestDispatcher rd=req.getRequestDispatcher("userAll.jsp");
		rd.forward(req, resp);
	}
}
