package com.greensnow25.dao.logInOut;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Public class LogOutTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 26.09.2017.
 */
public class LogOutTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;

    private ArgumentCaptor<String> captor;
    @InjectMocks
    private LogOut logOut;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.captor = ArgumentCaptor.forClass(String.class);
        this.logOut = new LogOut();
    }

    /**
     * when user session exist then call method session.invalidate once.
     *
     * @throws ServletException ex.
     * @throws IOException      ex.
     */
    @Test
    public void whenCookieExistThenCallOnce() throws ServletException, IOException {
        Cookie cookie = new Cookie("user", "some value.");
        Cookie[] cookies = new Cookie[1];
        cookies[0] = cookie;
        when(request.getCookies()).thenReturn(cookies);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(captor.capture())).thenReturn(dispatcher);
        when(request.getSession(false)).thenReturn(session);
        doNothing().when(session).invalidate();
        logOut.doPost(request, response);
        verify(session, times(1)).invalidate();

        assertThat("WEB-INF/login/login.jsp", is(captor.getValue()));
    }

    /**
     * when user session not exist then never call method session.invalidate.
     *
     * @throws ServletException ex.
     * @throws IOException      ex.
     */

    @Test
    public void whenThen() throws ServletException, IOException {
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        Cookie cookie = new Cookie("anotherUser", "some value.");
        Cookie[] cookies = new Cookie[1];
        cookies[0] = cookie;
        when(request.getCookies()).thenReturn(cookies);
        when(request.getRequestDispatcher(captor.capture())).thenReturn(dispatcher);
        logOut.doPost(request, response);

        verify(session, never()).invalidate();

        assertThat("WEB-INF/login/login.jsp", is(captor.getValue()));
    }
}