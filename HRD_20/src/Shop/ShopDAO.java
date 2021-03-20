package Shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

public class ShopDAO {
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		return con;
	}
	
	public static int getLastUserIdx() {
		PreparedStatement pstmt = null;
		int idx = 0;
		String sql = "select nvl(max(custno),0) custno from member_tbl_02";
		
		try {
			pstmt = getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				idx = rs.getInt("custno")+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idx;
	}
	
	public static List<ShopDTO> getUserAll(){
		PreparedStatement pstmt = null;
		List<ShopDTO> idx=new ArrayList<ShopDTO>();
		String sql = "select * from member_tbl_02";
		
		try {
			pstmt = getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ShopDTO dto=new ShopDTO();
				dto.setCustno(String.valueOf(rs.getInt("custno")));
				dto.setCustname(String.valueOf(rs.getString("custname")));
				dto.setPhone(String.valueOf(rs.getString("phone")));
				dto.setAddress(String.valueOf(rs.getString("address")));
				dto.setJoindate(String.valueOf(rs.getString("joindate")));
				dto.setGrade(String.valueOf(rs.getString("grade")));
				dto.setCity(String.valueOf(rs.getString("city")));
				idx.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idx;
	}
	
	public static int insertUser(ShopDTO dto) {
		PreparedStatement pstmt=null;
		String sql="insert into member_tbl_02(custno, custname, phone, address, joindate, grade, city) values(?,?,?,?,?,?,?)";
		try {
			pstmt=getConnection().prepareStatement(sql);
			pstmt.setInt(1, Integer.valueOf(dto.getCustno()));
			pstmt.setString(2, dto.getCustname());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getJoindate());
			pstmt.setString(6, dto.getGrade());
			pstmt.setString(7, dto.getCity());
			return pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static boolean updateUser(ShopDTO dto,int originno) {
		PreparedStatement ps=null;
		String sql="update member_tbl_02 set custno=?, custname=?, phone=?, address=?, joindate=?, grade=?, city=? where custno=?";
		try {
			ps=getConnection().prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(dto.getCustno()));
			ps.setString(2, dto.getCustname());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getAddress());
			ps.setString(5, dto.getJoindate());
			ps.setString(6, dto.getGrade());
			ps.setString(7, dto.getCity());
			ps.setInt(8, originno);
			ps.executeUpdate();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static ShopDTO getUser(int custno) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		ShopDTO dto=new ShopDTO();
		String sql="select custname, phone, address, joindate, grade, city from member_tbl_02 where custno=?";
		try {
			ps=getConnection().prepareStatement(sql);
			ps.setInt(1, custno);
			rs=ps.executeQuery();
			rs.next();
			dto.setCustno(String.valueOf(custno));
			dto.setCustname(rs.getString(1));
			dto.setPhone(rs.getString(2));
			dto.setAddress(rs.getString(3));
			dto.setJoindate(rs.getString(4));
			dto.setGrade(rs.getString(5));
			dto.setCity(rs.getString(6));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public static List<MoneyDTO> getMoneyAll(){
		List<MoneyDTO> list=new ArrayList<MoneyDTO>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select a.custno, custname, decode(grade,'A','VIP','B','일반','C','직원'), sum(price) from money_tbl_02 a join member_tbl_02 b on a.custno=b.custno group by a.custno,custname,grade";
		try {
			ps=getConnection().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				MoneyDTO dto=new MoneyDTO();
				dto.setCustno(rs.getInt(1));
				dto.setCustname(rs.getString(2));
				dto.setGrade(rs.getString(3));
				dto.setPrice(rs.getInt(4));
				list.add(dto);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
