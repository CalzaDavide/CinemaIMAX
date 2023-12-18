<%@ page contentType="text/html;charset=UTF-8" %>
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
    <div id="searchbar">
        <form action="mostra-prodotti" id="cercaForm">
            <input type="text" name="ricerca" id="cercaInput">
            <button id="cerca"> <img style="transform: scaleX(-1);" src="Images/iconaCerca.png" alt="Cerca"></button>
        </form>
    </div>

</body>
</html>
