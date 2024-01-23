<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="Data_tier.Moderatore" %>
<!DOCTYPE html>
<html>
<head><title>Mostra Profilo</title>
    <link rel="stylesheet" type="text/css" href="Css/MostraProfilo.css">
    <link rel="icon" type="image/x-icon" href="Images/LogoCircolare.jpeg">

    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>

<header>
    <jsp:include page="Header.jsp"/>
</header>
<% Moderatore moderatore = (Moderatore) session.getAttribute("utente"); %>

<!-- Se si accede a questa pagina senza aver effettuato l'accesso, si viene reindirizzati alla homepage-->
<% if (moderatore == null) {%>
    <jsp:forward page="index.jsp"></jsp:forward>
<%}
    assert moderatore != null;
%>

<main>


    <div id="MostraProfilo">
        <div id="Benvenuto">
            <h1>Benvenuto, <%= moderatore.getNome()%> !</h1> <%-- --%>
        </div>

        <div id="InformazioniPersonali">
            <h2>NOME</h2>
            <p><%= moderatore.getNome()%>
            </p>
            <br>

            <h2>COGNOME</h2>
            <p><%= moderatore.getCognome()%>
            </p>
            <br>

            <h2>EMAIL</h2>
            <p><%= moderatore.getEmail()%>
            </p> <%-- --%>
            <br>

            <form action="modifica-password" method="post" id="modificaForm">
                <input type="hidden" name="email" value="<%= moderatore.getEmail()%>">
                <input type="password" name="oldPassword" placeholder="Vecchia Password"><br>
                <input type="password" name="newPassword" placeholder="Nuova Password"><br>
                <input type="submit" value="invia">
            </form>

        </div>

    </div>

</main>

</body>
</html>
