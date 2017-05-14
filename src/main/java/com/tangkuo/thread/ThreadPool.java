package com.tangkuo.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @ClassName: ThreadPool
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 唐阔
 * @date 2017年5月14日 下午2:40:54
 * 
 */
public class ThreadPool
{
	private static final Logger LOG = LoggerFactory.getLogger(ThreadPool.class);

	public static void main(String[] args)
	{
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		final List<String> list = new ArrayList<String>();
		final List<Future<String>> resultList = new ArrayList<Future<String>>();
		for (int i = 0; i < 5; i++)
		{
			final Future<String> future = cachedThreadPool.submit(new Callable<String>()
			{
				public String call() throws Exception
				{
					list.add(new Date() + Thread.currentThread().getName());
					LOG.info(Thread.currentThread().getName() + "   sleep");
					Thread.sleep(5 * 1000);
					return "";
				}
			});
			resultList.add(future);
		}
		LOG.info("========================================");
		// 遍历任务的结果
		for (Future<String> fs : resultList)
		{
			try
			{
				while (!fs.isDone())
					;// Future返回如果没有完成，则一直循环等待，直到Future返回完成
				LOG.info(fs.get()); // 打印各个线程（任务）执行的结果
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			} catch (ExecutionException e)
			{
				e.printStackTrace();
			} finally
			{
				// 启动一次顺序关闭，执行以前提交的任务，但不接受新任务
				cachedThreadPool.shutdown();
			}
		}
		LOG.info("=======list:" + JSON.toJSONString(list));
	}

}
