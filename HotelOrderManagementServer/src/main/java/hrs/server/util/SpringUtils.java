package hrs.server.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
/**
 * 
* @ClassName: SpringUtils
* @Description: Spring的加载器和bean生成器
* @author NewSong
* @date 2016年11月19日 下午9:40:26
*
 */
@Component
public class SpringUtils {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");// 声明一个静态变量保存
	
	/**
	 * 从spring容器里获取bean
	 * 
	 * @param beanId
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanId) {
		T bean = null;
		try {
			if (context != null && StringUtils.isNotEmpty(StringUtils.trim(beanId))) {
				bean = (T) context.getBean(beanId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
}
