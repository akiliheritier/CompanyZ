<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.z.domain.EAccountStatus"%>
<%@page import="com.z.domain.User"%>
        
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
                                    User user = (User) session.getAttribute("user");
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

                                    <li class="nav-item">
                                        <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">Upload Profile</button>
                                    </li>



                                    <li class="nav-item">
                                        <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-change-password">Change Password</button>
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

                                    <div class="tab-pane fade profile-edit pt-3" id="profile-edit">

                                        <!-- Profile Edit Form -->
                                        <form action="uploadProfile" method="POST"  enctype="multipart/form-data">
                                            <div class="row mb-3">
                                                <label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Profile Image</label>
                                                <div class="col-md-8 col-lg-9">
                                                   <img src="profile/<%=user.getPhotoId() %>" alt="Profile" >
                                                    <div class="pt-2">
                                                        <input type="file" name="file" class="btn btn-primary btn-sm"/>
                                                        <input type="submit" value="Save" class="btn btn-success btn-sm"/>
                                                    </div>
                                                </div>

                                            </div>
                                        </form><!-- End Profile Edit Form -->

                                    </div>



                                    <div class="tab-pane fade pt-3" id="profile-change-password">
                                        <!-- Change Password Form -->
                                        <form>

                                            <div class="row mb-3">
                                                <label for="currentPassword" class="col-md-6 col-lg-5 col-form-label">Current Password</label>
                                                <div class="col-md-6 col-lg-7">
                                                    <input name="password" type="password" class="form-control" id="currentPassword">
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label for="newPassword" class="col-md-6 col-lg-5 col-form-label">New Password</label>
                                                <div class="col-md-6 col-lg-7">
                                                    <input name="newpassword" type="password" class="form-control" id="newPassword">
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label for="renewPassword" class="col-md-4 col-lg-5 col-form-label">Re-enter New Password</label>
                                                <div class="col-md-6 col-lg-7">
                                                    <input name="renewpassword" type="password" class="form-control" id="renewPassword">
                                                    <br><button type="submit" class="btn btn-primary">Change Password</button>
                                                </div>
                                            </div>


                                        </form><!-- End Change Password Form -->

                                    </div>

                                </div><!-- End Bordered Tabs -->

                            </div>
                        </div>

                    </div>
                </div>
            </section>

        </main>