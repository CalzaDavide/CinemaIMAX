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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js">
    </script>
</head>


<body>

<header>
    <jsp:include page="SearchBar.jsp"/>
</header>

<%  ArrayList<Film> film = (ArrayList<Film>) request.getAttribute("film");
    if(film== null)
        film = (new FilmDAO()).doRetrieveAll();%>
<form action="filtra-film">
    <h1>filtri:</h1>
    <input name="filtroTitolo" type="text" placeholder="titolo">
    <input name="filtroGenere" type="text" placeholder="genere1, genere2, genere3,...">
    <input type="submit" value="FILTRA">
</form>


<% for (Film f : film){%>

<div class="row text-center" id="ContenitoreFilm">

    <div class="col-3"></div>

    <div class="col-9" id="ContenitoreTitolo">
        <h1><%= f.getTitolo() %></h1>
    </div>

    <div class="col-3 align-items-center" id="ContenitoreLocandinaFilm">
        <img src="<%= f.getLocandina() %>" alt="LocandinaFilm">
    </div>

    <div class="col-9" id="ContenitoreDescrizione">
        <p><%= f.getDescrizione() %></p>
    </div>

    <div class="col-5"></div>


    <% ArrayList<Proiezione> proiezioni = (new ProiezioneDAO().doRetrieveByIdFilm(f.getId()));%>

    <div class="col-5">
        <h1 style="font-size: 35px" >Proiezioni:</h1><br>

        <% for (Proiezione p : proiezioni){%>
                <form id="ViusalizzaPaginaProiezione" action="visualizza-pagina-proiezione">
                    <div id="proiezione" onclick="inviaForm()">
                        <p style="font-size: 17px">Orario: <%= p.getData() %> <%=  p.getOrario().toString().substring(0,5) %> Sala: <%= p.getSala().getId() %> Posti rimanenti: <%= p.getPosti() %>
                        <input type="hidden" name="idProiezione" value="<%= p.getId() %>">
                    </div>
                </form>
        <%}%>

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

<script>
    // Funzione che gestisce il clic sul div "proiezione"
    function inviaForm() {
        let form = document.getElementById('ViusalizzaPaginaProiezione');
        form.submit();
    }

</script>

</body>

</html>