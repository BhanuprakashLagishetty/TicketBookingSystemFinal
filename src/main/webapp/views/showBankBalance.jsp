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
        <h1>Balance</h1>
        <div class="report">
            <p>Balance : ${price}</p>

        </div>
        <div class="link">
            <a href="javascript:history.go(-1)">Go Back</a>
            <a href="Recharge">Click here to Recharge</a>
        </div>
    </div>
</body>
</html>
