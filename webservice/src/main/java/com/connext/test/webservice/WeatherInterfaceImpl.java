package com.connext.test.webservice;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class WeatherInterfaceImpl implements WeatherInterface {

    public String queryWeather(String cityName) {
        System.out.println("接收到客户端发送的城市名称:"+cityName);
        String result="晴,高温预警";
        return result;
    }



    public static void main(String[] args) {
        //发布服务
        Endpoint.publish("http://localhost:8080/weather", new WeatherInterfaceImpl());
        System.out.println("发布成功");
    }
}
