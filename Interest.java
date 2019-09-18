package register_information;

public class Interest {

	String code;
	String desc;
	public Interest(String c, String d)
	{
		this.code = c;
		this.desc = d;
	}
	public Interest()
	{
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
