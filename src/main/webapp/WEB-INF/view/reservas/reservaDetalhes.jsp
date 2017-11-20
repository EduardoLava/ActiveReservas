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
        <title>Detalhes</title>
    </head>
    <body>
        <tag:header urlImage=""/>
        
        <c:choose>
            <c:when test="${reserva == null or empty reserva.itens}">
                <div class="alert alert-info">
                    Reserva não encontrada
                </div>
            </c:when>
            <c:otherwise>
                <div class="container-fluid ">
                    <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h4>Reserva de ${reserva.usuario.nome}</h4>
                            </div>
                        <div class="panel-body ">
                            <div class="table-responsive"> 
                                <table class="table table-hover table-striped table-bordered table-md">
                                    <thead>
                                        <tr>
                                            <th width="10%">Tipo</th>
                                            <th width="20%">Código</th>
                                            <th width="30%">Descrição</th>
                                            <th width="20%">Data Reserva</th>
                                            <th width="10%">Status</th>
                                            <th width="10%"></th>
                                        </tr>
                                    </thead>
                                    <tbody id="tb-reserva">
                                        <c:forEach items="${reserva.itens}" var="it">
                                            <tr>
                                                <td width="10%">
                                                    <input value="${it.itemReservavel.id}" type="hidden" id="id-item-reserva" />
                                                    ${it.itemReservavel.tipo.value}
                                                </td>
                                                <td width="20%">
                                                    ${it.itemReservavel.codigo}
                                                </td>
                                                <td width="30%">
                                                    ${it.itemReservavel.descricao}
                                                </td>  
                                                <td width="20%">

                                                    <fmt:parseDate value="${it.dataReserva}" pattern="yyyy-MM-dd" 
                                                            var="parsedDate" type="date" />

                                                    <fmt:formatDate value="${parsedDate}" var="formatada" 
                                                                    type="date" pattern="dd/MM/yyyy" />
                                                    <span>${formatada}</span>
                                                </td>  
                                                <td width="10%">
                                                    ${it.status.valor}
                                                </td>  
                                                <td width="10%" class="text-center">
                                                    <c:if test="${it.status.valor == 'Ativa'}">
                                                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/reservas/cancelar-item/${it.id}">Cancelar</a>
                                                    </c:if>
                                                </td>
                                            <tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div> 
            </c:otherwise>
        </c:choose>
        
        <script>
            
            $("#cancel-item").click(function(){
                
                if(confirm("Deseja realmente cancelar esta reserva?")){
                    $.get($(this).attr('href'),'', function(){});
                }
                
            });
            
        </script>                
    </body>
</html>
