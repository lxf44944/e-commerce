package servlet.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CopyFileName {
	
	
	public static String makeNewFileName(String oldFileName){
		String ext = oldFileName.substring(oldFileName.lastIndexOf("."));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		
		String time = dateFormat.format(new Date());
		time +=  new Random().nextInt(100);
		String newFileName = time+ext;
		return newFileName;
		
	}

}
