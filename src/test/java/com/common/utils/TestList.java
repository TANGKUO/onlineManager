package com.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

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
		if (org.apache.commons.collections.CollectionUtils.isEmpty(list))
		{
			LOG.info("========" + list);
		}

		list.add("a");
		list.add("b");
		if (CollectionUtils.isNotEmpty(list))
		{
			System.out.println("====" + list);
			LOG.info("========-" + list);
		}

		// reverseArray 倒序
		Object[] array =
		{ 1, 3, 6, 9, 2, 5, 8 };
		CollectionUtils.reverseArray(array);
		LOG.info("========-" + JSON.toJSONString(array));

	}

}
