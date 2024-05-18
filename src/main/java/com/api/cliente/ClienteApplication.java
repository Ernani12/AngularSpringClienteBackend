package com.api.cliente;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.cliente.model.Cliente;



@SpringBootApplication
public class ClienteApplication  {


	public static void main(String[] args) throws IOException {
		SpringApplication.run(ClienteApplication.class, args);
		openHomePage();
	}

	private static void openHomePage() throws IOException {
		Runtime rt = Runtime.getRuntime();
		rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8081");
	 }

	 
}
