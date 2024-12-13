<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Liste des films</title>
  </head>

  <body>
    <h1 style="text-align: center">Liste des films</h1>

    <!-- Vérification si la liste des films existe et contient des données -->
    <c:if test="${not empty requestScope.FILMS}">
      <table
        border="1"
        style="
          width: 80%;
          margin: 0 auto;
          border-collapse: collapse;
          text-align: center;
        "
      >
        <thead>
          <tr style="background-color: #f2f2f2">
            <th>Titre</th>
            <th>YEAR</th>
            <th>Actors</th>
            <th>Affiche</th>
            <th>Baisser</th>
            <th>Note</th>
            <th>Augmenter</th>
          </tr>
        </thead>
        <tbody>
          <!-- Parcourir la liste des films -->
          <c:forEach var="film" items="${requestScope.FILMS}">
            <tr>
              <td>
                <c:out value="${film.title}" />
              </td>
              <td>
                <c:out value="${film.year}" />
              </td>
              <td>
                <c:out value="${film.actors}" />
              </td>
              <td>
                <p><img src="${film.picture}" width="200px" /></p>
              </td>

              <td>
                <!-- Envoi de l'ID comme attribut dans l'URL -->
                <a href="baisser?id=${film.id}">Baisser</a>
              </td>
              <td>
                <c:out value="${film.note}" />
              </td>

              <td>
                <!-- Envoi de l'ID comme attribut dans l'URL -->
                <a href="augmenter?id=${film.id}">Augmenter</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </c:if>

    <!-- Message si la liste est vide -->
    <c:if test="${empty requestScope.FILMS}">
      <p style="text-align: center">Aucun film disponible pour le moment.</p>
    </c:if>
  </body>
</html>
