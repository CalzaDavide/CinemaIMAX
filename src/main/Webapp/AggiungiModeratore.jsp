<html>
<head>
    <title>Aggiungi Moderatore</title>
    <link rel="stylesheet" href="Css/AggiungiModeratore.css">
    <link rel="icon" type="image/x-icon" href="Images/LogoCircolare.jpeg">
</head>


<body>

<header>
    <jsp:include page="Header.jsp"/>
</header>


<div id="Contenitore">

    <!-- H1 "Aggiungi Moderatore" -->
    <div id="AggiungiModeratoreTextDiv">
        <h1>Aggiungi Moderatore</h1>
    </div>



    <form id="AggiungiModeratoreContainer" action="aggiungi-moderatore">

        <!-- Nome -->
        <div id="NomeDiv">
            <label for="Nome">Nome</label><br>
            <input required type="text" id="Nome" name="Nome" placeholder="Nome">
        </div>

        <!-- Cognome -->
        <div id="CognomeDiv">
            <label for="Cognome">Cognome</label><br>
            <input required type="text" id="Cognome" name="Cognome" placeholder="Cognome">
        </div>

        <!-- Password -->
        <div id="PswdDiv">
            <label for="Pswd">Password</label><br>
            <input required type="text" id="Pswd" name="Pswd" placeholder="Password temporanea">
        </div>

        <!-- Email -->
        <div id="EmailDiv">
            <label for="Email">Email</label><br>
            <input required type="text" id="Email" name="Email" placeholder="Email">
        </div>


    </form>

    <!-- Invio -->
    <div id="InvioDiv">
        <button type="submit" id="pulsanteInvio">Invia</button>
    </div>

    <script>
        document.getElementById('pulsanteInvio').addEventListener('click', function() {
            document.getElementById('AggiungiModeratoreContainer').submit();
        });
    </script>



</div>
</body>

</html>

