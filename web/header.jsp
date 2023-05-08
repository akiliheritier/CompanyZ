<%@page import="com.z.domain.EAccountStatus"%>
<%@page import="com.z.domain.User"%>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("home");
    }
%>
<header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
        <a href="dashboard" class="logo d-flex align-items-center">
            <img src="assets/img/logo.png" alt="">
            <span class="d-none d-lg-block">Company Z</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <div class="search-bar">
        <form class="search-form d-flex align-items-center" method="POST" action="#">
            <input type="text" name="query" placeholder="Search" title="Enter search keyword">
            <button type="submit" title="Search"><i class="bi bi-search"></i></button>
        </form>
    </div><!-- End Search Bar -->

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">

            <li class="nav-item d-block d-lg-none">
                <a class="nav-link nav-icon search-bar-toggle " href="#">
                    <i class="bi bi-search"></i>
                </a>
            </li><!-- End Search Icon-->

            <li class="nav-item dropdown">

                <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                    <i class="bi bi-bell"></i>
                    <span class="badge bg-primary badge-number">4</span>
                </a><!-- End Notification Icon -->



            </li><!-- End Notification Nav -->

            <li class="nav-item dropdown">

                <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                    <i class="bi bi-chat-left-text"></i>
                    <span class="badge bg-success badge-number">3</span>
                </a><!-- End Messages Icon -->



            </li><!-- End Messages Nav -->

            <li class="nav-item dropdown pe-6">

                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">



                    <%
                        if (user.getAccountStatus().equals(EAccountStatus.VERIFIED)) {
                    %>
                    <img src="profile/<%=user.getPhotoId() %>" alt="Profile">
                    <span class="d-none d-md-block"><%=user.getUserFullName().split(" ")[0]%></span>
                    <h6><img src="images/twitter.PNG" alt="Verified" style="width: 30px"></h6>

                    <% } else {
                        if (user.getAccountStatus().equals(EAccountStatus.UNVERIFIED)) {
                    %>
                     <img src="profile/<%=user.getPhotoId() %>" alt="Profile" class="rounded-circle">
                    <span class="d-none d-md-block"><%=user.getUserFullName().split(" ")[0]%></span>
                    <h6><img src="images/inverified.PNG" alt="Unverified" style="width: 30px"></h6>
                    <%
                    } else {
                    %>
                    <img src="profile/<%=user.getPhotoId() %>" alt="Profile" class="rounded-circle">
                    <span class="d-none d-md-block"><%=user.getUserFullName().split(" ")[0]%></span>
                    <h6><img src="images/pending.PNG" alt="Pending" style="width: 30px"></h6>
                    <%
                            }
                        }
                    %>


                </a>
                <!-- End Profile Iamge Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                    <li class="dropdown-header">
                        <h6><%="Hello," + user.getUserFullName()%></h6>


                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="userProfile">
                            <i class="bi bi-person"></i>
                            <span>My Profile</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>



                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="signOut">
                            <i class="bi bi-box-arrow-right"></i>
                            <span>Sign Out</span>
                        </a>
                    </li>

                </ul><!-- End Profile Dropdown Items -->
            </li><!-- End Profile Nav -->

        </ul>
    </nav><!-- End Icons Navigation -->

</header>