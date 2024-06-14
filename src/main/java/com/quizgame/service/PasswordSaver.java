package com.quizgame.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PasswordSaver {
    private Integer password = 1;
    private static PasswordSaver instance;
    private static final Logger logger = LoggerFactory.getLogger(PasswordSaver.class);

    private PasswordSaver() {
    }

    public static synchronized PasswordSaver getInstance() {
        if (instance == null) {
            instance =  new PasswordSaver();
        }
        return instance;
    }

    public Integer getPassword() {
        logger.debug("Get password " + password);
        return password;
    }

    public void setPassword(Integer password) {
        logger.debug("Set password " + password);
        this.password = password;
    }
}
