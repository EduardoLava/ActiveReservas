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
                 <table class="table table-bordered table-responsive">
                    <thead>
                        <tr>
                            <th>
                                ID
                            </th>
                            <th>
                                Descrição
                            </th> 
                            <th>
                                Capacidade
                            </th> 
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${salas}" var="s">
                            <tr>
                                <td>
                                    <span>${s.id}</span>
                                </td>
                                <td>
                                    <span>${s.descricao}</span>
                                </td>
                                <td>
                                    <span>${s.capacidade}</span> 
                                </td>
                            </tr>
                        </c:forEach>
                      
                    </tbody>
                </table>
        </div>
    </body>
</html>
