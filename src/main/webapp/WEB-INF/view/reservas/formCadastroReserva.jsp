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
        <title>Cadastro de reserva</title>
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
                    <h4 class="modal-title">Itens disponíveis para reserva</h4>
                  </div>
                    <div class="modal-body" id="modal-itens-para-reserva">
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
            
            <div class="row">
                <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                    
                    <button type="button" 
                            class="btn btn-primary" 
                            id="bt-adicionar" 
                            data-toggle="modal" 
                            data-target="#myModal">Adicionar</button>
                    
                    <c:if test="${itensMinhaReserva.size() > 0}">
                        <button type="button" 
                                class="btn btn-success" 
                                id="bt-salvar">Concluir</button>
                    </c:if>
                    
                    <hr/>
                                       
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Minha Reserva</h4>
                        </div>
                        <div class="panel-body ">
                            <div class="row">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-sm-12">
                                    <c:choose>
                                        <c:when test="${itensMinhaReserva == null || empty itensMinhaReserva}">
                                            <div class="alert alert-info" 
                                                 role="alert">
                                                Nenhum item reservado no momento
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
                                                    <c:forEach items="${itensMinhaReserva}" var="it">
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
                                                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/reservas/remover-item/${it.itemReservavel.id}">Delete</a>
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
            
            $("#btn-feito").click(function(){
                window.location.reload();
            });

            function adicionaItem(id, data){

                var uri = "${pageContext.request.contextPath}/reservas/adicionar";
                var pars = {"id": id, "data": data};

                $.post(uri, pars, function(response) {
                    $("#tb-reserva").html(response);
                });

            }

            $("#bt-adicionar").click(function(){
                
                var uri = '${pageContext.request.contextPath}/reservas/modal';

                 $.get(uri, function(data){
                    $("#modal-itens-para-reserva").html(data); 

                        $('#modal-it').modal({
                            keyboard: true,
                            backdrop: 'static',
                            show: true
                        }).on('shown.bs.modal');

                    });

                });

                 $("#bt-salvar").click(function(){
                      var uri = '${pageContext.request.contextPath}/reservas/salvar';
                      var pars = '';
                      
                      $.post(uri, pars, function(){
                          alert("Reserva salva com sucesso");
                      });
                      
                 });

        </script> 
        
    </body>
</html>
