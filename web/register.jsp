<%@page import="com.z.domain.Country"%>
<%@page import="java.util.List"%>
<%@page import="com.z.viewmodel.LoginViewModel"%>
<jsp:useBean id="registerVm" scope="request" class="com.z.viewmodel.RegisterViewModel"/>
<jsp:useBean id="user" scope="request" class="com.z.domain.User"/>
<!DOCTYPE html>
<%
    LoginViewModel loginVm = new LoginViewModel();
    loginVm.init();
    List<Country>  countriesList= loginVm.getCountriesList();
           
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

        <title><%=loginVm.getMetaData().getApp_title()%></title>
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
                            <div class="col-lg-5 col-md-6 d-flex flex-column align-items-center justify-content-center">



                                <div class="card mb-3">

                                    <div class="card-body">

                                        <div class="pt-4 pb-2">
                                            <h5 class="card-title text-center pb-0 fs-4">
                                                <a href="home">
                                                    <img src="assets/img/logo.png" alt="" >
                                                </a>
                                                <%=loginVm.getMetaData().getApp_title()%>
                                            </h5>

                                                <center> <p class="text-center"><h5>${registerVm.title}</h5></p>
                                            ${registerVm.message}
                                            </center>
                                        </div>

                                            <form action="nidaValidation" method="POST" class="row g-3 needs-validation" novalidate>
                                            <%
                                               if(!registerVm.isShowUserDetails()){
                                               
                                            %>
                                            <div class="col-12">
                                                <label for="yourID" class="form-label">Your National ID/Passport</label>
                                                <input type="text" name="nationalId" value="${user.nationalId}" class="form-control" id="yourID" required="">
                                                <div class="invalid-feedback">Please, provide your ID or Passport</div>
                                            </div>
                                            <% }else{
 %>
                                            <div class="col-12">
                                                <label for="yourID" class="form-label">Your National ID/Passport</label>
                                                <input type="text" name="nationalId" value="${user.nationalId}" readonly="" class="form-control" id="yourID" required="">
                                                <div class="invalid-feedback">Please, provide your ID or Passport</div>
                                            </div>
                                            <% 
}
                                               if(registerVm.isShowUserDetails()){
                                               
                                            %>
                                            <div class="col-12">
                                                <label for="yourName" class="form-label">Your Name</label>
                                                <input type="text" name="userFullName" readonly="" class="form-control" disabled="" value="${registerVm.names}"  id="yourName" required>
                                                <div class="invalid-feedback">Please, enter your name!</div>
                                            </div>
                                                
                                                <div class="col-12">
                                                <label for="yourName" class="form-label">Gender</label>
                                                <input type="text" name="gender" readonly="" class="form-control" disabled="" value="${registerVm.gender}"  id="yourName" required="">
                                                 
                                            </div>
                                                
                                                
                                                <div class="col-12">
                                                <label for="yourName" class="form-label">Marital Status</label>
                                                <input type="text"  readonly="" class="form-control" disabled="" value="${registerVm.maritalStatus}"  id="yourName" required="">
                                                 
                                            </div>
                                                
                                                 <div class="col-12">
                                                <label for="yourName" class="form-label">Date Of Birth</label>
                                                <input type="text"  readonly="" class="form-control" disabled="" value="${registerVm.dob}"  id="yourName" required="">
                                                 
                                            </div>

                                            <div class="col-12">
                                                <label for="yourEmail" class="form-label">Your Telephone or Email Address</label>
                                                <input type="text" name="username" value="${user.username}" class="form-control" id="yourEmail" required="">
                                                <div class="invalid-feedback">Please enter a valid Email adddress!</div>
                                            </div>

                                            <div class="col-12">
                                                <label for="yourUsername" class="form-label">Nationality</label>
                                                <div class="input-group has-validation">
                                                    <select name="country" class="form-control" disabled="">
                                                        <option>${registerVm.country}</option>
                                                        <%
                                                           for(Country country:countriesList){
                                                        %>
                                                        <option><%=country.getCountryName() %></option>
                                                        <% } %>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="col-12">
                                                <label for="yourPassword" class="form-label">Choose Password</label>
                                                <input type="password" name="typedPassword" value="${registerVm.typedPassword}" class="form-control" id="yourPassword" required="">
                                                <div class="invalid-feedback">Please enter your password!</div>
                                            </div>
                                                
                                                <div class="col-12">
                                                <label for="yourPassword" class="form-label">Confirm Password</label>
                                                <input type="password" name="confirmedPassword" value="${registerVm.confirmedPassword}" class="form-control" id="yourPassword2" required="">
                                                <div class="invalid-feedback">Please enter your password!</div>
                                            </div>

                                            <div class="col-12">
                                                <div class="form-check">
                                                    <input class="form-check-input" name="terms" type="checkbox" value="" id="acceptTerms" required>
                                                    <label class="form-check-label" for="acceptTerms">I agree and accept the <a href="#">terms and conditions</a></label>
                                                    <div class="invalid-feedback">You must agree before submitting.</div>
                                                </div>
                                            </div>
                                                <div class="col-12">
                                                <button class="btn btn-primary w-100" type="submit">Create Account</button>
                                            </div>
                                                <% }else{  %>
                                            <div class="col-12">
                                                <button class="btn btn-primary w-100" type="submit">Get Details</button>
                                            </div>
                                            <% } %>
                                            <div class="col-12">
                                                <p class="small mb-0">Already have an account? <a href="home">Sign In</a></p>
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

        <jsp:include page="home_footer.jsp"/>

    </body>

</html>