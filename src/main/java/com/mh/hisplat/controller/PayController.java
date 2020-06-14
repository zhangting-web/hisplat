package com.mh.hisplat.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.mh.hisplat.bean.Register;
import com.mh.hisplat.service.RegisterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Controller
public class PayController {
    /**
     * 金钱类型
     */
    //private BigDecimal bigDecimal=new  BigDecimal();
    private final String APP_ID = "2016102400748436";
    private final String APP_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCmGNDlPk1ofZKKp+8855/WBzAXFrOtQO1rUU+QgjF1HEj/jgBOIdfFW9Wyd29Iu0FRnkTc9QZX82wJyjmygZ3BowGsArC9Ur7tjhtzS7ifH/8kUraDIm7oHwXTaypMUmz3gV+CqRG0LPViWX9j8RsbkeNOL57t6VssUt1OyR26an9KLfNSONw/KYoz9/basSt32cFjXqaZ6IgjMIIRkfOJl0dxG3Ohgibe2v3JBsWg7Jp9aZobUHEaQJeyMozUcKlA/lPpifGFTZ4EzB49DTYGfjWK8jUW2c2/76GWLg+VvujURZr3g/r7SOJFgM9EAjiwjRo4kojbfI5F+9ZgZ6pTAgMBAAECggEBAIniTgAQsWgN3ooWkUcpLYoam3R/Vxd7r9yIOpnHStFicsMbmetCswHWk9c8yPhC4x2jWp1nFyYKIOUbqLwkV9b4wBmQfjIcr/07HFShRplqkX8Q3wyLmDBAGLEC5LFJN8Zb8vLf8Z92Nxq3G0bXT96aRG2SoMf2EccA31FZKcGm7/r2dwRg2CLn896xPlLyPt+KVFlVy4tR5ARGJ3zKTSJcOevYfPJVYn8dG+ScgtLzIUA0TDhVvG0eviBCHALMe733K0bGCvs0NMafrDrypuJfiqAvxGxTXMBXYaLHW50QmbkSfEYrEAKDpgM5jQy1rS735PUpOSE+X2xGtegVtdkCgYEA6gL6SVdOwm/00B0sVxYhoP1VIZhZ9THjwqR6zafIRovJJUVSvlGZbXpnNikP6+pLNk8ex/ZmUhbAnWGP4UgkLnxm4p1faV+YGIHOKUtl8iyLNmrLo2nmxVMzxArZWgxw70Ux7GZfuzbgGwVIgWF+HA8UFnqpcRvIhk+kt2vOwAcCgYEAtbQv9fzt1aNU+XMY04p+JoMmz+mczBcjqnYctBWIcvv2s9n2tuOp0V1DojLzge0l4u4R2GUPNyAE01qWGvRnjVtoB4FSdW68nNxl7drJExHhgaWJ9ZrTMNYndKPktBXHs3yj07fWbymaAkuh+SXaMtP51zzIX9knFLc3UOBk2FUCgYEApvcI7VtF7qVC31pxUJGR3PPj0dyKEtBN2YrRs/qKgwspsVYM+43tEpfLHHGf0ouQrmc1Zyb/SoLBW4lIx0xZxHEuV3JBqUVzl8jF9+C8FFaD3YfFVAszhIcg4Dd9bSqDSbTtMea5VzKII79ZRDbza8G2a3OJghJ4uJwKwnRBR/ECgYBcgA1GaetdrddtYeWKk19jFbMlduTmlQUIGzbDio67En/l0Rkiw8VImvT6VnvWcbauzslw4wma44bxXZU6xZ8NvDG6WGB0/dmw9RZCvvVL6vdk+7O+v4Gxw+O0IlckQk42lkYEWvsj/ga0EnKzlkx9QaJXq07KVI7rodXcK0/LPQKBgQC401hDt1wYYTPjeiOsyVzy8D164kzMA32jYYvge3Op7d6dbmf/89aTDvepx2kht60zRPXkNmkHaEg5lP+RH/NK8BcTiNztDLbC1NflWGBP1KMqbIXgapyQE65Y6pxSSUzXDJZtLO8ulYshtPBuVjUtf5HJ4E3kgDUvY+amS5MsUA==";
    private final String CHARSET = "UTF-8";
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvrlS5Kd8klJo4Z/DVbDPvxpSF3qezYbS6qwoYoCD74n+BVxO18Mnha1elsNgH0EPKJhUdI60wqCMKlOS8QbNyTiSIDy6D6GvYxUH//D8e+a5PkN1lldUvZMgIV4u1rLnhLBo7dliWRVd1cPReNGo7C4h5z7KQSkOL8B0QMDJJDLJbEjfPL+NgVvpMtVJyILN1jMTNvWho8DIKSI6IltYzp09UL1P9QNzWbHil8mxYpMnDE5cAV2Nwer34W9AhuhwAH0ATMUlt6nMM5ZpXazP1RMpQqpudLfKOccRs4XEYo3I++GEdRewPQjYaVMONGf8uHBibSO2EUpkPyDG7jHKswIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://公网地址/notifyUrl";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://localhost:8080/returnUrl";
    @Autowired
    private RegisterService registerService;
    @RequestMapping("alipay/{Id}")
    public void alipay( @PathVariable String  Id,HttpServletResponse httpResponse) throws IOException {
         //预约挂号的id
        if(StringUtils.isBlank(Id)){
            return;
        }
        Register register=new Register();
        register.setId(Id);
        register=registerService.getById(register);
        if(null==register){
            return;
        }
        Random r = new Random();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no =register.getId();
        //register.getDocId();医生级别>级别对应的挂号费
        //付款金额，必填
        String total_amount = "20";
        //订单名称，必填
        String subject = "请支付挂号费";
        //商品描述，可空
        String body = register.getDocName()+"医生挂号费"+total_amount+"元";
        request.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }
    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);

            //支付成功，修复支付状态
            registerService.updaterStateById(out_trade_no);
        //    payService.updateById(Integer.valueOf(out_trade_no));
            return "ok";//跳转付款成功页面
        }else{
            return "no";//跳转付款失败页面
        }

    }
}

