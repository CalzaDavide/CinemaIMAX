<!DOCTYPE html>

<html>
<head>
    <title>Log-in</title>
    <link rel="stylesheet" type="text/css" href="Css/Log-in.css">
    <link rel="icon" type="image/x-icon" href="Images/LogoCircolare.jpeg">

    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>

<header>
    <jsp:include page="Header.jsp"/>
</header>

<main>

    <!-- Controlla c'è stato un tentativo di accesso errato, visualizza un messaggio di errore -->
    <br/>
    <div class="form">

        <% String logInStatus = (String) request.getAttribute("logInStatus");
            if (logInStatus != null && logInStatus.equals("errato")) {%>

        <h1 id="errore">CREDENZIALI ERRATE</h1><%}%>

        <form action="login-servlet" method="post">
            <input required id="email" type="email" name="email" placeholder="Email"><br><br>
            <input required type="password" name="password" placeholder="Password"><br><br>
            <button>Accesso</button>
        </form>
    </div>

</main>

</body>
</html>