package No2;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex2
 * 1. 修改代码，使程序在输入『31/Dec/2015:00:02:09』的时候，转化为时间戳并输出，把结果填写到README.md当中
 * 2. 和ex1对比，对多出来的代码进行注释
 * 3. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class DifferentFormat {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Locale locale = Locale.US; 
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale); //修改格式
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			//对输入的数据进行分割，并将其拼接成"yyyy-MM-dd HH:mm:ss"格式
			String str[] = line.split("/");
			String str2[] = str[2].split(":");
			String time = str2[0]+"-"+month1(str[1])+"-"+str[0]+" "+str2[1]+":"+str2[2]
					+":"+str2[3];//将其拼接成所需要的格式
			Date lineDate = null;
			long lineTimestamp;
			try {
				lineDate = inputFormat.parse(time);
				lineTimestamp = lineDate.getTime();
				System.out.println(lineTimestamp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
//构造一个month1方法来将英文的月份转换成数字的形式
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
