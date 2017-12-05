<%-- 
    Document   : listarSalas
    Created on : 22/10/2017, 15:11:04
    Author     : Eduardo
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

        <title>Lista de salas</title>

    </head>
    <body>
        <tag:header urlImage=""/>

        <div class="container-fluid">

            <!--<div class="row">-->
                <!--<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">-->
                    <!--<div class="alert alert-info" role="alert">-->
                        <%--<c:choose>--%>
                            <%--<c:when test="${usuarioLogado.tipoUsuario == 'USUARIO'}">--%>
                                <!--<input type="hidden" id="id-usuario" value="${usuarioLogado.id}"/>-->
                                <!--<input disabled="disabled" value="${usuarioLogado.nome}"/>-->
                            <%--</c:when>--%>
                            <%--<c:otherwise>--%>
                                <!--<select>-->
                                    <%--<c:forEach items="usuarios" var="u">--%>
                                        <!--<option value="${u}">-->
                                            <!--${u.nome}-->
                                        <!--</option>-->
                                    <%--</c:forEach>--%>
                                <!--</select>-->
                            <%--</c:otherwise>--%>
                        <%--</c:choose>--%>
                    <!--</div>-->
                <!--</div>-->
            <!--</div>-->

            <hr>
            <c:choose>
                <c:when test="${empty itensReservas}">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
                            <div class="alert alert-info" role="alert">
                                Nenhuma reserva foi encontrada
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-lg-9 col-md-9 col-sm-7">
                                    <h3 class="panel-title input-sm">Reservas</h3>
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
                                    </tr>
                                </thead>
                                <tbody id="tb-salas">
                                    <c:forEach items="${itensReservas}" var="s">
                                        <tr>
                                            <td width="10%">
                                                <span>${s.dataReserva}</span>
                                            </td>
                                            <td width="40%">
                                                <span>${s.reserva.usuario.nome}</span>
                                            </td>
                                            <td width="40%">
                                                <span>${s.itemReservavel.descricao}</span>
                                            </td>
                                            <td width="10%">
                                                <span>${s.status}</span>
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
                $('#input-filtro').keypress(function (event) {
                    //        ao pressionar enter (tecla 13) no campo de pesquisa chama esta funcao
                    var keycode = (event.keyCode ? event.keyCode : event.which);
                    if (keycode == '13') {
                        //                pega o valor do input
                        var filtro = $("#input-filtro").val();

                        if (filtro != null) {
                            //                    invoca o metodo filtrar
                            $.get("${pageContext.request.contextPath}/salas/filtrar", {"filtro": filtro}, function (data) {
                                //                        pega o html retornado e insere dentro da table 
                                $("#tb-salas").html(data);
                            });
                        }
                    }
                });
            });
        </script> 

    </body>
</html>
