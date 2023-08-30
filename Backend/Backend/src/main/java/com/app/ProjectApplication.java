package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProjectApplication {
//	private static 	ApplicationContext applicationContext;
	public static void main(String[] args) {
		// applicationContext=
		SpringApplication.run(ProjectApplication.class, args);
//	String arr[]=applicationContext.getBeanDefinitionNames();
//	int cnt=0;
//	for(int i=0;i<arr.length;i++)
//	{
//		System.out.println(arr[i]);
//		cnt++;
//	}
//	System.out.println("Number of beans are : " +cnt);
//		
	}

}
