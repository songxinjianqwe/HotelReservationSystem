package hrs.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 
* @ClassName: DateHelper
* @Description: 日期处理工具类
* @author NewSong
* @date 2016年11月19日 下午9:40:05
*
 */

public class DateHelper {
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private static Calendar c = new GregorianCalendar();
	public static String format(Date date) {
		if(date!=null)
		    return formatter.format(date);
		else
			return "";
	}
	
	/**
	 * 按照MM-dd的格式format日期
	 * @param date
	 * @return
	 */
	public static String formatWithMD(Date date){
		String res = null;
		formatter.applyPattern("MM-dd");
		res = formatter.format(date);
		formatter.applyPattern("yyyy-MM-dd");
		return res;
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String date) throws ParseException {
		return formatter.parse(date);
	}

	public static Date parseWithHMS(String date) throws ParseException {
		Date res = null;
		formatter.applyPattern("yyyy-MM-dd hh:mm:ss");
		res = formatter.parse(date);
		formatter.applyPattern("yyyy-MM-dd");
		return res;
	}
	
	public static Date setHMSZero(Date date){
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY,0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	public static Date addOneDay(Date date){
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH)+1);
		return c.getTime();
	}
}

