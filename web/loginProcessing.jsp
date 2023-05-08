<%@page import="com.z.domain.User"%>
<jsp:useBean id="loginVm" scope="request" class="com.z.viewmodel.LoginViewModel">
    <jsp:setProperty name="loginVm" property="*"/>
</jsp:useBean>

<%
       User u=loginVm.loginUser();
       if(u!=null){
            session.setAttribute("user",u);
            response.sendRedirect("dashboard");
       }

%><jsp:include page="home"/>