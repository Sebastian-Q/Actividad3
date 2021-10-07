<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <title>MENU PRINCIPAL</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=context%>/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand">Gestor de Consultas</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="Oficinas/Oficinas.jsp">Oficinas</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Productos/Productos.jsp">Productos</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="ProductosLinea/ProductosLinea.jsp">Productos en Linea</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Customer/Customer">Empleado</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<body>
</body>
</html>