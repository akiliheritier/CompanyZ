<%@page import="com.z.service.UserService"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
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

      <main id="main" class="main">

            <div class="pagetitle">
                <h1>Profile</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="dashboard">Home</a></li>
                        <li class="breadcrumb-item">Users</li>
                        <li class="breadcrumb-item active">Profile</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section profile">
                <div class="row">
                    <div class="col-xl-4">

                        <div class="card">
                            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
                                <%
                                    UserService serv=new UserService();
                                    User user =serv.findById(request.getParameter("id"));
                                %>
                                <img src="profile/<%=user.getPhotoId() %>" alt="Profile" >

                                <%
                                    if (user.getAccountStatus().equals(EAccountStatus.VERIFIED)) {
                                %>
                                <br>

                                <h6><%=user.getUserFullName()%><img src="images/twitter.PNG" alt="Verified" style="width: 30px"></h6>

                                <% } else {
                                    if (user.getAccountStatus().equals(EAccountStatus.UNVERIFIED)) {
                                %>
                                <br>

                                <h6><%=user.getUserFullName()%><img src="images/inverified.PNG" alt="Verified" style="width: 30px"></h6>

                                <%
                                } else {
                                %>
                                <br>

                                <h6><%=user.getUserFullName()%><img src="images/pending.PNG" alt="Pending" style="width: 30px"></h6>

                                <%
                                        }
                                    }
                                %>
                                <h6>
                                    <%
                                       Calendar cal1=new GregorianCalendar();
                                        Calendar cal2=new GregorianCalendar(); 
cal2.setTime(user.getUserDateOfBirth());
out.println(cal1.get(Calendar.YEAR)-cal2.get(Calendar.YEAR)+" years Old");
                                    %>
                                </h6>
                                <form action="verifyProfileAction" method="GET">
                                    <%
                                                   List<EAccountStatus>list=Arrays.asList(EAccountStatus.values());
                                                %>
                                                <input name="id" value="<%=user.getUserId() %>" type="hidden"/>
                                                <center>
                                                    <select name="status" class="form-check">
                                                        <% for(EAccountStatus status:list){ %>
                                                        <option value="<%=status %>">
                                                            <%=status.getDescription() %>
                                                        </option>
                                                        <% }  %>
                                                    </select>
                                                    <input type="submit" name="op" value="Confirm This Account" class="btn btn-success" style="" />
                                                    <br><br><br><br>
                                                </center>                
                                </form>
                                 

                            </div>
                        </div>

                    </div>

                    <div class="col-xl-8">

                        <div class="card">
                            <div class="card-body pt-3">
                                <!-- Bordered Tabs -->
                                <ul class="nav nav-tabs nav-tabs-bordered">

                                    <li class="nav-item">
                                        <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">Overview</button>
                                    </li>
 

                                </ul>
                                <div class="tab-content pt-2">

                                    <div class="tab-pane fade show active profile-overview" id="profile-overview">
                                        <h5 class="card-title">Profile Details</h5>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label ">Full Name</div>
                                            <div class="col-lg-9 col-md-8"><%=user.getUserFullName()%></div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Nationality</div>
                                            <div class="col-lg-9 col-md-8"><%=user.getNationality().getCountryName()%></div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">ID</div>
                                            <div class="col-lg-9 col-md-8"><%=user.getNationalId()%></div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Date Of Birth</div>
                                            <div class="col-lg-9 col-md-8"><%=user.getUserDateOfBirth()%> </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Gender</div>
                                            <div class="col-lg-9 col-md-8"><%=user.getGender().getDescription()%></div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Marital Status</div>
                                            <div class="col-lg-9 col-md-8"><%=user.getMaritalStatus().getDescription()%></div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Username</div>
                                            <div class="col-lg-9 col-md-8"><%=user.getUsername()%></div>
                                        </div>

                                    </div>

                                     



                                     

                                </div><!-- End Bordered Tabs -->

                            </div>
                        </div>

                    </div>
                </div>
            </section>

        </main>

        <jsp:include page="footer.jsp"/>

    </body>

</html>