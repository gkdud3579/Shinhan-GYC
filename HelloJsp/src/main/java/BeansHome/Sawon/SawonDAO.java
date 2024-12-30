//#################################################################################################
//SawonDAO.java - 사원검색 DAO 모듈
//#################################################################################################
//═════════════════════════════════════════════════════════════════════════════════════════
//외부모듈 영역
//═════════════════════════════════════════════════════════════════════════════════════════
package BeansHome.Sawon;

import java.util.ArrayList;

import Common.ComMgr;
import Common.ExceptionMgr;
import DAO.DBOracleMgr;

//═════════════════════════════════════════════════════════════════════════════════════════
//사용자정의 클래스 영역
//═════════════════════════════════════════════════════════════════════════════════════════
/***********************************************************************
* SawonDAO		: 사원검색 DAO 클래스<br>
* Inheritance	: None | 부모 클래스 명
***********************************************************************/
public class SawonDAO
{
	// —————————————————————————————————————————————————————————————————————————————————————
	// 전역상수 관리 - 필수영역
	// —————————————————————————————————————————————————————————————————————————————————————
	
	// —————————————————————————————————————————————————————————————————————————————————————
	// 전역변수 관리 - 필수영역(정적변수)
	// —————————————————————————————————————————————————————————————————————————————————————
	
	// —————————————————————————————————————————————————————————————————————————————————————
	// 전역변수 관리 - 필수영역(인스턴스변수)
	// —————————————————————————————————————————————————————————————————————————————————————
	/** DBMgr : 오라클 데이터베이스 DAO 객체 */
	public DBOracleMgr DBMgr = null;
	// —————————————————————————————————————————————————————————————————————————————————————
	// 생성자 관리 - 필수영역(인스턴스함수)
	// —————————————————————————————————————————————————————————————————————————————————————
	/***********************************************************************
	 * SawonDAO()	: 생성자
	 * @param void	: None
	 ***********************************************************************/
	public SawonDAO()
	{
		try
		{
			// -----------------------------------------------------------------------------
			// 기타 초기화 작업 관리
			// -----------------------------------------------------------------------------
			ExceptionMgr.SetMode(ExceptionMgr.RUN_MODE.DEBUG);
			
			this.DBMgr = new DBOracleMgr();
			this.DBMgr.SetConnectionString("172.24.154.143", 1521, "educ", "educ", "XE");
			// -----------------------------------------------------------------------------
		}
		catch (Exception Ex)
		{
			ExceptionMgr.DisplayException(Ex);		// 예외처리(콘솔)
		}
	}
	// —————————————————————————————————————————————————————————————————————————————————————
	// 전역함수 관리 - 필수영역(정적함수)
	// —————————————————————————————————————————————————————————————————————————————————————
	
	// —————————————————————————————————————————————————————————————————————————————————————
	// 전역함수 관리 - 필수영역(인스턴스함수)
	// —————————————————————————————————————————————————————————————————————————————————————
	/***********************************************************************
	 * ReadSawon()		: 데이터베이스에서 사원정보 읽기
	 * @param Sabun		: 사원번호 (조건용)
	 * @param sawonDTO	: 사원정보 DTO(결과 반환용)
	 * @return boolean	: 사원정보 검색 처리 여부(true|false)
	 * @throws Exception 
	 ***********************************************************************/
	public boolean ReadSawon(Integer Sabun, SawonDTO sawonDTO) throws Exception
	{
		String sSql = null;
		Object[] oPaValue = null;
		boolean bResult = false;
		
		try
		{
			// 사원정보 검색
			if (this.DBMgr.DbConnect() == true)
			{
				// 사원정보 읽기
				sSql = "BEGIN SP_MAN_R(?,?,?,?,?,?); END;";
				
				// IN 파라미터 갯수 만큼 메모리 할당
				oPaValue = new Object[5];
				
				oPaValue[0] = Sabun;
				oPaValue[1] = "-1";
				oPaValue[2] = 0;
				oPaValue[3] = "-1";
				oPaValue[4] = "-1";
				
				if (this.DBMgr.RunQuery(sSql, oPaValue, 6, true) == true)
				{
					while(this.DBMgr.Rs.next() == true)
					{
						sawonDTO.setSabun(this.DBMgr.Rs.getInt("Sabun"));
						sawonDTO.setName(ComMgr.IsNull(this.DBMgr.Rs.getString("Name"), "").trim());
						sawonDTO.setAge(this.DBMgr.Rs.getInt("Age"));
						sawonDTO.setGender(ComMgr.IsNull(this.DBMgr.Rs.getString("Gender"), "").trim());
						sawonDTO.setTel(ComMgr.IsNull(this.DBMgr.Rs.getString("Tel"), "").trim());
						sawonDTO.setDept(ComMgr.IsNull(this.DBMgr.Rs.getString("Dept"), "").trim());
						sawonDTO.setDeptname(ComMgr.IsNull(this.DBMgr.Rs.getString("DeptName"), "").trim());
						sawonDTO.setStcd(ComMgr.IsNull(this.DBMgr.Rs.getString("StCd"), "").trim());
						sawonDTO.setStcdname(ComMgr.IsNull(this.DBMgr.Rs.getString("StCdName"), "").trim());
						sawonDTO.setBdate(ComMgr.IsNull(this.DBMgr.Rs.getString("BDate"), "").trim());
						sawonDTO.setAddress(ComMgr.IsNull(this.DBMgr.Rs.getString("Address"), "").trim());
					}
					
					bResult = true;
				}
			}
		}
		catch (Exception Ex)
		{
			Common.ExceptionMgr.DisplayException(Ex);
		}
		
		return bResult;
	}
	/***********************************************************************
	 * ReadSawonList()	: 데이터베이스에서 사원정보 리스트 읽기
	 * @param sawonDTO	: 사원정보 DTO(조건용)
	 * @return boolean	: 사원정보 검색 처리 여부(true|false)
	 * @throws Exception 
	 ***********************************************************************/
	public boolean ReadSawonList(SawonDTO sawonDTO) throws Exception
	{
		String sSql = null;
		Object[] oPaValue = null;
		boolean bResult = false;
		
		try
		{
			// 사원정보 검색
			if (this.DBMgr.DbConnect() == true)
			{
				// 사원정보 읽기
				sSql = "BEGIN SP_MAN_R(?,?,?,?,?,?); END;";
				
				// IN 파라미터 갯수 만큼 메모리 할당
				oPaValue = new Object[5];
				
				oPaValue[0] = 0;
				oPaValue[1] = "-1";
				oPaValue[2] = sawonDTO.getAge();
				oPaValue[3] = sawonDTO.getGender();
				oPaValue[4] = sawonDTO.getDept();
				
				if (this.DBMgr.RunQuery(sSql, oPaValue, 6, true) == true)
				{
					bResult = true;
				}
			}
		}
		catch (Exception Ex)
		{
			Common.ExceptionMgr.DisplayException(Ex);
		}
		
		return bResult;
	}
	/***********************************************************************
	 * ReadSawonList()	: 데이터베이스에서 사원정보 리스트 읽기
	 * @param sawonDTO	: 사원정보 DTO(조건용)
	 * @param Sawons	: 사원정보 DTO(결과 반환용)
	 * @return boolean	: 사원정보 검색 처리 여부(true|false)
	 * @throws Exception 
	 ***********************************************************************/
	public boolean ReadSawonList(SawonDTO sawonDTO, ArrayList<SawonDTO> Sawons) throws Exception
	{
		String sSql = null;
		Object[] oPaValue = null;
		boolean bResult = false;
		
		try
		{
			// 사원정보 검색
			if (this.DBMgr.DbConnect() == true)
			{
				// 사원정보 읽기
				sSql = "BEGIN SP_MAN_R(?,?,?,?,?,?); END;";
				
				// IN 파라미터 갯수 만큼 메모리 할당
				oPaValue = new Object[5];
				
				oPaValue[0] = 0;
				oPaValue[1] = "-1";
				oPaValue[2] = sawonDTO.getAge();
				oPaValue[3] = sawonDTO.getGender();
				oPaValue[4] = sawonDTO.getDept();
				
				if (this.DBMgr.RunQuery(sSql, oPaValue, 6, true) == true)
				{
					while(this.DBMgr.Rs.next() == true)
					{
						SawonDTO Sawon = new SawonDTO();
						
						Sawon.setSabun(this.DBMgr.Rs.getInt("Sabun"));
						Sawon.setName(this.DBMgr.Rs.getString("Name"));
						Sawon.setAge(this.DBMgr.Rs.getInt("Age"));
						Sawon.setGender(this.DBMgr.Rs.getString("Gender"));
						Sawon.setTel(this.DBMgr.Rs.getString("Tel"));
						Sawon.setDept(this.DBMgr.Rs.getString("Dept"));
						Sawon.setDeptname(this.DBMgr.Rs.getString("DeptName"));
						Sawon.setStcd(this.DBMgr.Rs.getString("StCd"));
						Sawon.setStcdname(this.DBMgr.Rs.getString("StCdName"));
						Sawon.setBdate(this.DBMgr.Rs.getString("BDate"));
						Sawon.setAddress(this.DBMgr.Rs.getString("Address"));
						
						Sawons.add(Sawon);
					}
					
					bResult = true;
				}
			}
		}
		catch (Exception Ex)
		{
			Common.ExceptionMgr.DisplayException(Ex);
		}
		
		return bResult;
	}
	/***********************************************************************
	 * SaveSawonDetail()	: 데이터베이스에 사원정보 저장 (INSERT|UPDATE|DELETE)
	 * @param sawonDTO		: 사원정보 DTO(저장용)
	 * @return boolean		: 사원정보 저장 처리 여부(true|false)
	 * @throws Exception 
	 ***********************************************************************/
	public boolean SaveSawonDetail(SawonDTO sawonDTO) throws Exception
	{
		String sSql = null;
		Object[] oPaValue = null;
		boolean bResult = false;
		
		try
		{
			// 사원정보 저장 (JobStatus : INSERT|UPDATE|DELETE)
			if (this.DBMgr.DbConnect() == true)
			{
				// 사원정보 저장
				sSql = "BEGIN SP_MAN_CUD(?,?,?,?,?,?,?,?,?,?); END;";
				
				// IN 파라미터 갯수 만큼 메모리 할당
				oPaValue = new Object[10];
				
				oPaValue[0] = sawonDTO.getJobstatus();
				oPaValue[1] = sawonDTO.getSabun();
				oPaValue[2] = ComMgr.IsNull(sawonDTO.getName(), "");
				oPaValue[3] = sawonDTO.getAge();
				oPaValue[4] = ComMgr.IsNull(sawonDTO.getGender(), "");
				oPaValue[5] = ComMgr.IsNull(sawonDTO.getTel(), "");
				oPaValue[6] = ComMgr.IsNull(sawonDTO.getDept(), "");
				oPaValue[7] = ComMgr.IsNull(sawonDTO.getStcd(), "");
				oPaValue[8] = ComMgr.IsNull(sawonDTO.getBdate(), "");
				oPaValue[9] = ComMgr.IsNull(sawonDTO.getAddress(), "");
				
				if (this.DBMgr.RunQuery(sSql, oPaValue, 0, false) == true)
				{
					this.DBMgr.DbCommit();
					
					bResult = true;
				}
			}
		}
		catch (Exception Ex)
		{
			Common.ExceptionMgr.DisplayException(Ex);
		}
		finally
		{
			this.DBMgr.DbDisConnect();
		}
		
		return bResult;
	}
	// —————————————————————————————————————————————————————————————————————————————————————
}
//#################################################################################################
//<END>
//#################################################################################################
