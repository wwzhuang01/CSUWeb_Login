package com.example.loginpro.utils;

import com.zhenzi.sms.ZhenziSmsClient;

import java.util.HashMap;
import java.util.Map;

public class PhoneUtil {
    //这里我是个人开发者，使用这个apiUrl
    static String apiUrl = "https://sms_developer.zhenzikj.com";
    static String appId = "***REMOVED***";
    static String appSecret = "***REMOVED***";
    public static ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);

    public static String sendCode(String number,String style,String code) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        //首先传入我们要发送的手机号

        // 只有一个短信模板，我们可以直接使用下面的代码绑定一个固定的模板
        params.put("templateId", "7636");

        // 这里设置刚才模板中留出来的两个参数的位置，在我的模板里是验证码和有效时间
        String[] templateParams = new String[2];
        // 传入验证码和有效时间
        templateParams[0] = code;
        templateParams[1] = "5分钟";
        // 把参数放入map中
        params.put("templateParams", templateParams);
        //调用send方法，进行发送
        String result = PhoneUtil.client.send(params);
        // 这里返回json格式的字符串，可以判断是否发送成功
        return result;
    }
    public static String generateTelCode(int length) {
        String s = "0123456789";
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length) {
            // 0 ~ s.length()-1
            int index = (new java.util.Random()).nextInt(s.length());
            // 处理重复字符：每个新的随机字符在 sb 中使用indexOf()查找下标值，-1为没找到，即不重复
            Character ch = s.charAt(index);
            if (sb.indexOf(ch.toString()) < 0) {
                sb.append(ch);
            }
        }
        System.out.println("产生随机动态码：" + sb.toString());
        return sb.toString();
    }

}
