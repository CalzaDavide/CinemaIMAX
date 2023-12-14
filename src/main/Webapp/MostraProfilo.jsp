<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Home Page</title>
    <link rel="stylesheet" type="text/css"     href="Css/mostraProfilo.css">

    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>

<header >
    <jsp:include page="SearchBar.jsp" />
</header>

<main>
<%-- <% Cliente cliente = (Cliente) session.getAttribute("utente"); %> --%>             <%--  --%>

<div id="mostraProfilo">
    <div id="benvenuto">
        <h1>Benvenuto, Michele !</h1>           <%-- <%= cliente.getNome()%> --%>
    </div>

    <div id="informazioniPersonali">
        <h2>NOME</h2>
        <p>Michele</p>
        <br>

        <h2>COGNOME</h2>
        <p>Battista</p>
        <br>

        <h2>EMAIL</h2>
        <p>Michele@cinemaimax.it</p>         <%-- <%= cliente.getEmail()%> --%>
        <br>

        <h2>PASSWORD</h2>
        <p>**********</p>

    </div>

</div>

</main>

</body>
</html>
