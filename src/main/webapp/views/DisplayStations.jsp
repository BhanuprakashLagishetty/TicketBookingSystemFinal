<%@ page import="java.util.Set" %>
<%@ page import="com.example.BookTicket.Entity.Stations" %>

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
<h1>Employee List</h1>
<div style="display:flex">
    <a href="AddStations" class="add-btn">Add Stations</a>
    <a href="/" class="add-btn" style="margin-left:10px">GO to index</a>
</div>
<table>
    <thead>
        <tr>
            <th>StationName</th>
            <th>kilometers</th>

        </tr>
    </thead>
    <tbody>
        <%
            Set<Stations> stationSet = (Set<Stations>) request.getAttribute("stations");
            if (stationSet != null && !stationSet.isEmpty()) {
                for (Stations station : stationSet) {
        %>
        <tr>
            <td><%= station.getStationName() %></td>
            <td><%= station.getKm() %></td>

        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No Stations found</td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
</body>
</html>
