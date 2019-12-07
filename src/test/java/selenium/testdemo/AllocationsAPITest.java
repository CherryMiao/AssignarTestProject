package selenium.testdemo;


import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.testdata.Testdata;
import com.util.HttpUtil;


public class AllocationsAPITest {
	
	String token;
	
	@Test(priority = 1)
	public void login() throws Exception {
		String[] loginResponse = HttpUtil.sendHttpPost(Testdata.LOGINURL, Testdata.REQUESTBODY);
		
		String statusCode = loginResponse[0];
		JSONObject o = new JSONObject(loginResponse[1]);
		token = (String) o.getJSONObject("data").get("token");
		
		assertEquals(statusCode, "200");
	}
	  
	@Test(priority = 2)
	public void confirmTask() throws Exception {
		String[] confrimResponse = HttpUtil.sendHttpPostWithToken(Testdata.CONFIRMURL, token, Testdata.ALLOCATIONID);
				
		String statusCode = confrimResponse[0];
		
		assertEquals(statusCode, "201");
	}
  
}
