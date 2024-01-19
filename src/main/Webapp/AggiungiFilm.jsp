<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi Film</title>
    <link rel="stylesheet" href="Css/AggiungiFilm.css">
    <link rel="icon" type="image/x-icon" href="Images/LogoCircolare.jpeg">
</head>


<body>

<header><jsp:include page="SearchBar.jsp"/></header>


<div id="Contenitore">

    <!-- H1 "Aggiungi Film" -->
    <div id="AggiungiFilmTextDiv">
        <h1>Aggiungi Film</h1>
    </div>


    <!-- Avviene prima l'upload dell'immagine -->
    <%String immagine = (String) request.getAttribute("uploaded");
        if (immagine == null) {%>

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
            <label for="generi">Genere</label><br>
            <input required type="text" id="generi" name="generi" placeholder="Generi (separati da una virgola)">
        </div>

        <!-- Durata -->
        <div id="DurataDiv">
            <label for="durata">Durata</label><br>
            <input required type="number" id="durata" name="durata" placeholder="60">
        </div>


        <!-- Descrizione <input required type="text" id="descrizione" name="descrizione" placeholder="Descrizione del film"> -->
        <div id="DescrizioneDiv">
            <label for="descrizione">Descrizione</label><br>
            <textarea required id="descrizione" rows="10" cols="60" placeholder="Descrizione" name="descrizione"></textarea>
        </div>


        <input type="hidden" name="immagine" value="<%=immagine%>">
    </form>

    <!-- Invio -->
    <div id="InvioDiv">
        <button type="submit" id="pulsanteInvio">Invia</button>
    </div>

    <script>
        document.getElementById('pulsanteInvio').addEventListener('click', function() {
            document.getElementById('AggiungiFilmContainer').submit();
        });
    </script>

    <%}%>


</div>
</body>

</html>

