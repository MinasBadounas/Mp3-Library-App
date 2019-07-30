

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a href="/bootcamp/welcome" class="navbar-brand">Coding Bootcamp</a>
            </div>
            <div></div>
            <form method="post" action="/assignment/upload" enctype="multipart/form-data">
                <input type="file" value="song" name="song"  />
                <input type="submit" class="btn btn-primary" value="Upload Song"  >

            </form>
        </div>
        <div class="navbar-collapse">
            <ul class="nav navbar-nav">

            </ul>
        </div>
    </nav>
    <div class="container">
        <table class="table table-striped ">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Title</th>
                    <th>Album</th>
                    <th>Artist</th>
                    <th>Year</th>
                    <th>Image Album</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${mp3list}" var="list">
                    <tr>
                        <td>${list.id}</td>
                        <td>${list.title}</td>
                        <td>${list.album}</td>
                        <td>${list.artist}</td>
                        <td>${list.yearrelease}</td>
                        <td><img id="profileImage" src="data:image/jpeg;base64,${list.mp3filename}" style="width: 200px; height:200px"/> </td>
                        <td><a type="button" class="btn btn-warning" href="/assignment/lyrics?artist=${list.artist}&title=${list.title}">Lyrics</a></td>             
                        <td><a type="button" class="btn btn-primary" href="/assignment/download?id=${list.id}">Download</a></td>             
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="table" style="border:  1px"></div>
        <h4>${lyrics}</h4>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>



</body>
</html>
