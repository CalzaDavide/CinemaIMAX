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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>


<body>

<header>
    <jsp:include page="SearchBar.jsp"/>
</header>

<% ArrayList<Proiezione> proiezioni;%>
<% Moderatore moderatore = (Moderatore) session.getAttribute("utente");%>

<% ArrayList<Film> film = (ArrayList<Film>) request.getAttribute("film");
    if (film == null)
        film = (new FilmDAO()).doRetrieveAll();%>


<% for (Film f : film) {%>

<div class="row text-center" id="ContenitoreFilm">

    <div class="col-3"></div>

    <div class="col-9" id="ContenitoreTitolo">
        <h1><%= f.getTitolo() %>
        </h1>

        <%if (moderatore != null && !moderatore.isAdmin()) { %>
        <a href="ModificaFilm.jsp" id="linkProiezione" onclick="(<% session.setAttribute("idFilm", f.getId());%>)"><i class="fa-solid fa-pen-to-square"></i></a>

        <form id="eliminaFilmForm" action="elimina-film" method="post">
            <input type="hidden" value="<%=f.getId()%>" name="film">
            <i id="EliminaFilmPulsante"  class="fa-regular fa-trash-can"></i>
        </form>


        <%} else {}%>
    </div>

    <div class="col-3 align-items-center" id="ContenitoreLocandinaFilm">
        <img src="<%= f.getLocandina() %>" alt="LocandinaFilm">
    </div>

    <div class="col-9" id="ContenitoreDescrizione">
        <p><%= f.getDescrizione() %>
        </p>
    </div>

    <div class="col-5"></div>


    <% proiezioni = (new ProiezioneDAO().doRetrieveByIdFilm(f.getId()));%>

    <div class="col-5">
        <h1 style="font-size: 35px">Proiezioni:</h1><br>

        <% for (Proiezione p : proiezioni) {%>
        <form id="ViusalizzaPaginaProiezione<%= p.getId() %>" action="visualizza-pagina-proiezione" method="post">
            <div id="proiezione" onclick="inviaFormProiezione(<%= p.getId() %>)">
                <p style="font-size: 17px">Orario: <%= p.getData() %> <%=  p.getOrario().toString().substring(0,5) %>
                    Sala: <%= p.getSala().getId() %> Posti rimanenti: <%= p.getPosti() %>
                    <input type="hidden" name="idProiezione" value="<%= p.getId() %>">
            </div>
        </form>
            <%if (moderatore != null && !moderatore.isAdmin()) { %>

            <form id="eliminaProiezioneForm" action="elimina-proiezione" method="post">
                <input type="hidden" value="<%=p.getId()%>" name="proiezione">
                <i id="EliminaProiezionePulsante"  class="fa-regular fa-trash-can"></i>
            </form>


        <%} else {}%>
        <%}%>
    </div>

</div>

<%}%>


<script>
    // Funzione che gestisce il clic sul div "proiezione"
    function inviaFormProiezione(id) {

        let form = document.getElementById('ViusalizzaPaginaProiezione' + id);
        form.submit();
    }


        document.getElementById('EliminaFilmPulsante').addEventListener('click', function () {
        document.getElementById('eliminaFilmForm').submit();
        });

        document.getElementById('EliminaProiezionePulsante').addEventListener('click', function () {
        document.getElementById('eliminaProiezioneForm').submit();
        });




</script>



</body>

</html>