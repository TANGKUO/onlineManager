package com.tangkuo.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: </p>
 * <p>Description: 权限list</p>
 * <p>Company: www.tk.com</p> 
 * @param <T>  
 * @author   tangkuo
 * @date    2017年3月26日 上午9:27:18
 */
public class AuthList<T> {
	
	private List<T> list = new ArrayList<T>();
	private Map<T,T> map = new HashMap<T,T>();
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Map<T, T> getMap() {
		return map;
	}
	public void setMap(Map<T, T> map) {
		this.map = map;
	}
	
	
	
}
