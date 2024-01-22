<%@ page import="Data_tier.Film" %>
<%@ page import="Data_tier.FilmDAO" %>
<%@ page import="Data_tier.Moderatore" %>
<%@ page import="Data_tier.InterfaceMod" %>
<html>
<head>
    <title>Modifica Film</title>
    <link rel="stylesheet" href="Css/ModificaFilm.css">
    <link rel="icon" type="image/x-icon" href="Images/LogoCircolare.jpeg">
</head>


<body>

<!-- Se si accede a questa pagina senza aver effettuato l'accesso o se il moderatore è admin, si viene reindirizzati alla homepage-->
<% Moderatore moderatore = (Moderatore) session.getAttribute("utente");
    if (moderatore == null || moderatore.isAdmin()) {%>
<jsp:forward page="index.jsp"></jsp:forward>
<%}%>

<header>
    <jsp:include page="Header.jsp"/>
</header>


<%  int idFilm = Integer.parseInt(request.getParameter("idFilm"));
    Film film = new FilmDAO().doRetriveById(idFilm); %>


<div id="Contenitore">

    <!-- H1 "Modifica Spettacolo" -->
    <div id="ModificaSpettacoloTextDiv">
        <h1>Modifica Spettacolo</h1>
    </div>

    <!-- Dopodichè si inseriscono gli altri parametri relativi al nuovo prodotto -->

    <form id="ModificaFilmContainer" action="modifica-film" method="post">

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
            <input required type="text" id="regista" name="regista" value="<%= film.getDescrizione() %>">
        </div>

        <!-- Attori -->
        <div id="AttoriDiv">
            <label for="attori">Attori</label><br>
            <input required type="text" id="attori" name="attori" value="<%= film.getAttori() %>">
        </div>

        <!-- Generi -->
        <div id="GeneriDiv">
            <label for="generi">Generi</label><br>
            <input required type="text" id="generi" name="generi" value="<%= film.getGeneri() %>">
        </div>

        <!-- Durata -->
        <div id="DurataDiv">
            <label for="durata">Durata</label><br>
            <input required type="number" id="durata" name="durata" value="<%= film.getDurata() %>">
        </div>


        <!-- Descrizione <input required type="text" id="descrizione" name="descrizione" placeholder="Descrizione del film"> -->
        <div id="DescrizioneDiv">
            <label for="descrizione">Descrizione</label><br>
            <textarea required id="descrizione" rows="10" cols="60"
                      name="descrizione"><%= film.getRegista() %></textarea>
        </div>

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

