package com.greensnow25.dao.adminRole;

import com.greensnow25.db.CreateConnection;
import com.greensnow25.db.editVisitior.EditUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;


import static org.mockito.Mockito.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * Public class EditUserServletTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.09.2017.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(EditUserServlet.class)
public class EditUserServletTest {
    @Mock
    private EditUser editUser;
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
    private RequestDispatcher rd;

    private EditUserServlet editUserServlet;

    private ArgumentCaptor<String> captor;

    @Before
    public void setUp() {
        this.editUserServlet = new EditUserServlet();
        this.captor = ArgumentCaptor.forClass(String.class);
    }

    /**
     * when request param operation is not null, then redirect on edit.jsp page.
     *
     * @throws ServletException ex.
     * @throws IOException      ex.
     */
    @Test
    public void whenParamOperationNotNullThenForwardEdit() throws ServletException, IOException {
        when(request.getParameter("operation")).thenReturn("first");
        when(request.getRequestDispatcher(captor.capture())).thenReturn(rd);
        editUserServlet.doPost(request, response);
        verify(rd, times(1)).forward(request, response);
        assertThat(captor.getValue(), is("WEB-INF/jsp/edit.jsp"));

    }

    /**
     * if operation is EDIT_OTHER_USERS. then edit user with param name oldName.
     *
     * @throws Exception sf param oldName != null.
     */
    @Test
    public void whenCallThenEdinAnotherUser() throws Exception {
        when(request.getParameter("operation")).thenReturn(null);
        whenNew(EditUser.class).withAnyArguments().thenReturn(editUser);
        when(request.getParameter("oldName")).thenReturn("oldName");
        Cookie[] cookies = new Cookie[1];
        cookies[0] = new Cookie("user", "someValue");
        when(request.getCookies()).thenReturn(cookies);

        doThrow(new RuntimeException()).when(editUser).editHimSelf(eq("oldName1"), anyString(), anyString());
        when(request.getRequestDispatcher(captor.capture())).thenReturn(rd);
        when(editUser.showAll()).thenReturn(new ArrayList());
        when(request.getSession()).thenReturn(mock(HttpSession.class));

        editUserServlet.doPost(request, response);

        verify(rd, times(1)).forward(request, response);

        assertThat(captor.getValue(), is("WEB-INF/jsp/result/result.jsp"));
    }

    /**
     * if operation is EDIT_HIMSELF. then edit user and throw runtime exception.
     *
     * @throws Exception sf param oldName != null.
     */
    @Test(expected = RuntimeException.class)
    public void whenThen() throws Exception {
        when(request.getParameter("operation")).thenReturn(null);
        whenNew(EditUser.class).withAnyArguments().thenReturn(editUser);
        when(request.getParameter("oldName")).thenReturn(null);
        Cookie[] cookies = new Cookie[1];
        cookies[0] = new Cookie("user", "someValue");
        when(request.getCookies()).thenReturn(cookies);

        doThrow(new RuntimeException()).when(editUser).editHimSelf(eq("someValue"), anyString(), anyString());

        editUserServlet.doPost(request, response);


    }
}