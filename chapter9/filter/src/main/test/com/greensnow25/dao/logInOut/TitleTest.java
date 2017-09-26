package com.greensnow25.dao.logInOut;

import com.greensnow25.db.ConnectToUsersBase;
import com.greensnow25.db.CreateConnection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Public class TitleTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.09.2017.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Title.class)
public class TitleTest {
    /**
     * mock connect user to base.
     */
    @Mock
    private ConnectToUsersBase connect;
    /**
     * mock create connection.
     */
    @Mock
    private CreateConnection createConnection;
    /**
     * mock request.
     */
    @Mock
    private HttpServletRequest request;
    /**
     * mock response.
     */
    @Mock
    private HttpServletResponse response;
    /**
     * mock requestDispatcher.
     */
    @Mock
    private RequestDispatcher rd;
    /**
     * inject mocks into class object.
     */
    @InjectMocks
    private Title title;
    /**
     * captor.
     */
    private ArgumentCaptor<String> captor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.title = new Title();
        title.setGetConnection(createConnection);
        title.setConnect(connect);
        this.captor = ArgumentCaptor.forClass(String.class);
    }

    /**
     * when call doPost method, then we have two ways.
     * if login and password correct then access is allowed.
     * If this condition is met, then the method hhtpSession.set attribute
     * will not be called.
     *
     * @throws ServletException ex.
     * @throws IOException      ex.
     * @throws SQLException     ex.
     */
    @Test
    public void whenCallDoPostThenOntheLoginPage() throws ServletException, IOException, SQLException {
        when(request.getParameter("login")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("Wrong password.");

        when(connect.login("admin", "admin")).thenReturn(true);

        when(request.getRequestDispatcher(anyString())).thenReturn(rd);

        HttpSession httpSession = mock(HttpSession.class);
        when(request.getSession()).thenReturn(httpSession);

        title.init();
        title.doPost(request, response);
        verify(httpSession, times(0)).setAttribute(anyString(), anyObject());
        verify(httpSession, times(0)).setMaxInactiveInterval(anyInt());
        verify(request, times(1)).getRequestDispatcher(captor.capture());
        assertThat(captor.getValue(), is("WEB-INF/login/login.jsp"));
    }

    /**
     * when call doPost method, then we have two ways.
     * else if login and password not correct then access is denied.
     * If this condition is met, then the method hhtpSession.set attribute
     * will be called four times..
     *
     * @throws ServletException ex.
     * @throws IOException      ex.
     * @throws SQLException     ex.
     */
    @Test
    public void whenCorrectDataThenLoginSuccessful() throws SQLException, ServletException, IOException {

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        when(request.getParameter("login")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("admin");


        when(connect.login("admin", "admin")).thenReturn(true);
        HttpSession httpSession = mock(HttpSession.class);

        when(request.getSession()).thenReturn(httpSession);

        when(request.getRequestDispatcher(anyString())).thenReturn(rd);
        when(connect.checkUserRole(false, "admin")).thenReturn("admin");


        title.init();
        title.doPost(request, response);

        verify(httpSession, times(4)).setAttribute(anyString(), anyObject());
        verify(httpSession, times(1)).setMaxInactiveInterval(anyInt());
        verify(request, times(1)).getRequestDispatcher(captor.capture());
        assertThat(captor.getValue(), is("WEB-INF/login/login.jsp"));
    }

}