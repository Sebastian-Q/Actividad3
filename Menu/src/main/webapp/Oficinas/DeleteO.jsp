<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 06/10/2021
  Time: 08:30 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath(); %>
<html lang="en">
<head>
    <title>Eliminar</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=context%>/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-success">
        <a class="navbar-brand">Gestor de Oficinas</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="RegisterUpdateO.jsp">Registrar o Actualizar</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Oficinas.jsp">Consultar</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="DeleteO.jsp">Eliminar</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="../index.jsp">Regresar</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<section >
    <div class="container bg-secondary text-light mt-2">
        <form>
            <div class="row p-2">
                <div class="col-12 col-md-8">
                    <div class="form-group">
                        <label for="productCode">Codigo de la Oficina a eliminar: </label>
                        <input type="number" name="productCode" id="productCode" class="form-control">
                    </div>
                </div>
                <div class="col-12 col-md-4 align-self-center text-right">
                    <button type="submit" class="btn btn-danger" style="width: 100%;"
                            onclick="return deleteOffice()">Eliminar</button>
                </div>
            </div>
        </form>
    </div>
    <div class="text-center bg-dark text-light">
        <h1 id="mensaje"></h1>
    </div>
</section>
<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.24.1/feather.min.js"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/feather-icons"></script>
<script>
    feather.replace()
</script>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

</body>
</html>
