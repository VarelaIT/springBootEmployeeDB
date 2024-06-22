package com.varelait.springEmployeeDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Slf4j //logger interface annotation
public abstract class LoggerBase {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
}
