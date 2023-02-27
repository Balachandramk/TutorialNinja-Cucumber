package utils;

import java.util.Date;

public class CommonUtilities {
	
	public String emailwithTimeStamp;
	public static final int IMPLICIT_WAIT_TIME = 30;
	public static final int PAGE_LOAD_TIME = 20;
	public static final int EXPLICIT_WAIT_TIME = 20;
	
	
	public String emailWithTimeStamp() {
		Date date = new Date();
		try {
		emailwithTimeStamp = "kbalachandram@"+date.toString().replace(" ", "").replace(":", "") + "yahoo.com";
		} catch(Throwable t) {
			t.printStackTrace();
		}
		return emailwithTimeStamp;
	}

}
