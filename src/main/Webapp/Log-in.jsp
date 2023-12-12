<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>Log-in</title>
    <link rel="stylesheet" type="text/css" href="Css/CssGlobale.css">
    <link rel="stylesheet" type="text/css" href="Css/Log-in.css">

    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>


<main>

        <!-- Controlla c'è stato un tentativo di accesso errato, visualizza un messaggio di errore -->
        <br/>
        <div class="form">

            <% String logInStatus = (String) request.getAttribute("logInStatus");
                if (logInStatus != null && logInStatus.equals("errato")) {%>
            <h1 id="errore">CREDENZIALI ERRATE</h1><%}%>
            <form action="login" method="post" onsubmit="return validate()">
                <input required id="email" type="email" name="email" placeholder="Email"><br><br>
                <input required type="password" name="pswd" placeholder="Password"><br><br>
                <button>Accesso</button>
            </form>
        </div>

</main>

</body>
</html>