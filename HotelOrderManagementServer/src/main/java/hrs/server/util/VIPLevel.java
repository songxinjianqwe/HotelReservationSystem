package hrs.server.util;

/**
 * 用于根据信用值计算会员等级
 * @author NewSong
	<0 ~ 500  1
	500       2
	1500      3
	3000      4
	>5000      5
 */
public class VIPLevel {
	public static final int [] low  = {0,500,1500,3000,5000};
	public static final int [] high  = {500,1500,3000,5000,Integer.MAX_VALUE};
	public static final int [] level = {1,2,3,4,5};
	/**
	 * 
	 * @Title: getLevel 
	 * @Description 表驱动
	 * @param @param credit
	 * @param @return     
	 * @return int     
	 * @throws
	 */
	public static int getLevel(double credit){
		assert credit >=0;
		for(int i = 0; i < low.length;++i){
			if(credit >= low[i] && credit < high[i]){
				return level[i];
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		System.out.println(getLevel(6000));
	}
}

