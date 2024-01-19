<!DOCTYPE html>
<html lang="it">

<head>
    <title>Header </title>
    <link rel="stylesheet" type="text/css"     href="Css/CssGlobale.css">
    <link rel="stylesheet" type="text/css"     href="Css/SearchBar.css">

    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
    <%-- Searchbar --%>

    <div class="row">
        <a class="col-1" id="logoSito"  href="index.jsp"><img src="Images/LogoRettangolare.jpeg" alt="Homepage" style="width:113px;height:100px;"></a>
        <p class="col-2"></p>
        <form class="row col-6" action="filtra-film" id="cercaForm">
                <input class="col-5"  type="text" name="filtroTitolo" id="cercaInput" placeholder="Filtro per Titolo">
                <input class="col-5" name="filtroGenere" type="text" id="filtroGenere" placeholder="Filtro per Genere">
                <button class="col-1" id="cerca"> <img style="transform: scaleX(-1);" src="Images/iconaCerca.png" alt="Cerca"></button>
        </form>
        <p class="col-3"></p>
    </div>

</body>
</html>
