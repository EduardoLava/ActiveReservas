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
            
            <a href="${pageContext.request.contextPath}/usuarios/cadastro" class="btn btn-info" role="button">
                <span class="glyphicon glyphicon-plus" aria-hidden="true">Cadastrar Usuários</span></a>
           
            <hr/>
            
            <c:choose>
                <c:when test="${empty usuarios}">
                    <div class="alert alert-info" role="alert">
                        Nenhum cadastro de usuário foi encontrado
                    </div>
                </c:when>
                <c:otherwise>
                     <table class="table table-striped table-hover">
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
                </c:otherwise>
            </c:choose>
           
        </div>
    </body>
</html>
