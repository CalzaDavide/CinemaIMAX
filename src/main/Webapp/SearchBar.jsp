<%@ page import="Data_tier.Moderatore" %>
<!DOCTYPE html>
<html lang="it">

<head>
    <title>Searchbar</title>
    <link rel="stylesheet" type="text/css"     href="Css/SearchBar.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<% Moderatore moderatore = (Moderatore) session.getAttribute("utente");%>


    <%-- Searchbar --%>

    <div class="row">
        <a class="col-1" id="logoSito"  href="index.jsp"><img src="Images/LogoRettangolare.jpeg" alt="Homepage" style="width:113px;height:100px;"></a>
        <p class="col-2"></p>
        <form class="row col-6" action="filtra-film" id="cercaForm">
                <input class="col-5"  type="text" name="filtroTitolo" id="cercaInput" placeholder="Filtro per Titolo">
                <input class="col-5" name="filtroGeneri" type="text" id="filtroGeneri" placeholder="Filtro per Genere">
                <button class="col-1" id="cerca"> <img style="transform: scaleX(-1);" src="Images/iconaCerca.png" alt="Cerca"></button>
        </form>

        <p class="col-2"></p>


        <%if (moderatore != null){ %>
        <div id="menu-btn" onclick="openNav()" class="col-1 fs-2"><i class="fa-solid fa-bars"></i></div>
        <div id="sidebar" class="col-1">
            <a class="btn" href="#" onclick="closeNav()">Chiudi</a>
            <%if (moderatore.isAdmin()){%>
                <a href="AggiungiModeratore.jsp">Aggiungi Moderatore</a><br>
                <a href="ListaModeratori.jsp">Lista Moderatori</a><br>
            <% } else{%>
                <a href="AggiungiFilm.jsp">Aggiungi Film</a><br>
                <a href="AggiungiProiezione.jsp">Aggiungi Proiezione</a><br>
            <%}%>

            <a href="MostraProfilo.jsp">Mostra Profilo</a><br>

            <form action="logout">
                <button id="logOutButton" >LogOut</button>
            </form>

        </div>
        <%} else{%>
            <p class="col-1"></p>
        <%}%>

    </div>

    <script>
        function openNav() {
            document.getElementById("sidebar").style.width = "250px";
            document.getElementById("menu-btn").style.display="none";
        }

        function closeNav() {
            document.getElementById("sidebar").style.width = "0";
            document.getElementById("menu-btn").style.display="block";
        }
    </script>


</html>
