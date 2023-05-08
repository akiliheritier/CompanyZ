<%-- 
    Document   : nidaValidator
    Created on : 07-May-2023, 18:14:21
    Author     : akili.heritier
--%>

<%@page import="com.z.viewmodel.RegisterViewModel"%>
<%@page import="com.z.domain.User"%>
<%@page import="com.z.service.UserService"%>
<%@page import="com.z.api.client.NidaDataResponse"%>
<%@page import="com.z.api.client.Data"%>
<%@page import="com.z.api.client.NidaClient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="user" scope="request" class="com.z.domain.User">
    <jsp:setProperty name="user" property="*"/>
</jsp:useBean>

<jsp:useBean id="registerVm" scope="request" class="com.z.viewmodel.RegisterViewModel">
    <jsp:setProperty name="registerVm" property="*"/>
</jsp:useBean>
<%
    
    //RegisterViewModel regView=new RegisterViewModel();
    //out.println(user.getNationalId());
    //out.println(registerVm.getTypedPassword());
    //out.println(registerVm.getConfirmedPassword());
    registerVm.isUserValid(user,registerVm);


%>

<jsp:forward page="register.jsp"/>
