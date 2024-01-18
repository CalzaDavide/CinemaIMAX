<%@ page import="Data_tier.Proiezione" %>
<%@ page import="Data_tier.ProiezioneDAO" %>
<%@ page import="Data_tier.Film" %>
<%@ page import="Data_tier.FilmDAO" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Acquista</title>
    <link rel="stylesheet" href="Css/PaginaProiezione.css">
    <link rel="icon" type="image/x-icon" href="Images/LogoCircolare.jpeg">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

    <% Proiezione proiezione = (Proiezione) request.getAttribute("proiezione"); %>
    <% Film film = proiezione.getFilm(); %>


<div class="row" id="Contenitore">

    <div class="col-3"></div>

    <div class="col-9 text-center" id="ContenitoreTitolo">
        <h1><%= film.getTitolo() %></h1>
    </div>

    <div class="col-3 align-content-center" id="ContenitoreLocandinaFilm">
        <img src="<%= film.getLocandina() %>" alt="LocandinaFilm">
    </div>

    <div class="col-9 text-center" id="ContenitoreDescrizione">
        <p><%= film.getRegista() %></p>
    </div>




    <div class="col-4" style="margin-left: 1%">
        <form class="row" id="AcquistoBiglietto" action="acquisto-servlet">
            <p class="col-9">Sala Spettacolo:</p>                           <p class="col-3"><%= proiezione.getSala().getId()%> </p>
            <p class="col-9">Orario Spettacolo:</p>                         <p class="col-3"><%=  proiezione.getOrario().toString().substring(0,5) %> </p>
            <label class="col-9" for="numeroBiglietti">Numero Biglietti:    </label> <input class="col-3" type="number" required name="numeroBiglietti" id="numeroBiglietti" placeholder="1" min="1" max="<%= proiezione.getPosti() %>" oninput="calcoloCostoBiglietti()"/>
            <label class="col-9" for="nome">Numero Biglietti:    </label>   <input class="col-3" type="text" required name="nome" id="nome" placeholder="Nome"/>
            <label class="col-9" for="cognome">Numero Biglietti:  </label>  <input class="col-3" type="text" required name="cognome" id="cognome" placeholder="Cognome"/>
            <label class="col-9" for="email">Numero Biglietti:    </label>  <input class="col-3" type="email" required name="email" id="email" placeholder="E-mail"/>
            <p class="col-9">Costo Biglietti:</p>                           <p class="col-3" id="costoBiglietti">7 euro</p>
            <p class="col-9">Metodo di pagamento:</p>                       <p class="col-3">Paypal</p>
            <input type="hidden" value="<%= proiezione.getId() %>">
            <div class="col-4"></div> <input class="col-4 text-center" type="submit" value="Acquista Biglietti"><div class="col-4"></div>
        </form>
    </div>

    <div class="col-3 "></div>

    <div class="col-3 ">
        <div class="row" id="ContenitoreInformazioniFilm">
            <p class="col-6 big">Generi:</p>  <p class="col-6"><%= film.getGeneri()%></p>
            <p class="col-6 big">Attori:</p>  <p class="col-6"><%= film.getAttori()%></p>
            <p class="col-6 big">Regista:</p> <p class="col-6"><%= film.getDescrizione()%></p>
        </div>
    </div>

    <div class="col-1"></div>

</div>






    <script>
        function calcoloCostoBiglietti() {
            // Ottieni il valore inserito dall'utente
            var numeroBiglietti = document.getElementById('numeroBiglietti').value;

            // Verifica se l'input è un numero valido
            if (isNaN(numeroBiglietti)) {
                document.getElementById('costoBiglietti').innerText = 'Inserisci un numero valido';
                return;
            }

            // Effettua la moltiplicazione per 7
            var risultato = numeroBiglietti * 7;

            // Mostra il risultato senza aggiornare la pagina
            document.getElementById('costoBiglietti').innerText = risultato + " euro";
        }
    </script>
</body>
</html>
