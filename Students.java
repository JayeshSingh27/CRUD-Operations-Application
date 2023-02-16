package in.ineuron.Dto;

public class Students 
{
	Integer sid;
	Integer sage;
	String sname;
	String saddress;
	@Override
	public String toString() {
		return "StudentsDto [sid=" + sid + ", sage=" + sage + ", sname=" + sname + ", saddress=" + saddress + "]";
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
	
}	
