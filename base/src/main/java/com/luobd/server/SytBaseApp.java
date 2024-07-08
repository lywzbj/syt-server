package com.luobd.server;


import com.luobd.server.tool.CodeGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(basePackages = "com.luobd.server")
@EnableDiscoveryClient
public class SytBaseApp
{
    public static void main( String[] args )  {
        SpringApplication.run(SytBaseApp.class,args);

    }

    private static void generator() {
        CodeGenerator.classPackage = "com.luobd.server.base.business";

        CodeGenerator.projectDir = "\\base";

        CodeGenerator.url = "jdbc:mysql://localhost:3306/syt_base?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC";


        try {
            CodeGenerator.execute();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
