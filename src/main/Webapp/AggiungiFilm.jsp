<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi Film</title>
    <link rel="stylesheet" href="Css/AggiungiFilm.css">
</head>


<body>

<header><jsp:include page="SearchBar.jsp"/></header>


<div id="Contenitore">

    <!-- H1 "Aggiungi Spettacolo" -->
    <div id="AggiungiSpettacoloTextDiv">
        <h1>Aggiungi Spettacolo</h1>
    </div>


    <!-- Avviene prima l'upload dell'immagine -->
    <%String immagine = (String) request.getAttribute("uploaded");
        if (immagine == null) {%>

    <div id="CaricaCopertinaDiv">
        <form action="Upload" method="post" enctype="multipart/form-data">
            <input required id="caricaCopertinaFile" type="file" name="file"/><br>
            <button id="caricaCopertinaPulsante" type="submit">INVIA</button>
        </form>
    </div>


    <!-- Dopodichè si inseriscono gli altri parametri relativi al nuovo prodotto -->
    <%} else {%>


    <form id="AggiungiFilmContainer" action="aggiungi-prodotto">

        <div id="DivVuoto">
            <br>
        </div>

        <!-- Titolo -->
        <div id="TitoloDiv">
            <label for="titolo">Titolo</label>
            <input required type="text" id="titolo" name="titolo" placeholder="Titolo del film">
        </div>

        <!-- Regista -->
        <div id="RegistaDiv">
            <label for="regista">Regista</label>
            <input required type="text" id="regista" name="regista">
        </div>

        <!-- Attori -->
        <div id="AttoriDiv">
            <label for="attori">Attori</label>
            <input required type="text" id="attori" name="attori">
        </div>

        <!-- Genere -->
        <div id="GenereDiv">
            <label for="genere">Genere</label>
            <input required type="text" id="genere" name="genere">
        </div>

        <!-- Durata -->
        <div id="DurataDiv">
            <label for="durata">Durata</label>
            <input required type="text" id="durata" name="durata">
        </div>


        <!-- Descrizione -->
        <div id="DescrizioneDiv">
            <label for="descrizione">Descrizione</label>
            <input required type="text" id="descrizione" name="descrizione" placeholder="Descrizione del film">
        </div>


        <input type="hidden" name="immagine" value="<%=immagine%>">

        <!-- Invio -->
        <div id="InvioDiv">
            <button type="submit">Invia</button>
        </div>

    </form>
    <%}%>


</div>
</body>

</html>

