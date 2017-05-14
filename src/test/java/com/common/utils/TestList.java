package com.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: TestList
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 唐阔
 * @date 2017年5月14日 下午12:06:18
 * 
 */
public class TestList
{
	private static final Logger LOG = LoggerFactory.getLogger(TestList.class);

	/**
	 * 
	 * @Title: testCollectionUtils
	 * @Description: TODO(测试集合工具类使用)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@Test
	public void testCollectionUtils()
	{
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		if (CollectionUtils.isNotEmpty(list))
		{
			System.out.println("====" + list);
			LOG.info("---------" + list);
		}

	}
}
