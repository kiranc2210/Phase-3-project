# Phase-3-project  -- SPORTY SHOES
E-Commerce application developed for performing Admin and Customer user role operations with respective user interfaces. Application is implemented in two parts:


#################################################################################
1) RESTfull web services: API's build using spring boot are used for handling all the back end operations.
2) Front End: User interfaces designed and developed using JSP  utilising web services for handling appropriate user actions
Features available based on the user role

<b><p style="color:blue; font-size:18px;">Features available based Requirement</p></b>

  <b>ADMIN</b>
  <ul><li>
  Adding products</li>
<li>Updating products</li>
<li>Deleting products</li>
<li>Manage Orders</li></ul>


 <b>CUSTOMER</b>
 <ul>
<li>Registering into System</li>
<li>Login into Website</li>
<li>Updating his/her profile</li>
<li>Adding product to Cart</li>
<li>Updating Deleting the Product</li>
<li>Placing the order</li></ul>


<b>TECHNOLOGIES</b>
<ul>
    <li>Java 8</li>
<li>JSP</li>
<li>CSS3</li>
<li>Swagger2 for API Documentation.</li>
<li>Spring Boot</li>
<li>Hibernate with JPA</li>
<li>MySQL</li>
 <li> Maven</li>
</ul>

<b>Web services project can be found in ("git@github.com:kiranc2210/Phase-3-project.git")<a href="http://localhost:4560/">Sporty-Shoes</a></b>

<p>Navigate to <a href="http://localhost:4560/">http://localhost:4560/</a> The app will automatically reload if you change any of the source files.</p>


<b>>>To open Swagger (interactive) API documentation, navigate your browser to [YOUR-URL]/swagger-ui.html</b>
Click on the Like to redirect to Swagger UI--> <a href="http://localhost:4560/swagger-ui.html">http://localhost:4560/swagger-ui.html</a>



<b>How to Run</b>
<ul>
    
<li>Install MYSQL</li>
<li>Configure datasource in application.properties</li>
<li>cd Sport Shoes</li>
<li>Run mvn install.</li>
<li>Run mvn spring-boot:run.</li>
<li>Spring Boot will import mock data into database by executing data.sql automatically.</li>
<li>The backend server is running on http://localhost:4560/.</li>
</br>
<b>OR</b>

<p><b>Prior Run the below queries for the Admin Login on the MySql Workbentch</b></p>
</br>
<p>CREATE DATABASE sportyshoes;</p>
<p>INSERT INTO sportyshoes.admin_tbl VALUES(1001,"Admin_1001",61162433);</p>

