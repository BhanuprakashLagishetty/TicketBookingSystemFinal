<%@ page import="java.util.List" %>
<%@ page import="com.example.BookTicket.Entity.Booking" %>





<!DOCTYPE html>
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
        .add-btn{
         height: 60px;
          width: 200px; /* Adjust width as needed */
          background-color: #4CAF50; /* Green background color */
          border: none;
          color: white; /* White text color */
          text-align: center;
          text-decoration: none;
          display: inline-block;
          font-size: 16px;
          cursor: pointer;
          border-radius: 5px;
           display:flex;
          text-align:center;
          align-items:center;
          justify-content:center;

        }
        .add-btn:hover{
        }background-color: #45a049;
    </style>
</head>
<body>
<h1>${res}</h1>
<h1>Train List</h1>
<table>
    <thead>
        <tr>
            <th>Booking Id</th>
            <th>Number of Seats Booked</th>
            <th>Booking Status</th>
            <th>Booked Date And Time</th>
            <th>Booked User</th>
            <th>Type of Booking</th>
            <th>Display Booked Tickets</th>
            <th>Cancelling Of Booking</th>


        </tr>
    </thead>
    <tbody>
    <div style="display:flex">

                     <a href="/" class="add-btn" style="margin-left:10px">
                                        GO to index
                                        </a><a href="/allWaitingListTickets" class="add-btn" style="margin-left:10px">
                                                                                    Check for waitingList Ticket Status
                                                                                    </a>

                                        </div>
        <%
            List<Booking> bookingList = (List<Booking>) request.getAttribute("bookingList");
            if (bookingList != null) {
                for (Booking booking : bookingList) {
        %>
        <tr>
            <td><%= booking.getId() %></td>
            <td><%= booking.getNumerOfSeats() %></td>
            <td><%= booking.getBookingStatus() %></td>
            <td><%= booking.getBookingType() %></td>
            <td><%= booking.getBookingTime() %></td>
            <td><%= booking.getUser().getUsername() %></td>


            <td>

              <form action="DisplayBookingSeats" style="margin-right:5px;">
                     <input type="hidden" name="bookingId" value= <%= booking.getId() %>>
                     <input type="submit" value="Display Booked Seats" class="btn-edit">
              </form>
            </td>
            <td>
            <%
            if(booking.getBookingStatus().equals("completed"))
            {
            %>
             <form action="CancelBooking" style="margin-right:5px;">
                <input type="hidden" name="bookingId" value= <%= booking.getId() %>>
                 <input type="submit" value="Cancel Booking" class="btn-edit">
             </form>
             <%
             }
             %>

            </td>




        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">No employees found</td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
</body>
</html>