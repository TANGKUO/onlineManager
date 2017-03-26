package com.tangkuo.cn;

import java.util.Properties;

import org.junit.Test;

import com.tangkuo.cn.common.CommonProperty;

import junit.framework.Assert;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: www.tk.com</p>   
 * @author   tangkuo
 * @date    2017年3月26日 上午9:40:39
 */
public class CommonPropertyTest {
	
	private static CommonProperty commonProperty;
	
	@SuppressWarnings({ "static-access", "deprecation" })
	@Test
	public void testLoadProerty(){
		Properties ps = commonProperty.getProps();
		String jdbcUserName = commonProperty.getValue("jdbc.username");
		
		System.out.println(ps +"======" + jdbcUserName);
		Assert.assertEquals("tangkuo", jdbcUserName);
		
	}
}
