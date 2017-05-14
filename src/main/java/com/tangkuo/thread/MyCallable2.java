package com.tangkuo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: MyCallable
 * @Description: TODO(多线程业务实现层)
 * @author 唐阔
 * @date 2017年5月14日 下午2:48:41
 * 
 */
public class MyCallable2 implements Callable<String>
{
	private static final Logger LOG = LoggerFactory.getLogger(ThreadPool.class);

	@Override
	public String call() throws Exception
	{
		LOG.info("====================MyCallable.call is start");
		String str = Thread.currentThread().getName();
		LOG.info(Thread.currentThread().getName() + "   sleep");
		// Thread.sleep(5 * 1000);
		TimeUnit.SECONDS.sleep(1);
		LOG.info("====================MyCallable.call is sucess");
		return str;
	}
}
