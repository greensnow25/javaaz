package com.greensnow25.dao.adminRole;

import com.greensnow25.db.editVisitior.EditUser;
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
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * Public class EditRoleServletTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 26.09.2017.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = EditRoleServlet.class)
public class EditRoleServletTest {
    /**
     * mock class.
     */
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
    /**
     * mock class.
     */
    @Mock
    private RequestDispatcher rd;
    /**
     * mock class.
     */
    @Mock
    private HttpSession session;
    /**
     * inject mocks.
     */
    @InjectMocks
    private EditRoleServlet servlet;
    /**
     * capture.
     */
    private ArgumentCaptor<String> captor;

    /**
     * before the test.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        servlet = new EditRoleServlet();
        this.captor = ArgumentCaptor.forClass(String.class);
    }

    /**
     * when test call method showAll once, then test is done.
     *
     * @throws ServletException ex.
     * @throws IOException      ex.
     */
    @Test
    public void whenThen() throws ServletException, IOException {
        String userName = "admin";
        String newRole = "newRole";
        try {
            whenNew(EditUser.class).withAnyArguments().thenReturn(this.editUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        when(request.getParameter("userName")).thenReturn(userName);
        when(request.getParameter("newRole")).thenReturn(newRole);
        doNothing().when(editUser).editRole(userName, newRole);

        List l = Arrays.asList("newUser");
        when(editUser.showAll()).thenReturn(l);
        when(request.getSession()).thenReturn(session);

        when(request.getRequestDispatcher(captor.capture())).thenReturn(rd);

        servlet.doPost(request, response);

        verify(editUser, times(1)).showAll();

        assertThat(captor.getValue(), is("WEB-INF/jsp/result/result.jsp"));
    }
}