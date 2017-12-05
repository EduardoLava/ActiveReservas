<%-- 
    Document   : listarSalas
    Created on : 05/11/2017, 15:11:04
    Author     : syen
--%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach items="${itensReservas}" var="s">
    <tr>
        <td width="10%">
             <fmt:parseDate value="${s.dataReserva}" pattern="yyyy-MM-dd" 
                    var="parsedDate" type="date" />

            <fmt:formatDate value="${parsedDate}" var="formatada" 
                            type="date" pattern="dd/MM/yyyy" />
            <span>${formatada}</span> 
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
                        
