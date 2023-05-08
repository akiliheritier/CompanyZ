<%@page import="com.z.service.UserService"%>
<%@page import="com.z.domain.EAccountStatus"%>
<%@page import="java.util.UUID"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="java.util.List"%>
<%@page import="com.z.domain.Setting"%>
<%@page import="com.z.viewmodel.LoginViewModel"%>
<%@page import="com.z.domain.User"%>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("home");
    }
    UserService userService = new UserService();
    LoginViewModel loginVm = new LoginViewModel();
    loginVm.init();
    List<User> users = loginVm.getUsersList();
    final String id = request.getParameter("id");
    final String status = request.getParameter("status");
    out.println(loginVm.getUserService().findAll());
    for (User u : users) {
        if (u.getUserId().equals(UUID.fromString(id))) {
            u.setAccountStatus(EAccountStatus.valueOf(status));
            out.println("<br>"+u.getUserId());
            out.println(userService.updateUser(u));
        }
    }    
    response.sendRedirect("users");
    
%>