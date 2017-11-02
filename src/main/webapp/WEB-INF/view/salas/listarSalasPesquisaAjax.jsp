<%-- 
    Document   : listarSalas
    Created on : 22/10/2017, 15:11:04
    Author     : Eduardo
--%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${salas}" var="s">
    <tr>
        <td width="10%">
            <span>${s.codigo}</span>
        </td>
        <td width="40%">
            <span>${s.descricao}</span>
        </td>
        <td width="10%">
            <span>${s.capacidade}</span>
        </td>
        <td width="30%">
            <span>${s.responsavel.nome}</span> 
        </td>
        <td width="10%" class="text-center"> 
            <a class="btn btn-info btn-sm" 
               href="${pageContext.request.contextPath}/salas/editar?id=${s.id}">
                Editar
            </a>
        </td>
    </tr>
</c:forEach>