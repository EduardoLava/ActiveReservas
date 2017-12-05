
<%@ attribute name="urlImage" required="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-default">
   <div class="container-fluid">
       <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#opcoes" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${pageContext.request.contextPath}/reservas/">Home</a>
    </div>
       
    <div class="collapse navbar-collapse" id="opcoes" >
           <sec:authorize access="hasRole('ROLE_USUARIO')">
                <ul class="nav navbar-nav">
                    <li class="dropdown" >
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Salas</a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="${pageContext.request.contextPath}/salas/">Listagem</a>
                            </li>

                            <sec:authorize access="hasRole('ROLE_FUNCIONARIO')">
                                <li>
                                    <a href="${pageContext.request.contextPath}/salas/formulario">Cadastrar</a>
                                </li>
                            </sec:authorize>
                        </ul>
                    </li>
                    <sec:authorize access="hasRole('ROLE_FUNCIONARIO')">
                        <li class="dropdown" >
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Usuários</a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/usuarios/">Listagem</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/usuarios/cadastrar">Cadastrar</a>
                                </li>
                            </ul>
                        </li>
                    </sec:authorize>
                    <li class="dropdown" >
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Tipos de Ativos</a>
                        <ul class="dropdown-menu">
                            <!--<li>
                                <a href="${pageContext.request.contextPath}/tipos-de-ativos/">Listagem</a>
                            </li>-->
                            <sec:authorize access="hasRole('ROLE_FUNCIONARIO')">
                                <li>
                                    <a href="${pageContext.request.contextPath}/tipos-de-ativos/cadastrar">Cadastrar</a>
                                </li>
                            </sec:authorize>
                        </ul>
                    </li>
                    <li class="dropdown" >
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Ativos</a>
                        <ul class="dropdown-menu">
                            <!--<li>
                                <a href="${pageContext.request.contextPath}/tipos-de-ativos/">Listagem</a>
                            </li>-->
                            <sec:authorize access="hasRole('ROLE_FUNCIONARIO')">
                                <li>
                                    <a href="${pageContext.request.contextPath}/ativos/cadastrar">Cadastrar</a>
                                </li>
                            </sec:authorize>     
                                
                        </ul>
                    </li>
                    <li class="dropdown" >
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Reservas</a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="${pageContext.request.contextPath}/reservas/formulario">Cadastrar</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/reservas/">Listar</a>
                            </li>
                        </ul>
                    </li>
                    <sec:authorize access="hasRole('ROLE_FUNCIONARIO')">
                        <li class="dropdown" >
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Emprestimos</a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="${pageContext.request.contextPath}/emprestimos/formulario">Cadastrar</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/emprestimos/">Listar</a>
                                </li>
                            </ul>
                        </li>
                    </sec:authorize>
                </ul>
            <div class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/logout" method="POST"> 
                    <button type="submit" class="btn btn-danger">Log Out</button>
                </form>
            </div> 
        </sec:authorize>
      </div>
   </div>
</nav>