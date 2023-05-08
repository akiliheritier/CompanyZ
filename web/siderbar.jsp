<%@page import="com.z.domain.ERole"%>
<%@page import="com.z.domain.User"%>
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="dashboard">
          <i class="bi bi-grid"></i>
          <span>Dashboard</span>
        </a>
      </li><!-- End Dashboard Nav -->

      
      <%
         User u=(User)session.getAttribute("user");
         if(u!=null){
             if(u.getRole().equals(ERole.ADMIN)){
      %>
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-layout-text-window-reverse"></i><span>Users</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          
          <li>
            <a href="users">
              <i class="bi bi-circle"></i><span>User Accounts</span>
            </a>
          </li>
        </ul>
      </li>

   <% }} %>

      <li class="nav-heading">ShortCut</li>

      <li class="nav-item">
        <a class="nav-link collapsed" href="userProfile">
          <i class="bi bi-person"></i>
          <span>My Profile</span>
        </a>
      </li>
 

    </ul>

  </aside>