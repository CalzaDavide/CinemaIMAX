<%@ page import="Data_tier.Proiezione" %>
<%@ page import="Data_tier.ProiezioneDAO" %>
<%@ page import="Data_tier.Film" %>
<%@ page import="Data_tier.FilmDAO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>

<html>

<head>
    <title>Homepage</title>
    <link rel="icon" type="image/x-icon" href="Images/LogoCircolare.jpeg">
    <link rel="stylesheet" href="Css/Index.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>


<body>

<header>
    <jsp:include page="SearchBar.jsp"/>
</header>

<%ArrayList<Film> film = (new FilmDAO()).doRetrieveAll();%>

<% for (Film f : film){%>

<div class="row text-center" id="ContenitoreFilm">

    <div class="col-4"></div>

    <div class="col-8" id="ContenitoreTitolo">
        <h1><%= f.getTitolo() %></h1>
    </div>

    <div class="col-4" id="ContenitoreLocandinaFilm">
        <img src="<%= f.getLocandina() %>" alt="LocandinaFilm">
    </div>

    <div class="col-8" id="ContenitoreDescrizione">
        <p><%= f.getDescrizione() %></p>
    </div>

    <div class="col-4 " id="ContenitoreProiezione">
        <p>Proiezioni:</p>
    </div>

    <% ArrayList<Proiezione> proiezioni = (new ProiezioneDAO().doRetrieveByIdFilm('1'));%>

    <div class="col-8">
        <% for (Proiezione p : proiezioni){%>
            <p>Orario: <%= p.getData_ora() %> Sala: p.<%= p.getSala() %> Posti rimanenti: <%= p.getPosti() %> </p> <%-- Convertirlo in solo data --%>
        <%}%>
    </div>

</div>





<%--
<div id="ContenitoreProiezione">
pisello

<%ArrayList<Proiezione> proiezioni = (new ProiezioneDAO().doRetriveByIdFilm(f.getId())%>
<p><%= f.getDescrizione() %></p>
    </div>
--%>





<%}%>



<a href="AggiungiFilm.jsp">Aggiungi Film</a><br>
<a href="AggiungiProiezione.jsp">Aggiungi Proiezione</a><br>
<a href="ListaModeratori.jsp">Lista Moderatori</a><br>
<a href="Login.jsp">Login</a><br>
<a href="ModificaFilm.jsp">Modifica Film</a><br>
<a href="ModificaProiezione.jsp">Modifica Proiezione</a><br>
<a href="MostraProfilo.jsp">Mostra Profilo</a><br>



</body>

</html>