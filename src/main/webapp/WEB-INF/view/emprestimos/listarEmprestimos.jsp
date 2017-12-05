<%-- 
    Document   : listarSalas
    Created on : 05/11/2017, 15:11:04
    Author     : syen
--%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <tag:dependecias/>

        <title>Lista de empréstimos</title>

    </head>
    <body>
        <tag:header urlImage=""/>

        <div class="container-fluid">

            <c:choose>
                <c:when test="${usuarioLogado.tipoUsuario == 'USUARIO'}">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12"> 
                            <div class="alert alert-info">
                                Seus empréstimos
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-xs-12 col-sm-12"> 
                            <input id="id-usuario" type="hidden" value="${usuarioLogado.id}"/>
                            <input disabled="disabled" class="form-control" value="${usuarioLogado.nome}"/>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12"> 
                            <div class="alert alert-info">
                                Selecione um usuário para visualizar os empréstimos dele.
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-xs-12 col-sm-12"> 
                            <select id="select-usuarios" class="form-control">
                                <option class="form-control" value="${-1}">
                                    Todos
                                </option>
                                <c:forEach items="${usuarios}" var="u">
                                    <option class="form-control" value="${u.id}">
                                        ${u.nome}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>  

            <hr>
            <c:choose>
                <c:when test="${empty itensEmprestimos}">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
                            <div class="alert alert-info" role="alert">
                                Nenhum empréstimo foi encontrado
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-lg-9 col-md-9 col-sm-7">
                                    <h3 class="panel-title input-sm">Empréstimos</h3>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive"> 
                            <table class="table table-hover table-striped table-bordered table-md">
                                <thead>
                                    <tr>
                                        <th width="10%">
                                            Data
                                        </th>
                                        <th width="40%">
                                            Usuário
                                        </th> 
                                        <th width="40%">
                                            Item
                                        </th> 
                                        <th width="10%">
                                            Status
                                        </th> 
                                        <th>
                                            &nbsp
                                        </th>
                                    </tr>
                                </thead>
                                <tbody id="tb-emprestimos">
                                    <c:forEach items="${itensEmprestimos}" var="s">
                                        <tr>
                                            <td width="10%">
                                                 <fmt:parseDate value="${s.data}" pattern="yyyy-MM-dd" 
                                                        var="parsedDate" type="date" />

                                                <fmt:formatDate value="${parsedDate}" var="formatada" 
                                                                type="date" pattern="dd/MM/yyyy" />
                                                <span>${formatada}</span> 
                                            </td>
                                            <td width="40%">
                                                <c:forEach items="${s.emprestimo.usuarios}" var='us'>
                                                    <c:if test="${us.tipoResponsavelEmprestimo == 'RESPONSAVEL'}">
                                                        ${us.usuario.nome}
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <td width="40%">
                                                <span>${s.itemReservavel.descricao}</span>
                                            </td>
                                            <td width="10%">
                                                <span>${s.emprestimo.statusEmprestimo}</span>
                                            </td>
                                            <td>
                                                <c:if test="${it.horaDevolucao != null}">
                                                    
                                                    <sec:authorize access="hasRole('ROLE_FUNCIONARIO')">
                                                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/emprestimos/finalizar?id=${s.id}">Finalizar</a>
                                                    </sec:authorize>
                                                </c:if>
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

        <script type="text/javascript">
            $(function () {
                $('#select-usuarios').change(function (event) {
                    //        ao pressionar enter (tecla 13) no campo de pesquisa chama esta funcao
                    var filtro = $("#select-usuarios option:selected").val();

                    if (filtro !== null) { 
                        //                    invoca o metodo filtrar
                        $.get("${pageContext.request.contextPath}/emprestimos/filtrar", {"id": filtro}, function (data) {
                            //                        pega o html retornado e insere dentro da table 
                            $("#tb-emprestimos").html(data); 
                        });
                    }
                });
            });
        </script> 

    </body>
</html>
