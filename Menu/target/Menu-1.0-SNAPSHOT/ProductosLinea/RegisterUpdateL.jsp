<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 06/10/2021
  Time: 08:31 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath(); %>
<html lang="en">
<head>
    <title>Registro</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=context%>/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-info">
        <a class="navbar-brand">Gestor de Productos en Linea</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="RegisterUpdateL.jsp">Registrar o Actualizar</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ProductosLinea.jsp">Consultar</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="DeleteL.jsp">Eliminar</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="../index.jsp">Regresar</a>
                </li>
            </ul>
        </div>
    </nav>
</header>

<section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-12 col-sm-10">
                <section>
                    <div class="card">
                        <div class="card-body">
                            <form enctype="multipart/form-data" method="post">
                                <div class="col-12">
                                    <header>
                                        <h2>Productos en Linea <i data-feather="aperture" class="text-secondary"></i></h2>
                                        <hr class="bg-secondary"/>
                                    </header>
                                </div>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-12 col-sm-9">
                                            <div class="form-group">
                                                <label>Producto en Linea</label>
                                                <input type="text" id="productLine" name="productLine" class="form-control" required minlength="2" maxlength="50">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-12 col-sm-6">
                                            <div class="form-group">
                                                <label>Descripcion</label>
                                                <input type="text" id="textDescription" name="textDescription" class="form-control" required minlength="2" maxlength="4000">
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-6">
                                            <div class="form-group">
                                                <label>Descripcion HTML</label>
                                                <input type="text" id="htmlDescription" name="htmlDescription" class="form-control" maxlength="4000">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-12 col-md-4">
                                            <div class="form-group">
                                                <label>Imagen</label>
                                                <input type="text" id="image" name="image" class="form-control" required minlength="2" maxlength="6">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-12 col-md-6">
                                            <div class="form-group" >
                                                <label for="accion">Acción</label>
                                                <select class="form-control" id="accion" name="accion" required>
                                                    <option value="Actualizar">Actualizar</option>
                                                    <option value="Registrar" selected>Registrar</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-12 col-md-8  align-self-center text-right mt-2">
                                    <button class="btn btn-primary" onclick="return regUpdProductsLine()" >Realizar acción</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </section>
            </div>
        </div>
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
