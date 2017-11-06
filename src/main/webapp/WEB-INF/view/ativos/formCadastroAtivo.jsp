<%-- 
    Document   : formCadastroTipoDeAtivo
    Created on : 04/11/2017, 22:11:04
    Author     : Susy
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
        
        <title>Cadastro de Ativo</title>
        
        <script>
            $( function() {
              $( "#inputdataCompra, #inputDataVencimentoGarantia" ).datepicker({dateFormat: 'dd/mm/yy'});
            } );
        </script>
        
        <style>
            hr{
                margin-top: 0px;
                margin-bottom: 16px;
            }
            
            .opcional{
                color: #585858;
            }
        </style>
        
    </head>
    <body>
        <tag:header urlImage=""/>
        
        <c:set value="&nbsp(Opcional) " var="textoOpcional"></c:set>
        
        <div class="container-fluid ">
               
            <div class="row">
                <div class="col-md-8 col-lg-6 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-2">
                  
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h4>Ativo</h4>
                        </div>
                        <div class="panel-body ">
                            <form:form method="POST" modelAttribute="ativo" action="${pageContext.request.contextPath}/ativos/salvar">
                                
                                <form:input class="invisivel" type="number"  path="id"/>
                                <form:input class="invisivel" type="text" path="dataCadastro"/>
                                <h3>Informações Gerais</h3>
                                <hr >
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                           <label for="inputDescricao">Descrição</label>
                                            <form:input class="form-control" id="inputDescricao" path="descricao"/>
                                            <form:errors path="descricao" class="text-danger"/>
                                        </div> 
                                    </div>
                                </div> 
                                      
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                           <label for="inputTipoDeAtivo">Tipo de Ativo</label>
                                           <c:choose>
                                               <c:when test="${empty tiposDeAtivos}">
                                                   <input class="form-control" disabled="disabled" value="Nenhum tipo de ativo encontrado"/>
                                               </c:when>
                                               <c:otherwise>
                                                    <form:select class="form-control" id="inputTipoDeAtivo" path="tipoDeAtivo">
                                                        <c:forEach items="${tiposDeAtivos}" var="tipo">
                                                            <c:choose>
                                                                <c:when test="${ativo.tipoDeAtivo != null && ativo.tipoDeAtivo.id != null && tipo.id != null && ativo.tipoDeAtivo.id == tipo.id}">
                                                                    <form:option value="${tipo}" selected="selected">
                                                                        ${tipo.descricao}
                                                                    </form:option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <form:option value="${tipo}" >
                                                                        ${tipo.descricao}
                                                                    </form:option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </form:select>
                                               </c:otherwise>
                                           </c:choose>
                                                   
                                           <form:errors path="tipoDeAtivo" class="text-danger"/>        
                                        </div> 
                                    </div> 
                                </div>           
                                        
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                           <label for="inputCodigo">Código</label>
                                            <form:input class="form-control" id="inputCodigo" path="codigo"/>
                                            <form:errors path="codigo" class="text-danger"/>
                                            <form:errors path="" class="text-danger"/>
                                        </div> 
                                    </div>
                                </div>    
                                        
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                            <label for="inputModelo">Modelo</label><label class="opcional">${textoOpcional}</label>
                                            <form:input class="form-control" id="inputModelo" path="modelo"/>
                                            <form:errors path="modelo" class="text-danger"/>
                                        </div> 
                                    </div> 
                                </div> 
                                        
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                            <label for="inputCor">Cor</label><label class="opcional">${textoOpcional}</label>
                                            <form:input class="form-control" id="inputCor" path="cor"/>
                                            <form:errors path="cor" class="text-danger"/>
                                        </div> 
                                    </div> 
                                </div> 
                                 
                                <h3>Dados da Compra</h3>  
                                
                                <hr/>
                                
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                            <label for="inputDataCompra">Data Compra</label>
                                            <form:input class="form-control" id="inputdataCompra" path="dataCompra"/>
                                            <form:errors path="dataCompra" class="text-danger"/>
                                        </div> 
                                    </div> 
                                </div> 
                                        
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                            <label for="inputDataVencimentoGarantia">Data Vencimento Garantia</label><label class="opcional">${textoOpcional}</label>
                                            <form:input class="form-control" id="inputDataVencimentoGarantia" path="dataVencimentoGarantia"/>
                                            <form:errors path="dataVencimentoGarantia" class="text-danger"/>
                                        </div> 
                                    </div> 
                                </div> 
                                        
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                            <label for="inputValor">Valor</label><label class="opcional">${textoOpcional}</label>
                                            <form:input type="number" min="0.00" max="10000.00" step="0.01" class="form-control" id="inputValor" path="valor"/>
                                            <form:errors path="valor" class="text-danger"/>
                                        </div> 
                                    </div> 
                                </div> 
                                        
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                            <label for="inputFornecedor">Fornecedor</label><label class="opcional">${textoOpcional}</label>
                                            <form:input class="form-control" id="inputFornecedor" path="fornecedor"/>
                                            <form:errors path="fornecedor" class="text-danger"/>
                                        </div> 
                                    </div> 
                                </div>             
                                      
                                <h3>Informações Complementares</h3>
                                <hr/>
                                
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                            <label for="inputLocalRetirada">Local de Retirada</label><label class="opcional">${textoOpcional}</label>
                                            <form:input class="form-control" id="inputLocalRetirada" path="localRetirada"/>
                                            <form:errors path="localRetirada" class="text-danger"/>
                                        </div> 
                                    </div> 
                                </div>        
                                        
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                           <label for="inputIdResponsavel">Responsável</label>
                                           <c:choose>
                                               <c:when test="${empty funcionariosAtivos}">
                                                   <input class="form-control" disabled="disabled" value="Nenhum funcionário ativo encontrado"/>
                                               </c:when>
                                               <c:otherwise>
                                                    <form:select class="form-control" id="inputIdResponsavel" path="responsavel">
                                                        <c:forEach items="${funcionariosAtivos}" var="fa">
                                                            <c:choose>
                                                                <c:when test="${sala.responsavel != null && sala.responsavel.id != null && fa.id != null && sala.responsavel.id == fa.id}">
                                                                    <form:option value="${fa}" selected="selected">
                                                                        ${fa.nome}
                                                                    </form:option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <form:option value="${fa}" >
                                                                        ${fa.nome}
                                                                    </form:option>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach>
                                                    </form:select>
                                               </c:otherwise>
                                           </c:choose>
                                           <form:errors path="responsavel" class="text-danger"/>        
                                        </div> 
                                    </div> 
                                </div>         
                                        
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                            <label for="selectStatusAtivo">Status</label>
                                           <form:select class="form-control" id="selectStatusAtivo" path="statusAtivo">
                                               <form:option value="DISPONIVEL"/>
                                               <form:option value="INDISPONIVEL"/>
                                               <form:option value="MANUTENCAO"/>
                                               <form:option value="INATIVO"/>
                                           </form:select>
                                            <form:errors path="statusAtivo" class="text-danger"/> 
                                        </div> 
                                    </div> 
                                </div> 
                                        
                                <div class="row">
                                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                        <div class="form-group"> 
                                            <label for="inputObservacao">Observacao</label><label class="opcional">${textoOpcional}</label>
                                            <form:textarea class="form-control" id="inputObservacao" path="observacao"/>
                                            <form:errors path="observacao" class="text-danger"/>
                                        </div> 
                                    </div> 
                                </div>              
                                        
                                <div class="panel-footer">
                                    <button type="submit" class="btn btn-success">Salvar</button>
                                    <a href="${pageContext.request.contextPath}/ativos/" class="btn btn-danger">Cancelar</a>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
</html>
