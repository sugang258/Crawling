package com.gang.home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrawlingApplication {

	public static void main(String[] args) throws IOException {
		
		
		SpringApplication.run(CrawlingApplication.class, args);
		crawl();
	}
	
	static void crawl() throws IOException {
		
		String WeatherURL = "https://weather.naver.com/today";
		Document doc = Jsoup.connect(WeatherURL).get();
		
		Elements elements = doc.select("#hourly .weather_graph .scroll_control .scroll_area .weather_table_wrap ._cnTimeTable ._cnItemTime");
		
		String[] str = elements.text().split(" ");
		
		System.out.println(str.length);
		for(int i =0;i<str.length;i++) {
			System.out.println(str[i]);
		}
		
		for(Element e : elements.select("i")) {
			System.out.println(e.text());
			if(e.className().equals("blind")) {
				System.out.println("eee" + e.text());
			}
			
		}
		
		
		
//		String[] str = elements.text().split(" ");
//		
//		for(int i =0;i<str.length;i++) {
//			System.out.println(str[i]);
		}
		
//		URL url = new URL("https://weather.naver.com/today");
//		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//		
//		StringBuffer sourceCode = new StringBuffer();
//		
//		String sourceLine = "";
//		while((sourceLine = br.readLine()) != null) {
//			sourceCode.append(sourceLine + "\n");
//		}
//		
	

}
