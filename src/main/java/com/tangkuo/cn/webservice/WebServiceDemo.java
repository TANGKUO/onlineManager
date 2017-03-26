package com.tangkuo.cn.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

/**
 * <p>Title: </p>
 * <p>Description: @WebService 接口发布 跨平台支持 </p>
 * <p>Company: www.tk.com</p>   
 * @author   tangkuo
 * @date    2017年3月26日 上午10:21:42
 */
@WebService
@SOAPBinding(style=Style.RPC)
public class WebServiceDemo {
	
	@WebMethod
	public String sayHelloWorld(String name){
		System.out.println("" + name);
		return "hello" + name;
	}
	
	public static void main(String[] args) {
		//终端
		String url = "http://localhost:8880/WebServiceDemo";
		Endpoint.publish(url, new WebServiceDemo());//发布webService服务接口
		
	}
}
