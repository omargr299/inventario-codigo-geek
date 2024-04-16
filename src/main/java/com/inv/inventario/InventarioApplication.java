package com.inv.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.inv.inventario")
public class InventarioApplication {

	public static void main(String[] args) {
		System.out.println(args);
		SpringApplication.run(InventarioApplication.class, args);
	}

}
