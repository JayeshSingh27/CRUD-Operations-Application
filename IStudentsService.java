package in.ineuron.ServiceLayer;

import in.ineuron.Dto.Students;

public interface IStudentsService {
	public String addStudents(Integer sid,Integer sage,String sname,String saddresss);
	public Students searchStudents(Integer sid);
	public String updateStudents(Integer sid,Integer sage,String sname,String saddresss);
	public String deletStudents(Integer sid);
}
