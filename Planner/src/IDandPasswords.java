import java.util.HashMap;

public class IDandPasswords {
	
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	IDandPasswords() {
		loginInfo.put("Isabella", "Divine888");
	}
	
	protected HashMap getLogin() {
		return loginInfo;
	}
}
