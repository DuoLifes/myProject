package com.connext.test.client;

import com.connext.test.webservice.WeatherInterfaceImpl;
import com.connext.test.webservice.WeatherInterfaceImplService;
public class WeatherClient {
    public static void main(String[] args) {
        WeatherInterfaceImplService   service=new WeatherInterfaceImplService();
        WeatherInterfaceImpl portType=service.getWeatherInterfaceImplPort();
        String result=portType.queryWeather("衡阳");
        System.out.println(result);

    }
}
