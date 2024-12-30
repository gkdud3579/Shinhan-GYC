package BeansHome.Sawon;

public class SawonDTO
{
	/** jobstatus	: Beans 작업상태 필드(JSP 입력 객체와 1:1 대응, 소문자로 시작) */
	private String jobstatus = null;
	/** sabun		: Beans 사번 필드(JSP 입력 객체와 1:1 대응, 소문자로 시작) */
	private Integer sabun = 0;
	/** name		: Beans 성명 필드(JSP 입력 객체와 1:1 대응, 소문자로 시작) */
	private String name = null;
	/** age			: Beans 나이 필드(JSP 입력 객체와 1:1 대응, 소문자로 시작) */
	private Integer age = 0;
	/** gender		: Beans 성별 필드(JSP 입력 객체와 1:1 대응, 소문자로 시작) */
	private String gender = null;
	/** tel			: Beans 전화 필드(JSP 입력 객체와 1:1 대응, 소문자로 시작) */
	private String tel = null;
	/** dept		: Beans 부서 필드(JSP 입력 객체와 1:1 대응, 소문자로 시작) */
	private String dept = null;
	/** deptname	: Beans 부서명 필드(JSP 입력 객체와 1:1 대응, 소문자로 시작) */
	private String deptname = null;
	/** stcd		: Beans 직급 필드(JSP 입력 객체와 1:1 대응, 소문자로 시작) */
	private String stcd = null;
	/** stcdname	: Beans 직급명 필드(JSP 입력 객체와 1:1 대응, 소문자로 시작) */
	private String stcdname = null;
	/** bdate		: Beans 생일 필드(JSP 입력 객체와 1:1 대응, 소문자로 시작) */
	private String bdate = null;
	/** address		: Beans 주소 필드(JSP 입력 객체와 1:1 대응, 소문자로 시작) */
	private String address = null;
	
	public String getJobstatus()
	{
		return jobstatus;
	}
	public void setJobstatus(String jobstatus)
	{
		this.jobstatus = jobstatus;
	}
	public Integer getSabun()
	{
		return sabun;
	}
	public void setSabun(int sabun)
	{
		this.sabun = sabun;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Integer getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	public String getDept()
	{
		return dept;
	}
	public void setDept(String dept)
	{
		this.dept = dept;
	}
	public String getDeptname()
	{
		return deptname;
	}
	public void setDeptname(String deptname)
	{
		this.deptname = deptname;
	}
	public String getStcd()
	{
		return stcd;
	}
	public void setStcd(String stcd)
	{
		this.stcd = stcd;
	}
	public String getStcdname()
	{
		return stcdname;
	}
	public void setStcdname(String stcdname)
	{
		this.stcdname = stcdname;
	}
	public String getBdate()
	{
		return bdate;
	}
	public void setBdate(String bdate)
	{
		this.bdate = bdate;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
}
