<%-- 
    Document   : listarSalas
    Created on : 22/10/2017, 15:11:04
    Author     : Eduardo
--%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<script>
    
    function trInvisivel(tr){
        $(tr).remove();

    }

    function getIdItemByTr(tr){
//            pega o valor do input da tr
        var tdId = tr.children("#td-id");
        return tdId.children('#id-item-reservavel').attr('value');   
    }

    function callAddItem(tr){
        adicionaItem(getIdItemByTr(tr),$("#input-data-reserva").val());
    }

    $("#btn-adicionar").click(function(){
//            busca o elemento pai, no caso a td
        var td = $(this).parent();
//            depois pega a tr
        var tr = $(td).parent();
        trInvisivel(tr);
        callAddItem(tr);

    });

    $("#tb-itens").delegate("tr", "click", function(data){

        trInvisivel($(this));
        callAddItem($(this));

    });
    
</script>

<div class="table-responsive"> 
    <table class="table table-hover table-striped table-bordered table-md">
        <thead>
            <tr>
                <th width="10%">Tipo</th>
                <th width="20%">Código</th>
                <th width="40%">Descrição</th>
                <th width="30%">Responsável</th>
            </tr>
        </thead>
        <tbody id="tb-itens">
            <c:forEach items="${itensReservaveis}" var="it">
                    <tr id="item-disponivel">
                        <td width="10%" id="td-id">
                            <input value="${it.id}" type="hidden"  id="id-item-reservavel" />
                            <span>${it.tipo.value}</span>
                        </td>
                        <td width="20%">
                            <span>${it.codigo}</span>
                        </td>
                        <td width="40%">
                            <span>${it.descricao}</span>
                        </td>  
                        <td width="30%">
                            <span>${it.responsavel.nome}</span> 
                        </td>
                    <tr>
            </c:forEach>
        </tbody>
    </table>
</div>  