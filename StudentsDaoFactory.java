package in.ineuron.DaoFactory;

import in.ineuron.DaoLayer.IStudentsDao;
import in.ineuron.DaoLayer.StudentsDaoImpl;

public class StudentsDaoFactory {
	private StudentsDaoFactory()
	{
		
	}
	private static IStudentsDao studentsDao = null;
	public static IStudentsDao getstudentsDao()
	{
		if(studentsDao == null)
		{
			studentsDao = new StudentsDaoImpl();
			
		}
		return studentsDao;
	}
}
