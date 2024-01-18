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
</head>
<body>

    <% Proiezione proiezione = (Proiezione) session.getAttribute("proiezione"); %>

    <div id="ContenitoreFilm">

        <div id="CopertinaFilm">
            <img src="<%= proiezione.getFilm().getLocandina() %>" alt="CopertinaFilm">
        </div>


        <form id="AcqusitaBiglietti">
        <div id="InformazioniFilmDiv">
            <div id="ContenitoreSala">
                <p id="ContenitoreNumeroSala">Sala spettacolo: <%= proiezione.getSala() %></p>
            </div>

            <div id="ContenitoreOrario">
                <p id="ContenitoreOrarioSpettacolo">Orario spettacolo: <%= proiezione.getOrario() %></p>
            </div>

            <div id="ContenitoreNumeroBiglietti">
                <label for="ContenitoreNumeroNumeroBiglietti" id="numeroBiglietti">Numero biglietti:</label>
                <input type="number" name="numeroBiglietti" required id="ContenitoreNumeroNumeroBiglietti" value="1" min="1" max="<%= proiezione.getSala().getPosti()%>">
            </div>

            <div id="ContenitoreMetodoDiPagamento">
                <label for="MetodoDiPagamento">Metodo Di Pagamento:</label>
                <select required id="MetodoDiPagamento" name="MetodoDiPagamento">
                    <option>Paypal</option>
                    <option>Carta di credito</option>
                    <option>Contanti</option>
                </select>
            </div>

            <div id="ContenitoreAcquistaBiglietti">
                <input type="submit">
            </div>
        </div>

        </form>

        <div id="ContenitoreTitoloDescrizione">
            <h1 id="Titolo"><%= proiezione.getFilm().getTitolo() %></h1>
            <p id="Descrizione"><%= proiezione.getFilm().getDescrizione() %></p>
        </div>

        <div id="ContenitoreGeneriAttoriRegista">
            <div id="ContenitoreGeneri">
                <p>Generi: <%= proiezione.getFilm().getGenere() %></p>
            </div>

            <div id="ContenitoreAttori">
                <p>Attori: <%= proiezione.getFilm().getAttori() %></p>
            </div>

            <div id="ContenitoreRegista">
                <p>Regista: <%= proiezione.getFilm().getRegista() %></p>
            </div>

        </div>


    </div>


</body>
</html>
