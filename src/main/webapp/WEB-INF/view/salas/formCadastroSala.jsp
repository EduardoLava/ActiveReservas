<%-- 
    Document   : listarSalas
    Created on : 22/10/2017, 15:11:04
    Author     : Eduardo
--%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <tag:dependecias/>
        <link rel="stylesheet" type="text/css" href="../resources/css/style.css"/>
        <title>Cadastro de usuário</title>
        
    </head>
    <body>
        <tag:header urlImage=""/>
        
        <div class="container-fluid ">
            
            <div class="row">
                <div class="col-md-10 col-lg-8 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1">
                  
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            Sala
                        </div>
                        <div class="panel-body ">
                            <form:form method="POST" modelAttribute="sala" action="${pageContext.request.contextPath}/salas/salvar">
                                
                                <form:input class="invisivel" type="number"  path="id"/>
                                <form:input class="invisivel" type="text" path="dataCadastro"/>
                                
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                           <label for="inputCodigo">Código:</label>
                                            <form:input class="form-control" id="inputCodigo" path="codigo"/>
                                            <form:errors path="codigo" class="text-danger"/>
                                        </div> 
                                    </div>
                                </div> 
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                           <label for="inputDescricao">Descrição:</label>
                                            <form:input class="form-control" id="inputDescricao" path="descricao"/>
                                            <form:errors path="descricao" class="text-danger"/>
                                        </div> 
                                    </div>
                                </div> 
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                            <label for="inputCapacidade">Capacidade:</label>
                                            <form:input type="number" class="form-control" id="inputCapacidade" path="capacidade"/>
                                            <form:errors path="capacidade" class="text-danger"/>
                                        </div>  
                                    </div>  
                                </div>  
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                           <label for="inputIdResponsavel">Responsável:</label>
                                           <c:choose>
                                               <c:when test="${empty funcionariosAtivos}">
                                                   <input class="form-control" disabled="disabled" value="Nenhum funcionário ativo encontrado"/>
                                               </c:when>
                                               <c:otherwise>
                                                    <form:select class="form-control" id="inputIdResponsavel" path="responsavel">
                                                        <c:forEach items="${funcionariosAtivos}" var="fa">
                                                            <c:choose>
                                                                <c:when test="${sala.responsavel != null && sala.responsavel.id != null && fa.id != null && sala.responsavel.id == fa.id}">
                                                                    <form:option value="${fa}" selected="selected">
                                                                        ${fa.nome}
                                                                    </form:option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <form:option value="${fa}" >
                                                                        ${fa.nome}
                                                                    </form:option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </form:select>
                                               </c:otherwise>
                                           </c:choose>
                                           <form:errors path="responsavel" class="text-danger"/>        
                                        </div> 
                                    </div> 
                                </div> 
                                <div class="panel-footer">
                                    <button type="submit" class="btn btn-success">Salvar</button>
                                    <a href="${pageContext.request.contextPath}/salas/" class="btn btn-danger">Cancelar</a>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
</html>
