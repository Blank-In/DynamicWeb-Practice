package my.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
	
	private Connection getConnection() { //connect to MySQL database
		Connection conn = null; //Connection create
		try {
			Class.forName("com.mysql.jdbc.Driver"); //load class
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/qly5Jzj0B4","qly5Jzj0B4","nlyiFl4UYQ"); //connect
		} catch (ClassNotFoundException e) {
			System.out.println("driver not found");
		} catch (SQLException e) {
			System.out.println("DB connection failed");
		}
		return conn;
	}
	
	private List<PostDTO> makeArray(ResultSet rs) throws SQLException { //ResultSet change to PostDTO list
		List<PostDTO> list = new ArrayList<PostDTO>();
		
		while(rs.next()) { //while next ResultSet data is not null
			PostDTO dto = new PostDTO();
			
			dto.setCreateDate(rs.getDate("createDate"));
			dto.setFileName(rs.getString("fileName"));
			dto.setID(rs.getString("id"));
			dto.setLore(rs.getString("lore"));
			dto.setOriginFileName(rs.getString("originFileName"));
			dto.setTitle(rs.getString("title"));
			dto.setNumber(rs.getInt("number"));
			
			list.add(dto);
		}
		
		return list;
	}
	
	private PostDTO makeDto(ResultSet rs) throws SQLException{ //ResultSet change to one PostDTO
		PostDTO dto=new PostDTO();
		
		rs.next();
		dto.setCreateDate(rs.getDate("createDate"));
		dto.setFileName(rs.getString("fileName"));
		dto.setID(rs.getString("id"));
		dto.setLore(rs.getString("lore"));
		dto.setOriginFileName(rs.getString("originFileName"));
		dto.setTitle(rs.getString("title"));
		dto.setNumber(rs.getInt("number"));
		
		return dto;
	}
	
	public void writePost(PostDTO dto) { //add post to database
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int postNumber = 0; //new post number
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM `MEMBER` WHERE ID=?"; //get number data from dummy member data
			ps = conn.prepareStatement(sql);
			ps.setString(1, "post_number_check"); //dummy data ID is post_number_check
			rs = ps.executeQuery();
			rs.next(); //get dummy data
			postNumber=rs.getInt("BIRTH")+1; //save right post number
			
			sql = "UPDATE `MEMBER` SET BIRTH=" + postNumber + " WHERE ID=?"; //save next number data to dummy member data
			ps = conn.prepareStatement(sql);
			ps.setString(1, "post_number_check"); //dummy data ID is post_number_check
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(ps!=null) ps.close();} catch(SQLException e) { }
			try { if(rs!=null) rs.close();} catch(SQLException e) { }
			try { if(conn!=null) conn.close();} catch(SQLException e) { }
		}
		
		try {
			conn = getConnection();
			String insert = "INSERT INTO `POST` values(?,?,?,?,?,?,now())"; //six data and now date insert
			ps = conn.prepareStatement(insert);
			
			ps.setInt(1, postNumber);
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getLore());
			ps.setString(4, dto.getID());
			ps.setString(5, dto.getFileName());
			ps.setString(6, dto.getOriginFileName());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(ps!=null) ps.close();} catch(SQLException e) { }
			try { if(conn!=null) conn.close();} catch(SQLException e) { }
		}
		return;
	}
	
	public PostDTO selectPost(int number) { //get one post data
		PostDTO dto=new PostDTO(); //using PostDTO class
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM `POST` WHERE NUMBER=?"; //get all data from want post number
			ps = conn.prepareStatement(sql);
			ps.setInt(1, number); //wanted post number set
			rs = ps.executeQuery();
			
			dto = makeDto(rs); //post data change to PostDTO class
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(ps!=null) ps.close();} catch(SQLException e) { }
			try { if(rs!=null) rs.close();} catch(SQLException e) { }
			try { if(conn!=null) conn.close();} catch(SQLException e) { }
		}
		return dto;
	}

	public List<PostDTO> selectPosts(){ //get all post data
		List<PostDTO> list = new ArrayList<PostDTO>(); //PostDTO list
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM `POST`"; //get all data from all post
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			list = makeArray(rs); //all post data change to PostDTO class
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(ps!=null) ps.close();} catch(SQLException e) { }
			try { if(rs!=null) rs.close();} catch(SQLException e) { }
			try { if(conn!=null) conn.close();} catch(SQLException e) { }
		}
		return list;
	}
	
	public void deleteMember(int number) { //delete post using want number
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn=getConnection();
			String sql = "DELETE FROM `POST` WHERE NUMBER=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, number);
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(ps!=null) ps.close();} catch(SQLException e) { }
			try { if(conn!=null) conn.close();} catch(SQLException e) { }
		}
	}
	
	public void updatePost(PostDTO dto) { //update post using PostDTO class
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn=getConnection();
			String sql="";
			
			if(dto.getFileName()!=null) { //if File change, database File change
				sql = "UPDATE `POST` SET TITLE=?, LORE=?, FILENAME=?, ORIGINFILENAME=? WHERE NUMBER=?";
			}
			else { //if not change, not change File
				sql = "UPDATE `POST` SET TITLE=?, LORE=? WHERE NUMBER=?";
			}
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getLore());
			
			if(dto.getFileName()!=null) { //if File change, database File change
				ps.setString(3,dto.getFileName());
				ps.setString(4,dto.getOriginFileName());
				ps.setInt(5,dto.getNumber() );
			}
			else { //if not change, not change File
				ps.setInt(3,dto.getNumber());
			}
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(ps!=null) ps.close();} catch(SQLException e) { }
			try { if(conn!=null) conn.close();} catch(SQLException e) { }
		}
	}
	
}
