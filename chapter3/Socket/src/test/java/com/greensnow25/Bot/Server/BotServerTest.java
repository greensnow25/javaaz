package com.greensnow25.Bot.Server;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * public class BotServerTest.
 *
 * @author greensnow25.
 * @version 1.
 * @siense 07.03.17.
 */

public class BotServerTest {
    /**
     * line separator.
     */
   private static final String SEP = System.getProperty("line.separator");

    /**
     * method template for testing.
     * @param input line.
     * @param result expected result.
     * @throws Exception ex.
     */
    public void runServer(String input, String result) throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Socket socket = mock(Socket.class);
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        BotServer botServer = new BotServer(socket);

        botServer.runServer();

        assertThat(out.toString(), is(result));
    }

    /**
     * The method teaches the client's request to the server
     * @throws Exception ex.
     */
    @Test
    public void whenEnterExitThenExecuitQuit() throws Exception {
        String input = String.format("quit%s",SEP);
        String result = String.format("Hello%s", SEP);
        this.runServer(input,result);

    }
    /**
     * The method teaches the client's request to the server
     * @throws Exception ex.
     */
    @Test
    public void whenEnterLineThenRturnRandomFraze() throws Exception {
        String input = String.format("Hello%sFriend%squit",SEP, SEP, SEP);
        String result = String.format("Hello%show are you%sSmart Bot%s", SEP,SEP,SEP);
        this.runServer(input,result);
    }



}