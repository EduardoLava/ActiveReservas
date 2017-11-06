<%-- 
    Document   : formCadastroTipoDeAtivo
    Created on : 04/11/2017, 22:11:04
    Author     : Susy
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
        <title>Cadastro de Tipo de Ativo</title>
        
    </head>
    <body>
        <tag:header urlImage=""/>
        
        <div class="container-fluid ">
            
            <div class="row">
                <div class="col-md-8 col-lg-6 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-2">
                  
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Tipo de Ativo</h4>
                        </div>
                        <div class="panel-body ">
                            <form:form method="POST" modelAttribute="tipoDeAtivo" action="${pageContext.request.contextPath}/tipos-de-ativos/salvar">
                                
                                <form:input class="invisivel" type="number"  path="id"/>
                                <form:input class="invisivel" type="text" path="dataCadastro"/>
                                
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                           <label for="inputdescricao">Descrição</label>
                                            <form:input class="form-control" id="inputdescricao" path="descricao"/>
                                            <form:errors path="descricao" class="text-danger"/>
                                        </div> 
                                    </div>
                                </div> 
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                            <label for="selectstatusTipoAtivo">Status</label>
                                           <form:select class="form-control" id="selectstatusTipoAtivo" path="statusTipoAtivo">
                                               <form:option value="ATIVO"/>
                                               <form:option value="INATIVO"/>
                                           </form:select>
                                        </div> 
                                    </div> 
                                </div> 
                                
                                <div class="panel-footer">
                                    <button type="submit" class="btn btn-success">Salvar</button>
                                    <a href="${pageContext.request.contextPath}/tipos-de-ativos/" class="btn btn-danger">Cancelar</a>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
</html>
