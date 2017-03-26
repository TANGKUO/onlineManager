package com.tangkuo.cn.common;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.tk.com
 * </p>
 * 
 * @author tangkuo
 * @date 2017年3月26日 上午9:39:23
 */
public class CommonProperty {

	private static Logger log = LoggerFactory.getLogger(CommonProperty.class);

	private static Properties props = new Properties();

	/**
	 * 单例
	 */
	static {
		try {
			props.load(CommonProperty.class.getClassLoader().getResourceAsStream("common.properties"));
		} catch (IOException e) {
			log.error("CommonProperty.init is error " + e);
			e.printStackTrace();
		}
	}

	/**
	 * 获取整个配置
	 * 
	 * @return
	 */
	public static Properties getProps() {
		return props;
	}

	/**
	 * 根据key获取value
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		return props.getProperty(key);
	}

}
