package com.varelait.springEmployeeDB;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionOperations;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
//@EnableJdbcHttpSession
public class SessionConfig {

    /*
    private final DataSource dataSource;
    private final PlatformTransactionManager transactionManager;

    public SessionConfig(DataSource dataSource, PlatformTransactionManager transactionManager) {
        this.dataSource = dataSource;
        this.transactionManager = transactionManager;
    }

    @Bean
    public JdbcIndexedSessionRepository personalSessionRepository() {
        JdbcOperations jdbcOperations = new JdbcTemplate(dataSource);
        TransactionOperations transactionOperations = new TransactionTemplate(transactionManager);
        return new JdbcIndexedSessionRepository(jdbcOperations, transactionOperations);
    }
    */
}
