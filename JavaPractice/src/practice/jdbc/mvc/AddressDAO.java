package practice.jdbc.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import practice.jdbc.DBUtil;	

public class AddressDAO {
	
	private static Scanner scan = new Scanner(System.in);
	private Connection conn = null;
	private Statement stat = null;
	private PreparedStatement pstat = null;
	private ResultSet rs = null;
	
	public AddressDAO() {
		try {
			this.conn = DBUtil.open();
			this.stat = conn.createStatement();
		} catch (Exception e) {
			System.out.println("primaryAddressDAO.enAddressDAO()");
			e.printStackTrace();
		}
	}
	
	public int addressAdd(AddressDTO dto) {
		
		try {
			
			String sql = " insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, ?, ?, ?, ?, ?, default)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getAge());
			pstat.setString(3, dto.getGender());
			pstat.setString(4, dto.getTel());
			pstat.setString(5, dto.getAddress());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("primaryAddressDAO.enadd()");
			e.printStackTrace();
		}
		
		return 0;
	}
		

	
	public ArrayList<AddressDTO> addressList(String word) {
		
		// word = null -> 목록 보기
		// word = "???" -> 검색하기
		
		// select -> ResultSet -> ArrayList<AddressDTO> -> 반환
		
		try {
			
			String where = "";
			
			if(word != null) {
				where = String.format("where address like '%%%s%%'", word);
			}
			
			
			String sql = String.format("Select * from tblAddress %s order by seq desc", where);
			
			
			rs = stat.executeQuery(sql);
			
			// ResultSet -> ArrayList<AddressDTO>
			ArrayList<AddressDTO> list = new ArrayList<AddressDTO>();
			
			while (rs.next()) {
				// 레코드 1개 -> AddressDTO 1개
				AddressDTO dto = new AddressDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
				
			}
			
			return list;
			
			// list = rs
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("primaryAddressDAO.enlist()");
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public int addressDelete(String seq) {
		try {
			
			String sql = "delete from tblAddress where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("primaryAddressDAO.endelete()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public AddressDTO get(String seq) {

		try {
			
			String sql = "select * from tblAddress where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				// 레코드 1개 반환 -> AddressDTO 1개
				AddressDTO dto = new AddressDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setRegdate(rs.getString("regdate"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			System.out.println("primaryAddressDAO.enget()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int addressEdit(AddressDTO dto2) {
		try {
			
			String sql = "update tblAddress set name=?, age=?, gender=?, tel=?, address=? where seq=?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1,  dto2.getName());
			pstat.setString(2,  dto2.getAge());
			pstat.setString(3,  dto2.getGender());
			pstat.setString(4,  dto2.getTel());
			pstat.setString(5,  dto2.getAddress());
			pstat.setString(6,  dto2.getSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("primaryAddressDAO.enedit()");
			e.printStackTrace();
		}
		return 0;
	}
	

	

}
