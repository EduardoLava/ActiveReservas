
<%@ attribute name="urlImage" required="false"%>

<nav class="navbar navbar-default">
   <div class="container-fluid">
      <div class="navbar-header">
            <ul class="nav navbar-nav">
                <li><a href="#">Home</a></li>
            </ul>
      </div>
       <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav">
                <li class="dropdown" >
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Salas</a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="${pageContext.request.contextPath}/salas/">Listagem</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/salas/formulario">Cadastrar</a>
                        </li>
                    </ul>
                </li>
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
            </ul>
            <div class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/logout" method="POST"> 
                    <button type="submit" class="btn btn-danger">Log Out</button>
                </form>
            </div> 
      </div>
   </div>
</nav>