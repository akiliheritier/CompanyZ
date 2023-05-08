<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="com.z.viewmodel.LoginViewModel"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.z.domain.EAccountStatus"%>
<%@page import="com.z.domain.User"%>
<%
    LoginViewModel loginView = new LoginViewModel();
    loginView.init();
    List<User> usersList = loginView.getUsersList();
%>
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

        <main id="main" class="main">

            <div class="pagetitle">
                <h1>Data Tables</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="dashboard">Home</a></li>
                        <li class="breadcrumb-item">Tables</li>
                        <li class="breadcrumb-item active">User Accounts</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section">
                <div class="row">
                    <div class="col-lg-12">

                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">User Accounts</h5>

                                <!-- Table with stripped rows -->
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">Names</th>
                                            <th scope="col">Nationality</th>
                                            <th scope="col">ID</th>
<!--                                            <th scope="col">Gender</th>
                                            <th scope="col">Marital Status</th>
                                            <th scope="col">DOB</th>-->
                                            <th scope="col">Status</th>
                                            <th scope="col">Action</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% long counter=1;
                                           for(User u:usersList){
                                        %>
                                        <tr>
                                            <th scope="row"><%=counter++ %></th>
                                            <td><%=u.getUserFullName() %></td>
                                            <td><%=u.getNationality().getCountryName() %></td>
                                            <td><%=u.getNationalId()%></td>
<!--                                            <td><%=u.getGender()%></td>
                                            <td><%=u.getMaritalStatus()%></td>
                                            <td><%=u.getUserDateOfBirth()%></td>-->
                                            <td><%=u.getAccountStatus().getDescription() %></td>
                                            <td>
                                                <form action="verifyProfile" method="POST">
                                                    <input type="hidden" name="id" value="<%=u.getUserId() %>"/>
                                                    <input type="submit" value="View Account" class="btn btn-primary"/>
                                                </form>
                                               
                                                
                                            </td>
                                        </tr>
                                        <% }  %>
                                         
                                    </tbody>
                                </table>
                                <!-- End Table with stripped rows -->

                            </div>
                        </div>

                    </div>
                </div>
            </section>

        </main>

        <jsp:include page="footer.jsp"/>

    </body>

</html>