package com.example.twopc;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.UserTransaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@SpringBootApplication
public class TwopcDemoApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(TwopcDemoApplication.class, args);

        UserTransactionManager utm = new UserTransactionManager();
        utm.init();
        UserTransaction utx = new UserTransactionImp();
        utx.begin();
        try (Connection conn1 = DriverManager.getConnection("jdbc:h2:mem:db1");
             Connection conn2 = DriverManager.getConnection("jdbc:h2:mem:db2")) {
            Statement st1 = conn1.createStatement();
            Statement st2 = conn2.createStatement();
            st1.execute("CREATE TABLE test(id INT PRIMARY KEY, val VARCHAR(20))");
            st2.execute("CREATE TABLE test(id INT PRIMARY KEY, val VARCHAR(20))");
            st1.execute("INSERT INTO test VALUES(1, 'A')");
            st2.execute("INSERT INTO test VALUES(1, 'B')");
            utx.commit();
            System.out.println("2PC Success");
        } catch (Exception e) {
            utx.rollback();
            System.out.println("2PC Rollback");
        }
        utm.close();
    }
} 