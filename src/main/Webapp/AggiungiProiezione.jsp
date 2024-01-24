<%@ page import="java.util.ArrayList" %>
<%@ page import="Data_tier.*" %>
<%@ page import="java.sql.SQLException" %>
<html>
<head>
    <title>Aggiungi Proiezione</title>
    <link rel="stylesheet" href="Css/AggiungiProiezione.css">
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

    <!-- H1 "Aggiungi Proiezione" -->
    <div id="AggiungiProiezioneTextDiv">
        <h1>Aggiungi Proiezione</h1>
    </div>


    <form id="AggiungiProiezioneContainer" action="aggiungi-Proiezione-Servlet" method="post">


        <% ArrayList<Film> film = null;
            try {
                film = (new InterfaceMod()).recuperaFilms();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } %>
        <!-- Film -->
        <div id="SelezionaFilmDiv">
            <label for="Film">Film</label><br>
            <select required id="Film" name="Film">
                <% for (Film f : film) {%>
                <option value="<%=f.getId()%>">Id: (<%=f.getId()%>) <%=f.getTitolo()%>
                </option>
                <%}%>
            </select>
        </div>


        <!-- Data -->
        <div id="DataDiv">
            <label for="Data">Data</label><br>
            <input required type="text" id="Data" name="Data" placeholder="Data del film (giorno-mese-anno)">
        </div>

        <!-- Orario -->
        <div id="OrarioDiv">
            <label for="Orario">Orario</label><br>
            <input required type="text" id="Orario" name="Orario" placeholder="Orario del film (ora:minuti)">
        </div>


        <% ArrayList<Sala> sala = (new InterfaceMod()).recuperaSale(); %>
        <!-- Sala -->
        <div id="SalaDiv">
            <label for="Sala">Sala</label><br>
            <select required id="Sala" name="Sala">
                <% for (Sala s : sala) {%>
                <option value="<%=s.getId()%>"> Sala <%=s.getId()%> (Numero posti: <%=s.getMaxPosti()%>)</option>
                <%}%>
            </select>

        </div>

        <div id="InvioDiv">
            <button type="submit" id="pulsanteInvio">Invia</button>
        </div>
    </form>


</div>
</body>

</html>
