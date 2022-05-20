package util;

public class FileUtil {

	public static String getFileRename(String orgName) {
		return System.currentTimeMillis()
					+ orgName.substring(orgName.lastIndexOf("."));
	}
}
