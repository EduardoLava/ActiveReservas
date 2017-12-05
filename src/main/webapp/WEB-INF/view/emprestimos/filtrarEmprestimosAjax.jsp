<%-- 
    Document   : listarSalas
    Created on : 05/11/2017, 15:11:04
    Author     : syen
--%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
                        
