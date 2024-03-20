<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking Report</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f5f5f5;
    }

    .container {
        width: 80%;
        margin: 20px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
        text-align: center;
    }

    .report {
        margin-top: 20px;
    }

    .report p {
        margin: 10px 0;
    }

    .link {
        display: block;
        margin-top: 20px;
        text-align: center;
    }

    .link a {
        color: #007bff;
        text-decoration: none;
    }

    </style>
</head>
<body>
    <div class="container">
        <h1>Booking Report</h1>
        <div class="report">
            <p>Booking Id: ${bookingModel.getId()}</p>
            <p>UserName: ${bookingModel.getUser().getUsername()}</p>
            <p>Age: ${bookingModel.getUser().getAge()}</p>
            <p>From: ${bookingModel.getArrivalStation()}</p>
            <p>To: ${bookingModel.getDestinationStation()}</p>
            <p>No of seats: ${bookingModel.getNumerOfSeats()}</p>
            <p>Booking status: ${bookingModel.getBookingStatus()}</p>
            <p>Refund of booking: ${bookingModel.getPrice()}</p>
        </div>
        <div class="link">
            <a href="javascript:history.go(-1)">Go Back</a>
            <p style="color:red;">successfully Cancelled the ticket</p>
        </div>
    </div>
</body>
</html>
