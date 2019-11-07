package com.ea.marsRover.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

@SpringBootTest(classes = MessageService.class)
public class MessageServiceTest {

    @InjectMocks
    private MessageService messageService;

    @Mock
    private MessageSource messageSource;

    @Test
    public void shouldGetMessage() {
        Mockito.when(messageSource.getMessage(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn("message");
        String result = messageService.getMessage("message.general.test", null);

        Assertions.assertEquals(result, "message");
    }

}