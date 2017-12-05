<%-- 
    Document   : listarTiposDeAtivos
    Created on : 04/11/2017, 15:11:04
    Author     : Susy
--%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <tag:dependecias/>
 <!--       <script type="text/javascript">
            $(function (){
                $('#input-filtro').keypress(function(event){
              //        ao pressionar enter (tecla 13) no campo de pesquisa chama esta funcao
                        var keycode = (event.keyCode ? event.keyCode : event.which);
                        if(keycode == '13'){
              //                pega o valor do input
                            var filtro = $("#input-filtro").val();

                            if(filtro != null){
              //                    invoca o metodo filtrar
                                $.get("${pageContext.request.contextPath}/ativos/filtrar", {"filtro": filtro}, function(data){
             //                        pega o html retornado e insere dentro da table 
                                    $("#tb-ativos").html(data); 
                                });
                            }
                        }
                });
            });
        </script> -->
        
        <title>Lista de ativos</title>
        
    </head>
    <body>
        <tag:header urlImage=""/>
        
        
        <div class="container-fluid">
            <sec:authorize access="hasRole('ROLE_FUNCIONARIO')">
                <a href="${pageContext.request.contextPath}/ativos/cadastrar" 
                   class="btn btn-primary" 
                   role="button" 
                   aria-label="Left Align">
                    Cadastrar Ativos
                </a>
       
                <hr/>
            </sec:authorize>
            
            <c:choose>
                <c:when test="${empty ativos}">
                    <div class="alert alert-info" role="alert">
                        Nenhum ativo foi encontrado
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-lg-9 col-md-9 col-sm-7">
                                    <h3 class="panel-title input-sm">Ativos</h3>
                                </div>
<!--                                <div class="col-lg-3 col-md-3 col-sm-5">
                                    <input class='input-sm form-control' type="text" id="input-filtro" placeholder="Pesquisa"/>
                                </div>      -->
                            </div>
                        </div>
                        <div class="table-responsive"> 
                            <table class="table table-hover table-striped table-bordered table-md">
                                <thead>
                                    <tr>
                                        <th width="10%">
                                            Código
                                        </th>
                                        <th width="40%">
                                            Descrição
                                        </th> 
                                        <th width="10%">
                                            Tipo
                                        </th> 
                                        <th width="30%">
                                            Responsável
                                        </th> 
                                        <sec:authorize access="hasRole('ROLE_FUNCIONARIO')">
                                            <th width="10%"> 
                                            </th> 
                                        </sec:authorize>
                                    </tr>
                                </thead>
                                <tbody id="tb-ativos">
                                    <c:forEach items="${ativos}" var="s">
                                        <tr>
                                            <td width="10%">
                                                <span>${s.codigo}</span>
                                            </td>
                                            <td width="40%">
                                                <span>${s.descricao}</span>
                                            </td>
                                            <td width="10%">
                                                <span>${s.tipoDeAtivo.descricao}</span>
                                            </td>
                                            <td width="30%">
                                                <span>${s.responsavel.nome}</span> 
                                            </td>
                                            <sec:authorize access="hasRole('ROLE_FUNCIONARIO')">
                                                <td width="10%" class="text-center"> 
                                                    <a class="btn btn-info btn-sm" 
                                                       href="${pageContext.request.contextPath}/ativos/editar?id=${s.id}">
                                                        Editar
                                                    </a>
                                                </td>
                                            </sec:authorize>
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
