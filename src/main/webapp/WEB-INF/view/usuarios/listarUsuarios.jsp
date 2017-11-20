<%-- 
    Document   : listarSalas
    Created on : 22/10/2017, 15:11:04
    Author     : Eduardo
--%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <tag:dependecias/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Lista de salas</title>
    </head>
    <body>
        <tag:header urlImage=""/>
        
        <div class="container-fluid">
            
            <a href="${pageContext.request.contextPath}/usuarios/cadastrar" 
               class="btn btn-primary"
               role="button" 
               aria-label="Left Align">Cadastrar Usuarios</a>
       
            <hr/>
            
            <c:choose>
                <c:when test="${empty usuarios}">
                    <div class="alert alert-info" role="alert">
                        Nenhum cadastro de usuário foi encontrado
                    </div>
                </c:when>
                <c:otherwise>
                      <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-lg-9 col-md-9 col-sm-7">
                                    <h3 class="panel-title input-sm">Usuários</h3>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive"> 
                            <table class="table table-hover table-striped table-bordered table-md">
                                <thead>
                                    <tr>
                                        <th>
                                            ID
                                        </th>
                                        <th>
                                            Nome
                                        </th> 
                                        <th>
                                            Email
                                        </th> 
                                        <th>
                                            Status
                                        </th> 
                                        <th>
                                            Tipo
                                        </th>  
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${usuarios}" var="u">
                                        <tr>
                                            <td>
                                                <span>${u.id}</span>
                                            </td>
                                            <td>
                                                <span>${u.nome}</span>
                                            </td>
                                            <td>
                                                <span>${u.email}</span> 
                                            </td>
                                            <td>
                                                <span>${u.statusUsuario}</span> 
                                            </td>
                                            <td>
                                                <span>${u.tipoUsuario}</span> 
                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
           
        </div>
    </body>
</html>
