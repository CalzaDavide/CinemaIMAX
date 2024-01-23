<%@ page import="Data_tier.Moderatore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi Film</title>
    <link rel="stylesheet" href="Css/AggiungiFilm.css">
    <link rel="icon" type="image/x-icon" href="Images/LogoCircolare.jpeg">
</head>


<body>

<header>
    <jsp:include page="Header.jsp"/>
</header>

<!-- Se si accede a questa pagina senza aver effettuato l'accesso o se il moderatore è admin, si viene reindirizzati alla homepage-->
<% Moderatore moderatore = (Moderatore) session.getAttribute("utente");
    if (moderatore == null || moderatore.isAdmin()) {%>
        <jsp:forward page="index.jsp"></jsp:forward>
<%}%>


<div id="Contenitore">

    <!-- H1 "Aggiungi Film" -->
    <div id="AggiungiFilmTextDiv">
        <h1>Aggiungi Film</h1>
    </div>


    <!-- Avviene prima l'upload dell'immagine -->
    <%
        String immagine = (String) request.getAttribute("uploaded");
        if (immagine == null) {
    %>

    <div id="CaricaCopertinaDiv">
        <form action="Upload" method="post" enctype="multipart/form-data">
            <input required id="caricaCopertinaFile" type="file" name="file"/><br>
            <button id="CaricaCopertinaPulsante" type="submit">INVIA</button>
        </form>
    </div>


    <!-- Dopodichè si inseriscono gli altri parametri relativi al nuovo prodotto -->
    <%} else {%>

    <form id="AggiungiFilmContainer" action="aggiungi-film-servlet">

        <div id="DivVuoto">
            <br>
        </div>

        <!-- Titolo -->
        <div id="TitoloDiv">
            <label for="titolo">Titolo</label><br>
            <input required type="text" id="titolo" name="titolo" placeholder="Titolo del film">
        </div>

        <!-- Regista -->
        <div id="RegistaDiv">
            <label for="regista">Regista</label><br>
            <input required type="text" id="regista" name="regista" placeholder="Regista del film">
        </div>

        <!-- Attori -->
        <div id="AttoriDiv">
            <label for="attori">Attori</label><br>
            <input required type="text" id="attori" name="attori" placeholder="Attori (separati da una virgola)">
        </div>

        <!-- Genere -->
        <div id="GenereDiv">
            <label for="generi">Generi</label><br>
            <input required type="text" id="generi" name="generi" placeholder="Generi (separati da una virgola)">
        </div>

        <!-- Durata -->
        <div id="DurataDiv">
            <label for="durata">Durata</label><br>
            <input required type="number" id="durata" name="durata" placeholder="60" min="1">
        </div>


        <!-- Descrizione <input required type="text" id="descrizione" name="descrizione" placeholder="Descrizione del film"> -->
        <div id="DescrizioneDiv">
            <label for="descrizione">Descrizione</label><br>
            <textarea required id="descrizione" rows="10" cols="60" placeholder="Descrizione"
                      name="descrizione"></textarea>
        </div>


        <input type="hidden" name="immagine" value="<%=immagine%>">
    </form>

    <!-- Invio -->
    <div id="InvioDiv">
        <button type="submit" id="pulsanteInvio">Invia</button>
    </div>

    <script>
        document.getElementById('pulsanteInvio').addEventListener('click', function () {
            document.getElementById('AggiungiFilmContainer').submit();
        });
    </script>

    <%}%>


</div>
</body>

</html>

