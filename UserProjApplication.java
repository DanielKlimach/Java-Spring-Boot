package com.devProjeto.userProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //é uma anotation, é como se fosse métodos prontos para serem utilizados afim de agilizar todo o processo de programação por meio do Java Spring.
//Será amplamente utilizado e existem inúmeras anotartions, esta anotation em específico é para dar a possibilidade de usarmos o JavaSpringBoot
public class UserProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProjApplication.class, args);
	}

}
