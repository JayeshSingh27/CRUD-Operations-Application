package in.ineuron.DaoLayer;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.Dto.Students;

import in.ineuron.util.JdbcUtil;

public class StudentsDaoImpl implements IStudentsDao
{
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	Students students = null;
	@Override
	public String addStudents(Integer sid, Integer sage, String sname, String saddresss) {
		// TODO Auto-generated method stub
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement("insert into students (`sid`,`sage`,`sname`,`saddress`) values(?,?,?,?)");
			}
			if(pstmt != null)
			{
				pstmt.setInt(1, sid);
				pstmt.setInt(2, sage);
				pstmt.setString(3, sname);
				pstmt.setString(4, saddresss);
			}
			if(pstmt != null)
			{
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 1)
				{
					return "Success";
				}
				else
				{
					return "Failed"; 
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		return null;
	}

	@Override
	public Students searchStudents(Integer sid) {
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement("select sid,sage,sname,saddress from students where sid = ?");
			}
			if (pstmt != null)
			{
				pstmt.setInt(1, sid);
			}
			if(pstmt != null)
			{
				resultSet = pstmt.executeQuery();
			}
			if (resultSet != null) {

				if (resultSet.next()) {
					students = new Students();

					// copy resultSet data to student object
					students.setSid(resultSet.getInt(1));
					students.setSage(resultSet.getInt(2));
					students.setSname(resultSet.getString(3));
					students.setSaddress(resultSet.getString(4));

					return students;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		
		return null;
	}
	
	@Override
	public String deletStudents(Integer sid) {
		// TODO Auto-generated method stub
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null)
			{
				pstmt = connection.prepareStatement("delete from students where sid = ?");
			}
			if(pstmt!= null)
			{
				pstmt.setInt(1, sid);
			}
			if(pstmt != null)
			{
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected != 1)
				{
					return "Success";
				}
				else
				{
					return "Failed"; 
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}			
		return "Failed";
	}

	@Override
	public String updateStudents(Integer sid, Integer sage, String sname, String saddresss) {
		// TODO Auto-generated method stub
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection != null)
			{
				pstmt = connection.prepareStatement("update students set sage = ? , sname = ? , saddress = ? where sid = ? ");
			}
			if(pstmt != null)
			{
				pstmt.setInt(1, sage);
				pstmt.setString(2, sname);
				pstmt.setString(3,saddresss);
				pstmt.setInt(4, sid);				
			}
			if(pstmt != null)
			{
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 1)
				{
					return "Success";
				}
				else {
					return "Failed";
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}


	
}
