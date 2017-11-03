<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <tag:dependecias/>
    </head>
    <body>
        <div class="container">
            <div class="col-md-4 col-lg-4 col-sm-12 col-lg-offset-4 col-md-offset-4" style="margin-top: 50px">
                <div class="panel panel-default">
                    <div class="panel-heading"><h3 class="panel-title"><strong>Login</strong></h3></div>
                    <div class="panel-body">
                        <c:if test="${param.error ne null}">
                            <div style="color: red">Login ou Senha Inválidos.</div>
                        </c:if>
                        <form action="${pageContext.request.contextPath}/login" method="post">
                            <div class="form-group">
                                <label for="username">Login:</label> <input type="text"
                                                                            class="form-control" id="username" name="username">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Senha:</label> <input type="password" 
                                                                       class="form-control" id="pwd" name="password">
                            </div>

                            <button type="submit" class="btn btn-success">Login</button>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>