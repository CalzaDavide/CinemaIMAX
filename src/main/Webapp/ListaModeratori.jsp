<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista Moderatori</title>
    <link rel="stylesheet" href="Css/ListaModeratori.css">
</head>
<body>
    <header>
        <jsp:include page="SearchBar.jsp"/>
    </header>

    <div id="Contenitore">

        <%-- !%><%ArrayList<Cliente> clienti = (new ClienteDAO()).doRetrieveAll();%> --%>
        <div id="ListaModeratori">
            <table>
                <tr>
                    <th>NOME</th>
                    <th>COGNOME</th>
                    <th>E-MAIL</th>
                    <th>ELIMINA</th>
                </tr>

                <tr>
                    <td>Giacomo </td>
                    <td>Favino </td>
                    <td>Giacomo.favino@cinemaimax.it </td>
                    <td><button class="Elimina">Elimina</button> </td>
                </tr>
                <tr>
                    <td>Giacomo </td>
                    <td>Favino </td>
                    <td>Giacomo.favino@cinemaimax.it </td>
                    <td><button class="Elimina">Elimina</button> </td>
                </tr>
                <tr>
                    <td>Giacomo </td>
                    <td>Favino </td>
                    <td>Giacomo.favino@cinemaimax.it </td>
                    <td><button class="Elimina">Elimina</button> </td>
                </tr>
                <tr>
                    <td>Giacomo </td>
                    <td>Favino </td>
                    <td>Giacomo.favino@cinemaimax.it </td>
                    <td><button class="Elimina">Elimina</button> </td>
                </tr>
                <tr>
                    <td>Giacomo </td>
                    <td>Favino </td>
                    <td>Giacomo.favino@cinemaimax.it </td>
                    <td><button class="Elimina">Elimina</button> </td>
                </tr>
                <tr>
                    <td>Giacomo </td>
                    <td>Favino </td>
                    <td>Giacomo.favino@cinemaimax.it </td>
                    <td><button class="Elimina">Elimina</button> </td>
                </tr>
                <tr>
                    <td>Giacomo </td>
                    <td>Favino </td>
                    <td>Giacomo.favino@cinemaimax.it </td>
                    <td><button class="Elimina">Elimina</button> </td>
                </tr>




                <%--
                <!--Mostra le informazioni per ogni cliente-->
                <%for (Cliente c : clienti) {%>
                <tr>
                    <td><%= c.getNome() + " " + c.getCognome()%></td>
                    <td><%=c.getEmail() %></td>
                    <td><%=c.getIndirizzo_Via()%> <%=c.getN_Civico()%> , <%=c.getCodice_Postale()%> , ITALIA</td>
                    <%if (c.isAdmin()) {%>
                    <td id="isAdmin"></td>
                    <%} else {%>
                    <td id="isNotAdmin"></td>
                    <td id="elimina"><form action="elimina-cliente">
                        <input type="hidden" name="cliente" value="<%=c.getEmail()%>">
                        <input type="submit" value="elimina">
                    </form></td>
                    <%}%>
                </tr>
                <%}%>

                --%>
            </table>
        </div>

    </div>

</body>
</html>
