package com.greensnow25.Bot.Client;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * public class BotClientTest.
 *
 * @author greensnow25.
 * @version 1.
 * @siense 08.03.17.
 */
public class BotClientTest {

private final String SEP = System.getProperty("line.separator");

//    public void runClient(String input, String expected) throws Exception {
//
//        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        Socket socket = mock(Socket.class);
//        when(socket.getInputStream()).thenReturn(in);
//        when(socket.getOutputStream()).thenReturn(out);
//        BotClient client = new BotClient(socket);
//
//        client.runClient();
//
//        assertThat(out.toString(), is(expected));
//
//    }
//
//    @Test
//
//    public void whenEnterQuitThenQuitTheProgram() throws Exception {
//        String input = String.format("quit%s",SEP);
//        String expected = String.format("");
//        this.runClient(input,expected);
//    }

}