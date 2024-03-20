<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="com.example.BookTicket.Models.SeatsModel" %>
<%@ page import="com.example.BookTicket.Entity.WaitingList" %>
<html>
<head>
    <title>Train List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f2f2f2;
        }
        .btn-edit, .btn-delete {
            padding: 6px 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .btn-delete {
            background-color: #dc3545;
        }
        .btn-edit:hover, .btn-delete:hover {
            background-color: #0056b3;
        }
        .add-btn {
            height: 60px;
            width: 200px;
            background-color: #4CAF50;
            border: none;
            color: white;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            display: flex;
            text-align: center;
            align-items: center;
            justify-content: center;
        }
        .add-btn:hover {
            background-color: #45a049;
        }
        .ticket {
            background-color: #f2f2f2;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 10px;
        }
        .ticket p {
            margin: 5px 0;
        }
        .ticket .book-btn {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }
        .ticket .book-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h1>Train List</h1>
<div style="display:flex">
    <a href="/" class="add-btn" style="margin-left:10px">GO to index</a>
</div>
<form action="bookingTickets" method="post">
    <%
        List<WaitingList> seatSet = (List<WaitingList>) request.getAttribute("seatList");
        if (seatSet != null && !seatSet.isEmpty()) {
            for (WaitingList seat : seatSet) {
    %>
    <div class="ticket">
    <p>TrainName: <%= seat.getTrain().getName() %></p>
    <p>Seat Number: <%= seat.getConfirmedSeat() %></p>
    <p>Seat Availability: <%= seat.isAvailable() %></p>
    <p>Seat Type: <%= seat.getTypeOfSeat() %></p>
    <p>From: <%= seat.getBookingSeats().getArrivalStation() %></p>
    <p>To: <%= seat.getBookingSeats().getDestinationStation() %></p>
     <p>Seat Status: <%=  seat.getStatus() %></p>
    <p>Booked for Date: <%= seat.getBookedDate() %></p>



        <input type="checkbox" name="selectedSeats" value="<%= seat.getSeatNumber() %>"> Select Seat
    </div>
    <%
            }
        } else {
    %>

    <%
        }
    %>
    <input type="hidden" name="bookingDate" value="<%= request.getAttribute("bookingDate") %>">
    <input type="submit" value="Cancel Tickets any Way">
</form>
</body>
</html>
