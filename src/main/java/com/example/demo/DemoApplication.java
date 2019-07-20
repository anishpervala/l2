package com.example.demo;

import com.example.demo.client.CacheClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		CacheClient c = context.getBean(CacheClient.class);


		//You'd wanna see if this is being called from cache, when the size is exceeded.
		//TEST-only via main application: ignorable
		for (int i =0; i<2; i++) {
			System.out.println(c.get("STRA"));
			System.out.println(c.get("STRB"));
			System.out.println(c.get("STRC"));
			System.out.println(c.get("STRD"));
			System.out.println(c.get("STRE"));
			System.out.println(c.get("STRF"));
			System.out.println(c.get("STRG"));
			System.out.println(c.get("STRH"));
			System.out.println(c.get("STRI"));
			System.out.println(c.get("STRJ"));
			System.out.println(c.get("STRK"));
			System.out.println(c.get("STRL"));
			System.out.println(c.get("STRM"));  //Null values as well
		}
	}
}
