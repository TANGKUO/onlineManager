package com.common.utils;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @ClassName: TestArraysToMap
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 唐阔
 * @date 2017年5月14日 下午1:47:25
 * 
 */
public class TestArraysToMap
{
	private static final Logger LOG = LoggerFactory.getLogger(TestArraysToMap.class);

	@Test
	public void testArraysToMap()
	{
		String user = "{\"age\":0,\"userId\":0,\"userName\":\"tangkuo\"}";
		JSONObject jsObject = JSON.parseObject(user);
		Object age = jsObject.get("age");
		LOG.info("age:" + age.toString());

		String[] user2 = user.substring(1, user.length() - 1).split(",");
		List<String> list = Arrays.asList(user2);
		if (CollectionUtils.isNotEmpty(list))
		{
			for (int i = 0; i < list.size(); i++)
			{
				LOG.info("===" + "第" + i + "个元素 " + list.get(i));
			}
		}

		// JSONArray
	}
}
