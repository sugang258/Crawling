package com.gang.home;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class crawling {
	
	public void crawl() throws IOException {
		
		String WeatherURL = "https://weather.naver.com/today";
		Document doc = Jsoup.connect(WeatherURL).get();
		
		Elements elements = doc.select(".weather_area .summary .weather");
		
		String[] str = elements.text().split(" ");
		
		System.out.println(str);
		
	}
	
	
	
}
