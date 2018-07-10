package com.example.ex2.datasource;


import com.mysql.cj.jdbc.MysqlDataSource;

public class Database {
    public static MysqlDataSource dataSource = null;

    public static MysqlDataSource getDataSource() {
        if (dataSource == null) {
            dataSource = initialDataSource();
        }
        return dataSource;
    }

    public static MysqlDataSource initialDataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("055090323");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("test1");
        return dataSource;
    }
}

