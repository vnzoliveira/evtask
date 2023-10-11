<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Card Checker task</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap" rel="stylesheet">
</head>

<body>
    <main class="main-wrapper">
        <div class="card-box">
            <div class="instruction-box">
                <h2>Credit Card checkout</h2>
                <p>In order to conclude your purchase and verify your credit
                    card, wee need you to enter the following information:
                </p>
            </div>
            <div class="divisor"></div>
            <div class="form-box">
                <form id="form" class="form" action="${pageContext.request.contextPath}/confirm" method="post">
                    <label for="cardNum">Card Number</label>
                    <!-- added a 20-digit mask to be able to test the <=19 condition -->
                    <input type="text" name="cardNum" id="cardNum" placeholder="XXXX XXXX XXXX XXXX XXXX" required>
                    <span class="error-box">${InvalidCardMessage}</span>
                    <label for="cvv">CVV</label>
                    <input type="text" name="cvv" id="cvv" placeholder="XXXX" required>
                    <span class="error-box">${cvvErrorMessage}</span>
                    <label for="expiry-date">Expiry date</label>
                    <input type="text" name="expiry-date" id="expiry-date"
                        placeholder="MM/YY" required>
                    <span class="error-box">${InvalidExpiryDateMessage}</span>
                    <input disabled id="btn" class="btn" type="submit" placeholder="Confirm">
                </form>
            </div>
        </div>
    </main>
    <script src="//unpkg.com/vanilla-masker@1.1.1/lib/vanilla-masker.js"></script>
    <script src="./js/form-formatter.js"></script>
    <script src="./js/form-checker.js"></script>
</body>

</html>