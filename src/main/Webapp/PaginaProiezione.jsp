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

    <% Proiezione proiezione = (Proiezione) session.getAttribute("proiezione"); %>
    <% Film film = proiezione.getFilm(); %>


<div class="row">

    <div class="col-3"></div>

    <div class="col-9 text-center" id="ContenitoreTitolo">
        <h1><%= film.getTitolo() %></h1>
    </div>

    <div class="col-3 align-content-center" id="ContenitoreLocandinaFilm">
        <img src="<%= film.getLocandina() %>" alt="LocandinaFilm">
    </div>

    <div class="col-9 text-center" id="ContenitoreDescrizione">
        <p><%= film.getDescrizione() %></p>
    </div>

    <div class="col-7">
        <form class="row" id="AcquistoBiglietto" action="acquisto-servlet">
            <p class="col-9">Sala Spettacolo:</p>                           <p class="col-3"><%= proiezione.getSala()%> </p>
            <p class="col-9">Orario Spettacolo:</p>                         <p class="col-3"><%= proiezione.getOrario()%> </p>
            <label class="col-9" for="numeroBiglietti">Numero Biglietti:    </label> <input class="col-3" type="number" required name="numeroBiglietti" id="numeroBiglietti" placeholder="1" min="1" max="<%= proiezione.getPosti() %>" oninput="calcoloCostoBiglietti()"/>
            <p class="col-9">Costo Biglietti:</p>                           <p class="col-3" id="costoBiglietti">7</p>
            <p class="col-9">Metodo di pagamento:</p>                       <p class="col-3">Paypal</p>
            <div class="col-4"></div> <input class="col-4 text-center" type="submit" value="Acquista Biglietti"><div class="col-4"></div>
        </form>
    </div>






    <div class="col-5" id="ContenitoreInformazioniFilm">
        <h1>Generi:</h1> <p><%= film.getGeneri()%></p>
        <h1>Attori:</h1> <p><%= film.getGeneri()%></p>
        <h1>Regista:</h1> <p><%= film.getRegista()%></p>
    </div>


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
            document.getElementById('costoBiglietti').innerText = risultato;
        }
    </script>
</body>
</html>
