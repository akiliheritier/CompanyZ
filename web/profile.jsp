<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.z.domain.EAccountStatus"%>
<%@page import="com.z.domain.User"%>

<!DOCTYPE html>
<html lang="en">
    
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Welcome to Company Z</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <jsp:include page="css.jsp"/>
    </head>

    <body>

        <jsp:include page="header.jsp"/>

        <!-- ======= Sidebar ======= -->
        <jsp:include page="siderbar.jsp"/>
        <!-- End Sidebar-->

        <jsp:include page="profileDetails.jsp"/>

        <jsp:include page="footer.jsp"/>

    </body>

</html>