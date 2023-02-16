package in.ineuron.ServiceLayer;

import in.ineuron.DaoFactory.StudentsDaoFactory;
import in.ineuron.DaoLayer.IStudentsDao;
import in.ineuron.Dto.Students;

public class StudentsServiceImpl implements IStudentsService
{
	private IStudentsDao studentsDao;

	@Override
	public String addStudents(Integer sid, Integer sage, String sname, String saddresss) {
		// TODO Auto-generated method stub
		studentsDao = StudentsDaoFactory.getstudentsDao();
		return studentsDao.addStudents(sid, sage, sname, saddresss);
	}

	@Override
	public Students searchStudents(Integer sid) {
		// TODO Auto-generated method stub
		studentsDao = StudentsDaoFactory.getstudentsDao();
		return studentsDao.searchStudents(sid);
	}

	@Override
	public String updateStudents(Integer sid, Integer sage, String sname, String saddresss) {
		// TODO Auto-generated method stub
		studentsDao  = StudentsDaoFactory.getstudentsDao();
		return studentsDao.updateStudents(sid, sage, sname, saddresss);
	}

	@Override
	public String deletStudents(Integer sid) {
		// TODO Auto-generated method stub
		studentsDao = StudentsDaoFactory.getstudentsDao();
		return studentsDao.deletStudents(sid);
	}
	
	
	
}
