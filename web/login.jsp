<%@page import="com.z.domain.Setting"%>
<%@page import="com.z.domain.User"%>
<%@page import="com.z.domain.Country"%>
<%@page import="java.util.List"%>
<%@page import="com.z.viewmodel.LoginViewModel"%>
<jsp:useBean id="loginVm" scope="request" class="com.z.viewmodel.LoginViewModel">
    <jsp:setProperty name="loginVm" property="*"/>
</jsp:useBean>
<!DOCTYPE html>
 <%
            LoginViewModel login = new LoginViewModel();
            login.init();
//            List<Country> l = lo.getCountriesList();
//            for (Country co : l) {
//                out.println(co.getCountryName());
//            }
//
//            List<User> l2 = lo.getUsersList();
//            for (User co : l2) {
//                out.println(co.getUserFullName());
//            }
 

        %>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Welcome to <%=login.getMetaData().getApp_title() %></title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <jsp:include page="home_header.jsp"/>
    </head>

    <body>
      
        <main>
            <div class="container">

                <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5 col-md-6 d-flex flex-column align-items-center justify-content-center" style="">

                                <div class="d-flex justify-content-center py-4">

                                </div>
                                <div class="card mb-3">

                                    <div class="card-body">



                                        <div class="pt-4 pb-2">

                                            <h5 class="card-title text-center pb-0 fs-4">

                                                <a href="home">

                                                    <img src="assets/img/logo.png" alt="" >
                                                </a>
                                                <%=login.getMetaData().getApp_title() %></h5>
 
 <center> <p class="text-center"><h5>Hello! Provide Valid Credentials</h5></p>
  ${loginVm.message}
 </center>
                                        </div>
                                               

                                                <form action="loginAction" method="POST" class="row g-3 needs-validation" novalidate>

                                            <div class="col-12">
                                                <label for="yourUsername" class="form-label">Username</label>
                                                <div class="input-group has-validation">
                                                     <input type="text" name="username"  class="form-control" id="yourUsername" required="">
                                                    <div class="invalid-feedback">Please enter your username.</div>
                                                </div>
                                            </div>

                                            <div class="col-12">
                                                <label for="yourPassword" class="form-label">Password</label>
                                                <input type="password" name="password" class="form-control" id="yourPassword" required="">
                                                <div class="invalid-feedback">Please enter your password!</div>
                                            </div>

                                            <div class="col-12">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="checkbox" name="remember" value="true" id="rememberMe">
                                                    <label class="form-check-label" for="rememberMe">Remember me</label>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <div class="col-6" style="float: left;">
                                                    <button class="btn btn-success w-90" type="submit">Sign In</button>
                                                </div>
                                                <div class="col-6" style="float: right;">
                                                    <button class="btn btn-warning w-90" style="float: right;" type="submit">Reset Password</button>
                                                </div>
                                                 
                                            </div>

                                            <div class="col-12">
                                                <p class="small mb-0">Don't have account? <a href="registration">Sign Up Now!</a></p>
                                            </div>
                                        </form>

                                    </div>
                                </div> 

                            </div>
                        </div>
                    </div>

                </section>

            </div>
        </main><!-- End #main -->

        <jsp:include  page="home_footer.jsp"/>

    </body>

</html>