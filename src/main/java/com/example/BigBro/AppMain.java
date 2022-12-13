package com.example.BigBro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class AppMain extends SpringBootServletInitializer {
        static final Logger log = LoggerFactory.getLogger(BigBroApplication.class);
    public static void main(String[] args) throws TelegramApiException {
            log.info("before starting");
        SpringApplication.run(AppMain.class, args);
            log.info("SpringApp is starting");
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            log.info("telegram api is starting");
        try {

            telegramBotsApi.registerBot(new BigBroApplication());
            log.info("telegram api register bot");
        } catch (TelegramApiException e) {

            e.printStackTrace();

        }
    }
}
