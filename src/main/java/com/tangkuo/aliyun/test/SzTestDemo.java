package com.tangkuo.aliyun.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
/**
 *  AppKey：24765914     AppSecret：6cde05a0fd65af6e9366a534a2f36027 复制
	AppCode：45d0a8c0ba9f4863b35f8dd4d0efcb57
 * @author 61650
 *
 */
public class SzTestDemo {
	public static void main(String[] args) {
		String host = "https://yhk.market.alicloudapi.com";
		String path = "/rest/160601/ocr/ocr_bank_card.json";
		String method = "POST";
		//你自己的AppCode
		String appcode = "45d0a8c0ba9f4863b35f8dd4d0efcb57";
		Map<String, String> headers = new HashMap<String, String>();
		// 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
		// 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);
		// 根据API的要求，定义相对应的Content-Type
		headers.put("Content-Type", "application/json; charset=UTF-8");
		Map<String, String> querys = new HashMap<String, String>();
		String bodys = "{\"inputs\":[{\"image\":{\"dataType\":50,#50表示image的数据类型为字符串\"dataValue\":\"base64_image_string\"#图片以base64编码的string}}]}";

		try {
			/**
			 * 重要提示如下: HttpUtils请从
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
			 * 下载
			 *
			 * 相应的依赖请参照
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
			 */
			HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
			System.out.println(response.toString());
			// 获取response的body
			// System.out.println(EntityUtils.toString(response.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
