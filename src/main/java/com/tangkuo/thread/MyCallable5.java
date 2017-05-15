package com.tangkuo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
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
public class MyCallable5 implements Callable<String>
{
	private static final Logger LOG = LoggerFactory.getLogger(ThreadPool.class);
	CountDownLatch cdl = new CountDownLatch(0);// 多线程计数器
	private ConcurrentLinkedQueue<UserInfo> clq = new ConcurrentLinkedQueue<>();// 队列
	private UserInfo userInfo = new UserInfo();

	public MyCallable5(UserInfo userInfo, CountDownLatch cdl, ConcurrentLinkedQueue<UserInfo> clq)
	{
		this.userInfo = userInfo;
		this.cdl = cdl;
		this.clq = clq;
	}

	public MyCallable5(UserInfo userInfo, CountDownLatch cdl)
	{
		this.userInfo = userInfo;
		this.cdl = cdl;
	}

	@Override
	public String call() throws Exception
	{

		StringBuilder sb = new StringBuilder();
		try
		{
		while (!clq.isEmpty())
		{
			clq.poll();
			//clq.peek();

			LOG.info("====================MyCallable.call is start" + JSON.toJSONString(userInfo));
			sb.append(clq.poll().getAge());
			// LOG.info(Thread.currentThread().getName() + "   sleep");
			TimeUnit.SECONDS.sleep(1);
			LOG.info("====================MyCallable.call is sucess" + sb.toString());
		}
		}
		finally
		{
			cdl.countDown();
			
		}

		return sb.toString();
	}

}
