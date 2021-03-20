package my.member;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
@WebServlet("/editPost")
public class EditPost extends HttpServlet{ //edit post data
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); //ServletRequest character encoding set UTF-8
		
		PostDAO dao = new PostDAO(); //using PostDAO class
		PostDTO dto = new PostDTO(); //using PostDTO class
		
		HttpSession session = req.getSession(); //get HttpSession from ServletRequest. Because need current loginId attribute
		ServletContext application = getServletContext(); //get ServletContext
		String savePath = application.getRealPath("/File"); //get real location of 'File' folder from ServletContext
		
		int sizeLimit = 5 * 1024 * 1024; //File maximum Size | 1024Byte=1kb, 1kb*1024=1mb, 1mb*5=5mb 
		String title = "", lore = "", fileName = "", originFileName = ""; //Parameter variables
		String ID = (String)session.getAttribute("loginId"); //get current loginId attribute
		
		if(ID == null) { //if not logged now
			resp.sendRedirect("member/loginForm.jsp");//go to loginForm.jsp
			return;
		}
		
		try{
			//change ServletRequest to MultipartRequest
			//DefaultFileRenamePolicy - if current upload file name is one of the already uploaded file name. changing file name
			MultipartRequest multi=new MultipartRequest(req, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
			
			if(!multi.getParameter("id").equals(ID)) { //if post writer not same current login user
				resp.sendRedirect("member/logOn_sub.jsp"); //go to logOn_sub.jsp
				return;
			}
			
			title=multi.getParameter("title"); //get title parameter
			lore=multi.getParameter("lore"); //get lore parameter
			Enumeration files = multi.getFileNames(); //get file name
			String file = (String)files.nextElement(); //┘
			fileName = multi.getFilesystemName(file); //┘
			originFileName = multi.getOriginalFileName(file); //Original file name changed by DefaultFileRenamePolicy
			dto.setNumber(Integer.parseInt(multi.getParameter("number"))); //get number parameter and change variable type
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		dto.inputAll(title, lore, ID, fileName, originFileName); //all parameter input to PostDTO
		dao.updatePost(dto); //want change
		resp.sendRedirect("member/logOn_sub.jsp"); //go to logOn_sub.jsp
		return;
	}
}
