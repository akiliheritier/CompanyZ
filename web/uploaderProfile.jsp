<%@page import="com.z.viewmodel.LoginViewModel"%>
<%@page import="com.z.domain.Setting"%>
<%@page import="com.z.domain.User"%>
<%@page import="com.z.uploader.UploadFile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>

<%
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("home");
        }
        LoginViewModel loginVm = new LoginViewModel();
        loginVm.init();
        Setting set = loginVm.getMetaData();

        UploadFile up = new UploadFile();
        up.setFile_key(user.getNationalId());
        up.setRequest(request);
        up.setServer_path(set.getPath() + "/profile/");

        out.println(up.uploadFile());
        if (up.uploadFile().contains("Uploaded Successfully")) {
            user.setPhotoId(up.getServer_file());
        }
        session.setAttribute("user", user);

        response.sendRedirect("userProfile");
    %> 