package No3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex3
 * 1. 编写代码完成以下功能：
 * 		a. 从access.log中读入数据，获取IP和Time
 * 		b. 输出在时间区间[beginTime, endTime]内的IP和Time，以tab分割
 * 2. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class FilterByTime {
	public static void main(String[] args) throws ParseException, IOException {
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = regularFormat.parse("2015-12-31 18:00:00");
		Date endDate = regularFormat.parse("2015-12-31 19:00:00");
		FileReader fr = new FileReader("d:/access.log");
		BufferedReader br = new BufferedReader(fr);
		String s;
		while ((s = br.readLine()) != null) {
			// 对每行进行处理
			// 切分获取IP，Time
			Pattern r = Pattern.compile("(\\d+\\.\\d+\\.\\d+\\.\\d+) [^ ]+ [^ ]+ \\[(\\d+\\/[a-zA-z]{0,3}\\/[^\\s]*)");
			Matcher m = r.matcher(s);
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
					System.out.println(strIp + "\t" + strTime);
				}
			}
		}

		fr.close();

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
