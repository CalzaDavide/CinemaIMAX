<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifica Film</title>
    <link rel="stylesheet" href="Css/ModificaFilm.css">
</head>


<body>

<header>
    <jsp:include page="SearchBar.jsp"/>
</header>


<div id="Contenitore">

    <!-- H1 "Modifica Spettacolo" -->
    <div id="ModificaSpettacoloTextDiv">
        <h1>Modifica Spettacolo</h1>
    </div>

    <!-- Dopodichè si inseriscono gli altri parametri relativi al nuovo prodotto -->

    <form id="ModificaFilmContainer" action="Modifica-prodotto">

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
            <label for="genere">Genere</label><br>
            <input required type="text" id="genere" name="genere" placeholder="Generi (separati da una virgola)">
        </div>

        <!-- Durata -->
        <div id="DurataDiv">
            <label for="durata">Durata</label><br>
            <input required type="number" id="durata" name="durata">
        </div>


        <!-- Descrizione <input required type="text" id="descrizione" name="descrizione" placeholder="Descrizione del film"> -->
        <div id="DescrizioneDiv">
            <label for="descrizione">Descrizione</label><br>
            <textarea required id="descrizione" rows="10" cols="60" placeholder="Descrizione"></textarea>
        </div>

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

