package com.tangkuo.vo;

/**
 * 
 * @ClassName: UserInfo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 唐阔
 * @date 2017年5月14日 下午12:48:56
 * 
 */
public class UserInfo
{
	private long userId;
	private String userName;
	private int age;
	private String emailAddress;

	/**
	 * 
	 * @Title: getUserId
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */
	public long getUserId()
	{
		return userId;
	}

	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getEmailAddress()
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

}
