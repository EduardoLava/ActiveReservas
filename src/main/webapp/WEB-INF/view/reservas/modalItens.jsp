<%-- 
    Document   : modlaItens
    Created on : 18/11/2017, 12:48
    Author     : Eduardo
--%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<script>
    
    $("#input-data-reserva" ).datepicker(
        {
            dateFormat: 'dd/mm/yy',
            minDate: 0
        }
    );

    $("#input-data-reserva, #select-itens-reservaveis, #select-tipo-de-ativo").change(function(){

        var data = $("#input-data-reserva").val();
        
        if(data === null || data === ''){
            $("#tipos-ativos").addClass("invisivel");
            $("#select-itens-reservaveis").prop('disabled', 'disabled');
            $("#itens-disp").html("<div class='alert alert-info'>Selecione uma data</div>");
            return;
        }
        
        $("#select-itens-reservaveis").prop('disabled', false);

        var tipo = $("#select-itens-reservaveis").val();

        if(tipo !== 'ATIVO'){
            $("#tipos-ativos").addClass("invisivel");
        } else {
            $("#tipos-ativos").removeClass("invisivel");
        } 
        
        var idTipoItem = null;
         
        if (!$("#tipos-ativos").hasClass("invisivel")) {
            idTipoItem = $('#select-tipo-de-ativo option:selected').val();
        }
////        fazer o get para puxar os itens reservaveis disponiveis na data selecionada
        if(data !== null && data !== ''){
            if(idTipoItem !== null){
                $.get(
                        "${pageContext.request.contextPath}/reservas/disponiveis-data-tipos", 
                        {"data": data ,"tipo" : tipo, "idTipoAtivo": idTipoItem},
                        function(response){
                            $("#itens-disp").html(response); 
                });
                return;
            }
            
            if(tipo !== ''){
                $.get("${pageContext.request.contextPath}/reservas/disponiveis-data-tipo", {"data": data ,"tipo" : tipo}, function(response){
                   $("#itens-disp").html(response); 
                });
                return;
            }
            
            $.get("${pageContext.request.contextPath}/reservas/disponiveis-data", {"data": data}, function(response){
                $("#itens-disp").html(response); 
            });
        }
    });
    
</script>

<div class="modal-body">
    
    <div class="row">
        <div class="col-lg-6 col-md-8 col-sm-12 col-sm-12">
            <span>Data:</span>
            <input class="form-control" id="input-data-reserva"/>
        </div>
    </div>
    <div class="help-block"></div>  
    <div class="row">
        <div class="col-lg-6 col-md-8 col-sm-12 col-sm-12">
            <span>Filtrar:</span>
            <select id="select-itens-reservaveis" disabled="disabled" class="form-control">
                <option value="">Todos</option>
                <option value="ATIVO">Equipamentos</option>
                <option value="SALA">Salas</option>
            </select>
        </div>
    </div>    
    <div class="row">    
        <div id="tipos-ativos" class="invisivel col-lg-6 col-md-8 col-sm-12 col-sm-12">
            <div class="help-block"></div>
            <span>Somente:</span>
            <c:choose>
                <c:when test="${empty tiposAtivos}">
                     <input id="select-tipo-de-ativo" class="form-control" disabled="disabled" value="Nenhum tipo de ativo encontrado"/>
                </c:when>
                <c:otherwise>
                     <select class="form-control " id="select-tipo-de-ativo">
                         <c:forEach items="${tiposAtivos}" var="tipo">
                             <option value="${tipo.id}" >
                                 ${tipo.descricao}
                             </option>
                         </c:forEach>
                     </select>
                </c:otherwise>
            </c:choose>
        </div>
    </div> 

    <hr>
    
    <div id="itens-disp">
        <div class="alert alert-info">Selecione uma data</div>
    </div>
    
</div>

