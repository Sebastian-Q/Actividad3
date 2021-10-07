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
    <title>Registro</title>
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

<section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-12 col-sm-10">
                <section>
                    <div class="card" >

                        <div class="card-body">
                            <form enctype="multipart/form-data" method="post">
                                <div class="col-12">
                                    <header>
                                        <h2>Oficinas <i data-feather="aperture" class="text-secondary"></i></h2>
                                        <hr class="bg-secondary"/>
                                    </header>
                                </div>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-12 col-sm-6 col-md-2">
                                            <div class="form-group">
                                                <label>Codigo de Oficina</label>
                                                <input type="text" id="productCode" name="productCode" class="form-control" required minlength="2" maxlength="10">
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-5">
                                            <div class="form-group">
                                                <label>Ciudad</label>
                                                <input type="text" id="city" name="city" class="form-control" required minlength="2" maxlength="50">
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-5">
                                            <div class="form-group">
                                                <label>Telefono</label>
                                                <input type="text" id="phone" name="phone" class="form-control" minlength="2" maxlength="50">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-12 col-sm-6">
                                            <div class="form-group">
                                                <label>Direccion 1</label>
                                                <input type="text" id="addressLine1" name="addressLine1" class="form-control" required minlength="2" maxlength="50">
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-6">
                                            <div class="form-group">
                                                <label>Direccion 2</label>
                                                <input type="text" id="addressLine2" name="addressLine2" class="form-control" minlength="2" maxlength="50">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-12 col-sm-6 col-md-3">
                                            <div class="form-group">
                                                <label>Estado</label>
                                                <input type="text" id="state" name="state" class="form-control" required minlength="2" maxlength="50">
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-6 col-md-3">
                                            <div class="form-group">
                                                <label>Pais</label>
                                                <input type="text" id="country" name="country" class="form-control" required minlength="2" maxlength="50">
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-6 col-md-3">
                                            <div class="form-group">
                                                <label>Codigo Postal</label>
                                                <input type="text" id="postalCode" name="postalCode" class="form-control" minlength="2" maxlength="15">
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-6 col-md-3">
                                            <div class="form-group">
                                                <label>Territorio</label>
                                                <input type="text" id="territory" name="territory" class="form-control" minlength="2" maxlength="10">
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
                                    <button class="btn btn-primary" onclick="return regUpdOffices()" >Realizar acción</button>
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
