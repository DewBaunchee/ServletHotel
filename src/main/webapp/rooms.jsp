<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Rooms</title>
</head>
<body>
<script>

    function send(params) {
        const http = new XMLHttpRequest();
        const url = 'rooms';
        http.open('POST', url, true);
        http.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        http.onreadystatechange = () => {
            document.location.reload();
        };
        http.send(params);
    }

    function rent(roomId) {
        send('rent=' + roomId)
    }

    function unrent(roomId) {
        send('unrent=' + roomId)
    }
</script>
<table>
    <tr>
        <th>Rent</th>
        <th>Label</th>
        <th>Has kitchen</th>
        <th>Has bath</th>
    </tr>
    <jsp:useBean id="rooms" scope="request" type="java.util.List<by.varyvoda.matvey.servlethotel.entity.hotel.Room>"/>
    <jsp:useBean id="username" scope="request" type="java.lang.String"/>
    <c:forEach items="${rooms}" var="room">
        <tr>
            <td>
                    <с:choose>
                        <c:when test="${room.reservation == null}">
                            <button type="button" onclick="rent(${room.id})">Rent</button>
                        </c:when>
                        <c:when test="${room.reservation != null && room.reservation.user.username.equals(username)}">
                            <button type="button" onclick="unrent(${room.id})">Unrent</button>
                        </c:when>
                        <c:when test="${room.reservation != null && !room.reservation.user.username.equals(username)}">
                            Busy
                        </c:when>
                    </с:choose>
            </td>
            <td>${room.label}</td>
            <td>${room.hasKitchen}</td>
            <td>${room.hasBath}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
