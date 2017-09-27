package com.greensnow25.filter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.io.IOException;


import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Public class AuthorizationFilterTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.09.2017.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(AuthorizationFilter.class)
public class AuthorizationFilterTest {
    /**
     * mock class.
     */
    @Mock
    private HttpServletRequest request;
    /**
     * mock class.
     */
    @Mock
    private HttpServletResponse response;
    @Mock
    private FilterChain chain;
    @InjectMocks
    private AuthorizationFilter filter;

    @Before
    public void beforeThTest() {
        MockitoAnnotations.initMocks(this);
        this.filter = new AuthorizationFilter();
    }

    @Test
    public void whenThen() throws IOException, ServletException {
        Cookie[] cookies = new Cookie[1];
        cookies[0] = new Cookie("user", "value");
        HttpSession session = mock(HttpSession.class);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        FilterChain fi = mock(FilterChain.class);
        when(request.getCookies()).thenReturn(cookies);
        when(request.getSession()).thenReturn(session);
        when(session.isNew()).thenReturn(true);

        doNothing().when(chain).doFilter(request, response);
        filter.doFilter(req, resp, fi);
        //filter.doFilter(request, response, chain);
        verify(chain, times(1)).doFilter(request, response);
    }
}