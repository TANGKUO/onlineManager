package com.tangkuo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.tangkuo.vo.UserInfo;

/**
 * 
 * @ClassName: MyCallable
 * @Description: TODO(多线程业务实现层)
 * @author 唐阔
 * @date 2017年5月14日 下午2:48:41
 * 
 */
public class MyCallable4 implements Callable<String>
{
	private static final Logger LOG = LoggerFactory.getLogger(ThreadPool.class);
	CountDownLatch cdl = new CountDownLatch(1);// 多线程计数器
	private UserInfo userInfo = new UserInfo();

	public MyCallable4(CountDownLatch cdl)
	{
		this.cdl = cdl;
	}

	public MyCallable4(UserInfo userInfo, CountDownLatch cdl)
	{
		this.userInfo = userInfo;
		this.cdl = cdl;
	}

	@Override
	public String call() throws Exception
	{
		userInfo.setAge(Integer.parseInt(String.valueOf(cdl.getCount())));
		userInfo.setUserName(Thread.currentThread().getName());
		userInfo.setUserId(Thread.currentThread().getId());
		userInfo.setEmailAddress(Thread.currentThread().getThreadGroup().getName());

		LOG.info("====================MyCallable.call is start" + JSON.toJSONString(userInfo));
		String str = Thread.currentThread().getName();
		LOG.info(Thread.currentThread().getName() + "   sleep");
		TimeUnit.SECONDS.sleep(1);
		LOG.info("====================MyCallable.call is sucess");
		cdl.countDown();
		return str;
	}
}
