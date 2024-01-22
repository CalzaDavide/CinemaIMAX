<%@ page import="Data_tier.Moderatore" %>
<%@ page import="Data_tier.ModeratoreDAO" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Lista Moderatori</title>
    <link rel="stylesheet" href="Css/ListaModeratori.css">
    <link rel="icon" type="image/x-icon" href="Images/LogoCircolare.jpeg">
</head>
<body>

<header>
    <jsp:include page="Header.jsp"/>
</header>

<!-- Se si accede a questa pagina senza aver effettuato l'accesso o se il moderatore non è admin, si viene reindirizzati alla homepage-->
<% Moderatore moderatore = (Moderatore) session.getAttribute("utente");
    if (moderatore == null || !moderatore.isAdmin()) {%>
<jsp:forward page="index.jsp"></jsp:forward>
<%}%>

<div id="Contenitore">

    <%ArrayList<Moderatore> moderatori = (new ModeratoreDAO()).doRetrieveModeratori();%>
    <div id="ListaModeratori">
        <table>
            <tr>
                <th>NOME</th>
                <th>COGNOME</th>
                <th>E-MAIL</th>
                <th>Eliminare</th>
            </tr>

            <% for (Moderatore m : moderatori) {%>
            <tr>
                <td><%= m.getNome() %>
                </td>
                <td><%= m.getCognome() %>
                </td>
                <td><%= m.getEmail() %>
                </td>
                <td id="elimina">
                    <form action="elimina-moderatore">
                        <input type="hidden" name="id" value="<%=m.getId()%>">
                        <input type="submit" value="elimina">
                    </form>
                </td>
            </tr>
            <%}%>
        </table>
    </div>

</div>

</body>
</html>
