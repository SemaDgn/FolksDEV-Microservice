package com.library.libraryservice;

import com.library.libraryservice.client.RetreiveMessageErrorDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class LibraryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
	}
/*
 Case 1: yaratılan kütüphaneye ait book yoksa detaylı hata mesajı donurulmesı.
Feig Client Error Handling
	@Bean
	public ErrorDecoder errorDecoder(){
		// Spring Context bizim yaratıığımız  eror yapısını kullansınn dte burada onu bean olarak tanıtıyoruz.
		return  new RetreiveMessageErrorDecoder();
	}
	@Bean
	Logger.Level feignLoggerLEvel()
	{
		return Logger.Level.FULL;
	}

 */
	// Case 2: yaratılan kütüphaneye ait bu book tanımlanmamıssa o zaman git bu book tanımla.
	//Resillince4j dependency kullarak.

}
