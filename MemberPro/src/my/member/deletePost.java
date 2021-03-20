package my.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

@WebServlet("/deletePost")
public class deletePost extends HttpServlet{ //delete post from post database
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PostDAO dao = new PostDAO(); //using PostDAO class
		
		if(req.getSession().getAttribute("loginId") == null) { //if not logged now
			resp.sendRedirect("member/loginForm.jsp");//go to loginForm.jsp
			return;
		}
		else if(req.getSession().getAttribute("loginId").equals(req.getParameter("id"))) { //if post writer same current login user
			dao.deleteMember(Integer.parseInt(req.getParameter("number"))); //post number to delete send to PostDAO
		}
		
		resp.sendRedirect("member/logOn_sub.jsp"); //go to logOn_sub.jsp
		return;
	}
}
