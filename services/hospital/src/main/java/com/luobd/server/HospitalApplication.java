package com.luobd.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.luobd.server")
public class HospitalApplication {
    public static void main( String[] args )
    {
        SpringApplication.run(HospitalApplication.class,args);
    }
}
