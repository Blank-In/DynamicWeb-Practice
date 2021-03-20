package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		return con;
	}
	public static int lastNum() {
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select max(custno) from member_tbl_02");
			ResultSet rs=ps.executeQuery();
			rs.next();
			int number=rs.getInt(1)+1;
			rs.close();
			ps.close();
			con.close();
			return number;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static boolean insertMember(MemberDTO dto) {
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into member_tbl_02(custno, custname, phone, address, joindate, grade, city) values(?,?,?,?,?,?,?)");
			ps.setInt(1, dto.getCustno());
			ps.setString(2, dto.getCustname());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getAddress());
			ps.setString(5, dto.getJoindate());
			ps.setString(6, dto.getGrade());
			ps.setString(7, dto.getCity());
			ps.execute();
			ps.close();
			con.close();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static List<MemberDTO> MemberList() {
		List<MemberDTO> list=new ArrayList<MemberDTO>();
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select custno, custname, phone, address, to_char(joindate,'YYYY-MM-DD'), decode(grade,'A','VIP','B','일반','C','직원'), city from member_tbl_02");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				MemberDTO dto=new MemberDTO();
				dto.setCustno(rs.getInt(1));
				dto.setCustname(rs.getString(2));
				dto.setPhone(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setJoindate(rs.getString(5));
				dto.setGrade(rs.getString(6));
				dto.setCity(rs.getString(7));
				list.add(dto);
			}
			rs.close();
			ps.close();
			con.close();
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static List<MoneyDTO> MoneyList(){
		List<MoneyDTO> list=new ArrayList<MoneyDTO>();
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT a.custno, custname, decode(grade,'A','VIP','B','일반','C','직원'), sum(price) FROM money_tbl_02 a JOIN member_tbl_02 b ON a.custno=b.custno GROUP BY a.custno,custname,grade ORDER BY sum(price) DESC");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				MoneyDTO dto=new MoneyDTO();
				dto.setCustno(rs.getInt(1));
				dto.setCustname(rs.getString(2));
				dto.setGrade(rs.getString(3));
				dto.setMoney(rs.getInt(4));
				list.add(dto);
			}
			rs.close();
			ps.close();
			con.close();
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static MemberDTO getUser(int number) {
		MemberDTO dto=new MemberDTO();
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select custno, custname, phone, address, to_char(joindate,'YYYY-MM-DD'), grade, city from member_tbl_02 where custno="+number);
			ResultSet rs=ps.executeQuery();
			rs.next();
			dto.setCustno(rs.getInt(1));
			dto.setCustname(rs.getString(2));
			dto.setPhone(rs.getString(3));
			dto.setAddress(rs.getString(4));
			dto.setJoindate(rs.getString(5));
			dto.setGrade(rs.getString(6));
			dto.setCity(rs.getString(7));
			rs.close();
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public static boolean editMember(MemberDTO dto,int originno) {
		boolean result=false;
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("update member_tbl_02 set custno=?, custname=?, phone=?, address=?, joindate=?, grade=?, city=? where custno=?");
			ps.setInt(1, dto.getCustno());
			ps.setString(2, dto.getCustname());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getAddress());
			ps.setString(5, dto.getJoindate());
			ps.setString(6, dto.getGrade());
			ps.setString(7, dto.getCity());
			ps.setInt(8, originno);
			result=ps.execute();
			ps.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
