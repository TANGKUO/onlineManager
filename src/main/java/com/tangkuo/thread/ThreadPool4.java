package com.tangkuo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.tangkuo.vo.UserInfo;

/**
 * 
 * @ClassName: ThreadPool2
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 唐阔
 * @date 2017年5月14日 下午2:51:13
 * 
 */
public class ThreadPool4
{
	private static final Logger LOG = LoggerFactory.getLogger(ThreadPool.class);
	private static final int nThreads = 3;// 线程池中最大线程数,可以读取配置文件优化
	private static final UserInfo userInfo = new UserInfo();

	public static void main(String[] args)
	{

		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(nThreads);
		final List<Future<String>> resultList = new ArrayList<Future<String>>();
		int number = 5;// 发起多线程次数,具体业务中符合指定条件的值

		CountDownLatch cdl = new CountDownLatch(number);// 多线程计数器
		for (int i = 0; i < number; i++)
		{
			final Future<String> future = fixedThreadPool.submit(new MyCallable4(userInfo, cdl));
			resultList.add(future);

		}
		LOG.info("========================================");
		try
		{
			cdl.await();// 等待线程结束
		} catch (InterruptedException e1)
		{
			e1.printStackTrace();
		} finally
		{

		}
		List<String> list = new ArrayList<String>();
		// 遍历任务的结果
		for (Future<String> fs : resultList)
		{
			try
			{
				while (!fs.isDone())
					;// Future返回如果没有完成，则一直循环等待，直到Future返回完成
				LOG.info(fs.get()); // 打印各个线程（任务）执行的结果
				list.add(fs.get());
				// cdl.toString();
				// cdl.countDown();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			} catch (ExecutionException e)
			{
				e.printStackTrace();
			} finally
			{
				// 启动一次顺序关闭，执行以前提交的任务，但不接受新任务
				fixedThreadPool.shutdown();
			}
		}

		LOG.info("=======list:" + JSON.toJSONString(list));
	}

}
