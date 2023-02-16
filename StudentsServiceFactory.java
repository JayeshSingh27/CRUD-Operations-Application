package in.ineuron.ServiceFactory;

import in.ineuron.ServiceLayer.IStudentsService;
import in.ineuron.ServiceLayer.StudentsServiceImpl;

public class StudentsServiceFactory {
	private StudentsServiceFactory()
	{
		
	}
	private static IStudentsService studentsService;
	public static IStudentsService getstudentsService()
	{
		if(studentsService == null)
		{
			studentsService = new StudentsServiceImpl();
		}
		return studentsService;
	}
}
