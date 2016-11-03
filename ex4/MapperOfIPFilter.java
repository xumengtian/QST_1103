package No4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapperOfIPFilter {
	public static void main(String[] args) throws ParseException{
		if(args.length<1){
			System.out.println("input error");
			System.exit(-1);
		}
		String[] Aaa = args[0].split(",");
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = regularFormat.parse(Aaa[0]);
		Date endDate = regularFormat.parse(Aaa[1]);
		Scanner scanner = new Scanner(System.in);
		String line=null;
		while (scanner.hasNext()){
			line = scanner.nextLine();
			Pattern r = Pattern.compile("(\\d+\\.\\d+\\.\\d+\\.\\d+) [^ ]+ [^ ]+ \\[(\\d+\\/[a-zA-z]{0,3}\\/[^\\s]*)");
			Matcher m = r.matcher(line);
			while (m.find()) {
				String strIp = null;
				String strTime = null;
				strIp = m.group(1);
				String str[] = m.group(2).split("/");
				String str2[] = str[2].split(":");
				strTime = str2[0] + "-" + month1(str[1]) + "-" + str[0] + " " + str2[1] + ":" + str2[2] + ":" + str2[3];
				Date nowTime = regularFormat.parse(strTime);
				// 对在时间区间内的数据进行输出
				if (nowTime.getTime() > beginDate.getTime() && nowTime.getTime() < endDate.getTime()) {
					System.out.println(strIp);
				}
			}
		}
		
	}

	private static String month1(String string) {
		String ss = null;
		if (string.equals("Jan")) {
			ss = "01";
		} else if (string.equals("Feb")) {
			ss = "02";
		} else if (string.equals("Mar")) {
			ss = "03";
		} else if (string.equals("Apr")) {
			ss = "04";
		} else if (string.equals("May")) {
			ss = "05";
		} else if (string.equals("Jun")) {
			ss = "06";
		} else if (string.equals("Jul")) {
			ss = "07";
		} else if (string.equals("Aug")) {
			ss = "08";
		} else if (string.equals("Sep")) {
			ss = "09";
		} else if (string.equals("Oct")) {
			ss = "10";
		} else if (string.equals("Nov")) {
			ss = "11";
		} else if (string.equals("Dec")) {
			ss = "12";
		}
		return ss;
	}
}
