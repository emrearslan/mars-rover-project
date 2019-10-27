package com.ea.marsRover.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String var1, Object[] var2) {
        return messageSource.getMessage(var1, var2, LocaleContextHolder.getLocale());
    }
}
