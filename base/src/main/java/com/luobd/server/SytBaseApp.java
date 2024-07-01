package com.luobd.server;


import com.luobd.server.tool.CodeGenerator;

public class SytBaseApp
{
    public static void main( String[] args ) throws ClassNotFoundException {


        CodeGenerator.classPackage = "com.luobd.server.base.business";

        CodeGenerator.projectDir = "\\base";

        CodeGenerator.url = "jdbc:mysql://localhost:3306/syt_base?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC";


        CodeGenerator.execute();



    }
}
