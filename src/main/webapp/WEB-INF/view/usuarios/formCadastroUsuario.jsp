<%-- 
    Document   : listarSalas
    Created on : 22/10/2017, 15:11:04
    Author     : Eduardo
--%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <tag:dependecias/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cadastro de usuário</title>
    </head>
    <body>
        <tag:header urlImage=""/>
        
        <div class="container-fluid ">
            
            <div class="row">
                <div class="col-md-10 col-lg-8 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1">
                  
                    <div class="panel panel-default">
                        <div class="panel-heading">Novo Usuário</div>
                        <div class="panel-body ">
                            <form:form method="POST" modelAttribute="usuario" action="${pageContext.request.contextPath}/usuarios/doInsertData">
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                           <label for="inputNome">Nome:</label>
                                            <form:input class="form-control" id="inputNome" path="nome"/>
                                        </div> 
                                    </div>
                                </div> 
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                           <label for="inputLogin">Login:</label>
                                            <form:input class="form-control" id="inputLogin" path="login"/>
                                        </div> 
                                    </div>
                                </div> 
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                            <label for="inputSenha">Senha:</label>
                                            <form:password class="form-control" id="inputSenha" path="senha"/>
                                        </div>  
                                    </div>  
                                </div>  
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                           <label for="inputEmail">Email:</label>
                                            <form:input class="form-control" id="inputEmail" path="email"/>
                                        </div> 
                                    </div> 
                                </div> 

                                 <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                            <label for="selectStatus">Status:</label>
                                           <form:select class="form-control" id="selectStatus" path="statusUsuario">
                                               <form:option value="AGUARDANDO"/>
                                               <form:option value="ATIVO"/>
                                               <form:option value="INATIVO"/>
                                           </form:select>
                                        </div> 
                                    </div> 
                                </div> 
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                            <label for="selectTipoUsuario">Tipo de Usuário:</label>
                                           <form:select class="form-control" id="selectTipoUsuario" path="tipoUsuario">
                                               <form:option value="USUARIO"/>
                                               <form:option value="FUNCIONARIO"/>
                                               <form:option value="ADMINISTRADOR"/>
                                           </form:select>
                                        </div> 
                                    </div> 
                                </div> 
                                
                                <div class="panel-footer">
                                    <button type="submit" class="btn btn-success">Salvar</button>
                                    <a href="${pageContext.request.contextPath}/usuarios/" class="btn btn-danger">Cancelar</a>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
</html>
