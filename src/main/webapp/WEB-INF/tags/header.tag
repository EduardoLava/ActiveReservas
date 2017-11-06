
<%@ attribute name="urlImage" required="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-default">
   <div class="container-fluid">
      <div class="navbar-header">
            <ul class="nav navbar-nav">
                <li><a href="#">Home</a></li>
            </ul>
      </div>
       <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav">
                <sec:authorize access="hasRole('ROLE_USUARIO')">
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
                </ul>
            </sec:authorize>
            <div class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/logout" method="POST"> 
                    <button type="submit" class="btn btn-danger">Log Out</button>
                </form>
            </div> 
      </div>
   </div>
</nav>