<%-- 
    Document   : upload
    Created on : 26 Ιουν 2019, 10:51:25 μμ
    Author     : minas
--%>

<%-- 
    Document   : addStudent
    Created on : 17 Ιουν 2019, 10:20:19 πμ
    Author     : minas
--%>
<%-- 
    Document   : addStudent
    Created on : 17 Ιουν 2019, 10:20:19 πμ
    Author     : minas
--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav role="navigation" class="navbar navbar-default">
            <div class="">
                <a href="" class="navbar-brand">Coding Bootcamp</a>
            </div>
            <!--            <div class="navbar-collapse">
                            <ul class="nav navbar-nav">
                                <li><a href="/bootcamp/student">Students</a></li>
                                <li><a href="/trainer">Trainers</a></li>
                                <li><a href="/course">Courses</a></li>
                                <li><a href="/assignment">Assignments</a></li>
                                <li class="active"><a href="/login">Log Out</a></li>
                            </ul>
                        </div>-->
        </nav>

        <form method="post" action="/assignment/upload" enctype="multipart/form-data">
            <input type="file" value="song" name="song"  />
            <input type="submit" value="Upload Song" >

        </form>












        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
