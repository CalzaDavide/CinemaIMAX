<%@ page import="Data_tier.Film" %>
<%@ page import="Data_tier.FilmDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifica Film</title>
    <link rel="stylesheet" href="Css/ModificaFilm.css">
    <link rel="icon" type="image/x-icon" href="Images/LogoCircolare.jpeg">
</head>


<body>

<header>
    <jsp:include page="Header.jsp"/>
</header>

<script>
    var film = JSON.parse(sessionStorage.getItem("filmModifica"))
</script>

<% //Film film = (Film) "${film}" ; %>


<div id="Contenitore">

    <!-- H1 "Modifica Spettacolo" -->
    <div id="ModificaSpettacoloTextDiv">
        <h1>Modifica Spettacolo</h1>
    </div>

    <!-- Dopodichè si inseriscono gli altri parametri relativi al nuovo prodotto -->

    <form id="ModificaFilmContainer" action="modifica-film">

        <div id="DivVuoto">
            <br>
        </div>

        <!-- Titolo -->
        <div id="TitoloDiv">
            <label for="titolo">Titolo</label><br>
            <input required type="text" id="titolo" name="titolo" value="<%= film.getTitolo() %>">
        </div>

        <!-- Regista -->
        <div id="RegistaDiv">
            <label for="regista">Regista</label><br>
            <input required type="text" id="regista" name="regista" value="<%= film.getRegista() %>">
        </div>

        <!-- Attori -->
        <div id="AttoriDiv">
            <label for="attori">Attori</label><br>
            <input required type="text" id="attori" name="attori" value="<%= film.getAttori() %>">
        </div>

        <!-- Genere -->
        <div id="GenereDiv">
            <label for="genere">Genere</label><br>
            <input required type="text" id="genere" name="generi" value="<%= film.getGeneri() %>">
        </div>

        <!-- Durata -->
        <div id="DurataDiv">
            <label for="durata">Durata</label><br>
            <input required type="number" id="durata" name="durata" value="<%= film.getDurata() %>">
        </div>


        <!-- Descrizione <input required type="text" id="descrizione" name="descrizione" placeholder="Descrizione del film"> -->
        <div id="DescrizioneDiv">
            <label for="descrizione">Descrizione</label><br>
            <textarea required id="descrizione" rows="10" cols="60" ><%= film.getDescrizione() %></textarea>
        </div>

        <p><%= film.getId() %> </p>
        <input type="hidden" value="<%= film.getId() %>" name="id">

    </form>

    <!-- Invio -->
    <div id="InvioDiv">
        <button type="submit" id="pulsanteInvio">Invia</button>
    </div>

    <script>
        document.getElementById('pulsanteInvio').addEventListener('click', function () {
            document.getElementById('ModificaFilmContainer').submit();
        });
    </script>


</div>
</body>

</html>

