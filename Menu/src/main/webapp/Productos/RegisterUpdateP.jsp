<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 06/10/2021
  Time: 08:27 p. m.
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
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand">Gestor de Productos</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="RegisterUpdateP.jsp">Registrar o Actualizar</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Productos.jsp">Consultar</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="DeleteP.jsp">Eliminar</a>
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
                                        <h2>Productos <i data-feather="aperture" class="text-secondary"></i></h2>
                                        <hr class="bg-secondary"/>
                                    </header>
                                </div>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-12 col-sm-6 col-md-2">
                                            <div class="form-group">
                                                <label>Codigo</label>
                                                <input type="text" id="productCode" name="productCode" class="form-control" required minlength="2" maxlength="15">
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-5">
                                            <div class="form-group">
                                                <label>Nombre Producto</label>
                                                <input type="text" id="productName" name="productName" class="form-control" required minlength="2" maxlength="70">
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-5">
                                            <div class="form-group">
                                                <label>Producto en Line</label>
                                                <input type="text" id="productLine" name="productLine" class="form-control" minlength="2" maxlength="50">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-12 col-sm-6 col-md-2">
                                            <div class="form-group">
                                                <label>Escala de Producto</label>
                                                <input type="text" id="productScale" name="productScale" class="form-control" required minlength="2" maxlength="10  ">
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-5">
                                            <div class="form-group">
                                                <label>Vendedor</label>
                                                <input type="text" id="productVendor" name="productVendor" class="form-control" required minlength="2" maxlength="50">
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-5">
                                            <div class="form-group">
                                                <label>Descripcion</label>
                                                <input type="text" id="productDescription" name="productDescription" class="form-control" minlength="2" maxlength="100">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-12 col-sm-6 col-md-4">
                                            <div class="form-group">
                                                <label>QuantityInStock</label>
                                                <input type="number" id="quantityInStock" name="quantityInStock" class="form-control" required minlength="2" maxlength="6">
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-6 col-md-4">
                                            <div class="form-group">
                                                <label>Precio</label>
                                                <input type="number" id="buyPrice" name="buyPrice" class="form-control" required minlength="2" maxlength="50">
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-6 col-md-4">
                                            <div class="form-group">
                                                <label>MSRP</label>
                                                <input type="number" id="MSRP" name="MSRP" class="form-control" minlength="2" maxlength="100">
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
                                    <button class="btn btn-primary" onclick="return regUpdProducts()" >Realizar acción</button>
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
