package com.tangkuo.cn;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangkuo.cn.common.CommonProperty;

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
 * @date 2017年3月26日 上午9:40:39
 */
public class CommonPropertyTest
{
	private static final Logger LOG = LoggerFactory.getLogger(CommonPropertyTest.class);
	private static CommonProperty commonProperty;

	@SuppressWarnings(
	{ "static-access", "deprecation" })
	@Test
	public void testLoadProerty()
	{
		Properties ps = commonProperty.getProps();
		String jdbcUserName = commonProperty.getValue("jdbc.username");
		LOG.info("---------" + jdbcUserName);
		System.out.println(ps +"======" + jdbcUserName);
		Assert.assertEquals("tangkuo", jdbcUserName);

	}
}
