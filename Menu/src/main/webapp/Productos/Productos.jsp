<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 06/10/2021
  Time: 08:10 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath(); %>
<html>
<head>
    <title>Productos</title>
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
    <div class="container bg-secondary text-light mt-2">
        <form>
            <div class="row p-2">
                <div class="col-12 col-md-8">
                    <div class="form-group">
                        <label for="productCode">Búsqueda por código de producto: </label>
                        <input type="text" name="productCode" id="productCode" class="form-control">
                    </div>
                </div>
                <div class="col-12 col-md-4 align-self-center text-right">
                    <button type="submit" class="btn btn-success" style="width: 100%;"
                            onclick="return getProduct()">Buscar</button>
                </div>
                <div class="col-12  text-center mt-2">
                    <button class="btn btn-dark" onclick="return getProducts()">Cargar registros</button>
                </div>
            </div>
        </form>
    </div>
</section>

<section>
    <div class="container">
        <table id="table" class="table table-striped table-dark mt-2 table-responsive">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Codigo de Producto</th>
                <th scope="col">Nombre Producto</th>
                <th scope="col">Producto en Linea</th>
                <th scope="col">Escala de Producto</th>
                <th scope="col">Vendedor del Producto</th>
                <th scope="col">Descripción</th>
                <th scope="col">QuantityInStock</th>
                <th scope="col">Precio</th>
                <th scope="col">MSRP</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
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
