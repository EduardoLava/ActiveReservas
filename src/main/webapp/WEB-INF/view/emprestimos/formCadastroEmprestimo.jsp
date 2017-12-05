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
        <title>Cadastro de emprestimo</title>
    </head>
    <body>
        <tag:header urlImage=""/>
        <div class="container-fluid ">
            <!--modal para adicionar itens -->
            <div class="modal fade"  tabindex="-1" role="dialog" id="modal-it">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">Itens disponíveis para emprestimo</h4>
                        </div>
                        <div class="modal-body" id="modal-itens-para-emprestimo">
                        </div>
                        <div class="modal-footer">
                            <button type="button" 
                                    id="btn-feito"
                                    class="btn btn-success" 

                                    data-dismiss="modal">
                                Feito
                            </button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

            <!--fim modal-->
            
            <!--modal reserva-->
            
            <div class="modal fade"  tabindex="-1" role="dialog" id="modal-it">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">Itens reservas</h4>
                        </div>
                        <div class="modal-body" id="modal-reservas-emprestimo">
                        </div>
                        <div class="modal-footer">
                            <button type="button" 
                                    id="btn-feito"
                                    class="btn btn-success" 

                                    data-dismiss="modal">
                                Feito
                            </button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->

            
            <!--fim modal reserva-->

            <div class="row">
                <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">

                    <button type="button" 
                            class="btn btn-primary" 
                            id="bt-adicionar" 
                            data-toggle="modal" 
                            data-target="#myModal">Adicionar Itens</button>
                    
<!--                    <button type="button" 
                            class="btn btn-primary" 
                            id="bt-adicionar-reservas" 
                            data-toggle="modal" 
                            data-target="#myModal">Adicionar Reservas</button>-->

                    <c:if test="${itensMeusEmprestimos.size() > 0}">
                        <button type="button" 
                                class="btn btn-success" 
                                id="bt-salvar">Concluir</button>
                    </c:if>
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-sm-12">
                            <div class="help-block"></div>
                            <c:choose>
                                <c:when test="${not empty usuarios}">
                                    <select class="form-control" id="inputIdResponsavel" >
                                        <c:forEach items="${usuarios}" var="fa">
                                            <option value="${fa.id}" >
                                                ${fa.nome}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </c:when>
                                <c:otherwise>
                                    
                                </c:otherwise>
                            </c:choose>
                        </div>   
                    </div>
                    <hr/>

                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Meu Emprestimo</h4>
                        </div>
                        <div class="panel-body ">
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-sm-12">
                                    <c:choose>
                                        <c:when test="${itensMeusEmprestimos == null || empty itensMeusEmprestimos}">
                                            <div class="alert alert-info" 
                                                 role="alert">
                                                Nenhum item adicionado no momento
                                                <br>Clique em adicionar para inserir itens
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="table-responsive"> 
                                                <table class="table table-hover table-striped table-bordered table-md">
                                                    <thead>
                                                        <tr>
                                                            <th width="10%">Tipo</th>
                                                            <th width="20%">Código</th>
                                                            <th width="30%">Descrição</th>
                                                            <th width="30%">Responsável</th>
                                                            <th width="10%"></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="tb-reserva">
                                                        <c:forEach items="${itensMeusEmprestimos}" var="it">
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
                                                                <td width="30%">
                                                                    ${it.itemReservavel.responsavel.nome}
                                                                </td>  
                                                                <td width="10%" class="text-center">
                                                                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/emprestimos/remover-item/${it.itemReservavel.id}">Delete</a>
                                                                </td>
                                                            <tr>
                                                            </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script>

            $("#btn-feito").click(function () {
                window.location.reload();
            });

            $("#bt-adicionar").click(function () {

                var uri = '${pageContext.request.contextPath}/emprestimos/modal';

                $.get(uri, function (data) {
                    $("#modal-itens-para-emprestimo").html(data);

                    $('#modal-it').modal({
                        keyboard: true,
                        backdrop: 'static',
                        show: true
                    }).on('shown.bs.modal');

                });

            });

            $("#bt-adicionar-reservas").click(function(){
                
                var uri = '${pageContext.request.contextPath}/reservas/reservas-do-usuario-hoje';

                $.get(uri, function (data) {
                    $("#modal-reservas-emprestimo").html(data);

                    $('#modal-it').modal({
                        keyboard: true,
                        backdrop: 'static',
                        show: true
                    }).on('shown.bs.modal');

                });
                
            });

            $("#bt-salvar").click(function () {
                var uri = '${pageContext.request.contextPath}/emprestimos/salvar';
                var usuario = $("#inputIdResponsavel option:selected").val();
                console.log(usuario);
                var pars = {'usuario':usuario};

                $.post(uri, pars, function () {
                    alert("Empréstimo salvo com sucesso");
                });

            });

        </script> 

    </body>
</html>
