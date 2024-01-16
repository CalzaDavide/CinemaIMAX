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
</head>


<body>

<header>
    <jsp:include page="SearchBar.jsp"/>
</header>

<%ArrayList<Film> film = (new FilmDAO()).doRetrieveAll();%>

<% for (Film f : film){%>

<div id="ContenitoreFilm">

    <div id="ContenitoreTitolo">
        <h1><%= f.getTitolo() %></h1>
    </div>

    <div id="ContenitoreLocandinaFilm">
        <img src="<%= f.getLocandina() %>" alt="LocandinaFilm">
    </div>

    <div id="ContenitoreDescrizione">
        <p><%= f.getDescrizione() %></p>
    </div>

    <div id="ContenitoreProiezione">
        <%ArrayList<Proiezione> proiezioni = (new ProiezioneDAO().doRetriveById(f.getId());%>
        <p><%= f.getDescrizione() %></p>
    </div>






</div>








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