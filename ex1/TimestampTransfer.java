package No1;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
public class TimestampTransfer {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);//键盘输入数据
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//输入格式
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//输出格式
		while (scanner.hasNext()){//hasNext逐行输入数据
			String line = scanner.nextLine();
			Date lineDate = null;//定义一个Data类型的变量并初始化
			long lineTimestamp;//定义一个长整型的变量lineTimestamp
			try {//抛出异常
				lineDate = inputFormat.parse(line);//调用inputFormat的parse方法。parse 方法返回一个整数值,这个整数表示 dateVal 中所包含的日期与1970年1月1日午夜之间相间隔的毫秒数
				lineTimestamp = lineDate.getTime();//获取时间
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);//按其格式输出，lineTimestamp表示键盘输入时间和1970年1月1日之间相差毫秒数
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
