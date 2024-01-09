<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<head>
  <title>JSP - Hello World</title>
</head>



<body>

<header >
  <jsp:include page="SearchBar.jsp" />
</header>

<br>
<h1><%= "Hello World!" %></h1>
<br>

<a href="AggiungiFilm.jsp">Aggiungi Film</a><br>
<a href="AggiungiProiezione.jsp">Aggiungi Proiezione</a><br>
<a href="ListaModeratori.jsp">Lista Moderatori</a><br>
<a href="Login.jsp">Login</a><br>
<a href="ModificaFilm.jsp">Modifica Film</a><br>
<a href="ModificaProiezione.jsp">Modifica Proiezione</a><br>
<a href="MostraProfilo.jsp">Mostra Profilo</a><br>

</body>

</html>