<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi Film</title>
    <link rel="stylesheet" href="Css/AggiungiProiezione.css">
</head>


<body>

<header><jsp:include page="SearchBar.jsp"/></header>


<div id="Contenitore">

    <!-- H1 "Aggiungi Proiezione" -->
    <div id="AggiungiProiezioneTextDiv">
        <h1>Aggiungi Proiezione</h1>
    </div>



    <form id="AggiungiProiezioneContainer" action="aggiungi-prodotto">



        <div id="SelezionaFilmDiv">
            <label for="Film">Film</label><br>
            <select required id="Film" name="Film" >
                <option value="0">Film 1</option>
                <option value="1">Film 2</option>
                <option value="2">Film 3</option>
            </select>
        </div>


        <!-- Data -->
        <div id="DataDiv">
            <label for="Data">Data</label><br>
            <input required type="text" id="Data" name="Data" placeholder="Data del film (separare con una virgola)">
        </div>

        <!-- Orario -->
        <div id="OrarioDiv">
            <label for="Orario">Regista</label><br>
            <input required type="text" id="Orario" name="Orario" placeholder="Orario del film (separare con una virgola)">
        </div>


        <!-- Sala -->
        <div id="SalaDiv">
            <label for="Sala">Sala</label><br>
            <select required id="Sala" name="Sala">
                <option value="1">Sala 1</option>
                <option value="2">Sala 2</option>
                <option value="3">Sala 3</option>
                <option value="4">Sala 4</option>
                <option value="5">Sala 5</option>
                <option value="6">Sala 6</option>
            </select>
        </div>

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



</div>
</body>

</html>

