<%@ page import="java.util.ArrayList" %>
<%@ page import="Data_tier.*" %>
<!DOCTYPE html>

<html>

<head>
    <title>Homepage</title>
    <link rel="icon" type="image/x-icon" href="Images/LogoCircolare.jpeg">
    <link rel="stylesheet" href="Css/Index.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js">
    </script>
</head>


<body>

<header>
    <jsp:include page="SearchBar.jsp"/>
</header>

<% ArrayList<Proiezione> proiezioni;%>
<% Moderatore moderatore = (Moderatore) session.getAttribute("utente");%>

<%  ArrayList<Film> film = (ArrayList<Film>) request.getAttribute("film");
    if(film== null)
        film = (new FilmDAO()).doRetrieveAll();%>


<% for (Film f : film){%>

<div class="row text-center" id="ContenitoreFilm">

    <div class="col-3"></div>

    <div class="col-9" id="ContenitoreTitolo">
        <h1><%= f.getTitolo() %></h1>

        <%if ( moderatore != null && !moderatore.getIsAdmin()) { %>
        <form id="ModificaFilm<%= f.getId() %>" action="modifica-film" >
            <div id="modificaFilm" onclick="inviaFormModificaFilm(<%= f.getId() %>)">
                <img src="Images/IconaModifica.png" alt="iconaModifica" style="width: 40px">
                <input type="hidden" name="idFilm" value="<%= f.getId() %>">
            </div>
        </form>

        <%} else{} %>
    </div>

    <div class="col-3 align-items-center" id="ContenitoreLocandinaFilm">
        <img src="<%= f.getLocandina() %>" alt="LocandinaFilm">
    </div>

    <div class="col-9" id="ContenitoreDescrizione">
        <p><%= f.getDescrizione() %></p>
    </div>

    <div class="col-5"></div>


    <% proiezioni = (new ProiezioneDAO().doRetrieveByIdFilm(f.getId()));%>

    <div class="col-5">
        <h1 style="font-size: 35px">Proiezioni:</h1><br>

        <% for (Proiezione p : proiezioni) {%>
            <form id="ViusalizzaPaginaProiezione<%= p.getId() %>" action="visualizza-pagina-proiezione" >
                <div id="proiezione" onclick="inviaFormProiezione(<%= p.getId() %>)">
                    <p style="font-size: 17px">Orario: <%= p.getData() %> <%=  p.getOrario().toString().substring(0,5) %>
                        Sala: <%= p.getSala().getId() %> Posti rimanenti: <%= p.getPosti() %>
                        <input type="hidden" name="idProiezione" value="<%= p.getId() %>">
                </div>
            </form>
        <%}%>
    </div>

</div>

<%}%>


<a href="AggiungiFilm.jsp">Aggiungi Film</a><br>
<a href="AggiungiProiezione.jsp">Aggiungi Proiezione</a><br>
<a href="ListaModeratori.jsp">Lista Moderatori</a><br>
<a href="Login.jsp">Login</a><br>
<a href="ModificaFilm.jsp">Modifica Film</a><br>
<a href="MostraProfilo.jsp">Mostra Profilo</a><br>
<a href="AggiungiModeratore.jsp">Aggiungi Moderatore</a><br>

<script>
    // Funzione che gestisce il clic sul div "proiezione"
    function inviaFormProiezione(id) {

        let form = document.getElementById('ViusalizzaPaginaProiezione' + id);
        form.submit();
    }

    function inviaFormModificaFilm(id) {

        let form = document.getElementById('ModificaFilm' + id);
        form.submit();
    }


</script>

</body>

</html>