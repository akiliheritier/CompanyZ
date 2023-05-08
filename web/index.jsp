<%@page import="com.z.domain.ERole"%>
<%@page import="com.z.domain.User"%>
<!DOCTYPE html>
<html lang="en">
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("home");
    }
%>
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Welcome to Company Z</title>
  <meta content="company z official website" name="description">
  <meta content="" name="keywords">

  <jsp:include page="css.jsp"/>
</head>

<body>
   <jsp:include page="header.jsp"/>

  <!-- ======= Sidebar ======= -->
  <jsp:include page="siderbar.jsp"/>
  <!-- End Sidebar-->

  <%
    if(user.getRole().equals(ERole.ADMIN)){
      %>
      
      <jsp:include page="dashboard.jsp"/>
      <%
    }else{
    
    %>
      
    <jsp:include page="profileDetails.jsp"/>
      <%
    }
  %>
  <!-- End #main -->

  <jsp:include page="footer.jsp"/>

</body>

</html>