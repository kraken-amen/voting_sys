package com.projects.voting_system;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EntityScan(basePackages = "com.projects.voting_system.entities")
//@EnableJpaRepositories(basePackages = "com.projects.voting_system.repos")
public class VotingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(VotingSystemApplication.class, args);
    }

}
