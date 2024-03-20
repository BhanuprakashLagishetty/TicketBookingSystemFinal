<%@ page import="java.util.List" %>
<%@ page import="com.example.BookTicket.Models.TrainModel" %>
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
            <th>TrainName</th>
            <th>Train Number</th>
            <th>TrainStarts From</th>
            <th>Train Depatures Location</th>
            <th>Train ArrivalTimings</th>
            <th>Train Depature Timings</th>
            <th>Available Seats in the train</th>
            <th>Add tickets</th>
            <th>Add Intermediate Stops</th>

        </tr>
    </thead>
    <tbody>
    <div style="display:flex">

     <a href="/searchTrain" class="add-btn" style="margin-left:10px">
        GO to index
        </a>
      </div>
        <%
            List<TrainModel> trainList = (List<TrainModel>) request.getAttribute("trainList");
            if (trainList != null) {
                for (TrainModel Train : trainList) {
        %>
        <tr>
            <td><%= Train.getName() %></td>
            <td><%= Train.getId() %></td>
            <td><%= Train.getArrivalStation() %></td>
            <td><%= Train.getDepartureStation() %></td>
            <td><%= Train.getArrivalTime() %></td>
            <td><%= Train.getDepartureTime() %></td>
            <td><%= Train.getAvailableSeats() %></td>
            <td>

              <form action="DisplayTrainTickets" style="margin-right:5px;">

                    <input type="hidden" name="priceGenerationModel" value=${priceGenerationModel}>
                     <input type="hidden" name="trainId" value= <%= Train.getId() %>>
                     <input type="hidden" name="bookingDate" value=${bookingDate}>

                     <input type="submit" value="Book Tickets" class="btn-edit">
              </form>
            </td>
            <td>
             <form action="DisplayIntermediateStations" style="margin-right:5px;">
                <input type="hidden" name="trainId" value= <%= Train.getId() %>>
                 <input type="submit" value="View InterMediate Stops" class="btn-edit">
             </form>

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