<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01/09/2020
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background-color: #E9EBEE;
            font-family: 'Lucida Grande', tahoma,verdana,arial,sans-serif;
            font-style: normal;
        }

        header a {
            color: #b0bcd5;
            text-decoration: none;
            font-family: sans-serif;
        }

        .formulaire {
            width: 480px;
            display: flex;
            align-items: flex-end;
        }

        .formulaire div {
            display: flex;
            flex-direction: column;
            margin-right: 20px;
        }

        .container {
            margin: 8px 0 0 200px;
            font-size: 12px;
        }

        header {
            display: flex;
            justify-content: space-around;
            align-items: center;
            height: 80px;
            background-color: #3B5998;
            color: white;
        }

        label {
            font-size: 12px;
            margin-bottom: 4px;
        }

        .btn {
            background-color: #516ac1;
            border: solid rgba(0, 0, 0, 0.3) 0.1em;
            color: white;
            font-family: helvetica, arial, sans-serif;
            font-size: 13px;
            padding: 5px 6px;
            margin-bottom: -1px;
            font-weight: bold;
            cursor: pointer;
            border-radius: 3px;
            margin-left: -5px;
            outline: none;
        }

        .logo {
            margin-top: 10px;
            width: 174px;
            cursor: pointer;
            color: white;
            font-size: 40px;
            font-weight: bold;
        }

        .forgot {
            margin: 2px 0 0 200px;
            color: #6d84b4;
        }

        input {
            padding: 3px;
        }

        .left {
            margin: 70px 650px 0 200px
        }

        .connect {
            color: rgba(0, 0, 0, 0.85);
            font-size: 24px;
            margin-bottom: 100px;
        }

        .center_list {
            list-style: none;
            padding-bottom:10px;
            margin-top:20px;
        }

        .list {
            float: left;
            margin-top: -40px;
            margin-bottom: 50px;
            padding-bottom:20px;
        }

        .img-list {
            display: inline-block;
            vertical-align: middle;
            margin-right: 20px;
        }

        .right {
            float: right;
            margin-top: -380px;
            margin-right: 230px;
        }

        .inputs {
            margin-top: 25px
        }

        .input {
            padding-left: 10px;
            font-size: 19px;
            margin-bottom: 10px;
            border-radius: 6px;
            border: 1px solid rgba(78, 78, 78, 0.5);
            height: 40px;
        }

        .input_1 {
            width: 190px;
        }

        .input_2 {
            width: 385px;
        }

        select {
            margin-top: 6px;
            padding: 6px;
            margin-left: -6px
        }

        .why {
            margin: -30px 0 0 195px;
            font-size: 10px;
            font-family: sans-serif;
        }

        .terms {
            font-size: 10px;
            width: 306px;
            margin-top: 10px;
            margin-bottom:30px;
            color: rgba(0, 0, 0, 0.6)
        }

        .terms_a {
            text-decoration: none;
            color: #32549b;
        }

        .signUp {
            margin-top:100px;
            margin-bottom:5px;
            font-family: 'Open Sans',sans-serif;
            text-rendering:optimizelegibility;
            color:#333;
        }

        .signUpSub {
            font-size:16px;
            margin-bottom:20px;
            color:#333;
        }

        .signUpBtn {
            text-decoration:none;
            font-size: 19px;
            font-weight: 700;
            letter-spacing: 1px;
            color:#fff;
            min-width: 194px;
            padding: 7px 20px;
            text-align: center;
            -webkit-border-radius: 5px;
            background: -webkit-linear-gradient(#67ae55, #578843);
            -webkit-box-shadow: inset 0 1px 1px #a4e388;
            border: 1px solid;
            border-color: #3b6e22 #3b6e22 #2c5115;
            margin-top: 10px;
            text-shadow: 0 1px 2px rgba(0,0,0,.5);
            cursor:pointer;
        }

        .signUpBtn:hover {
            background: -webkit-linear-gradient(#79bc64, #578843);
        }

        .signUpBtn:active {
            position: relative;
            top: 1px;
        }

        .formbox {
            display: inline-block;
            width:399px;
        }

        .create {
            border-top: 1px solid #a0a9c0;
            color: #666;
            font-size: 13px;
            font-weight: bold;
            margin-top: 30px;
            margin-bottom:30px;
            padding-top: 15px;
        }

        .create a {
            text-decoration:none;
        }

        .male, .female {
            font-size:16px;
        }
    </style>

</head>

<body>
<header>
    <div class="logo">facebook</div>
    <div class="container">
        <form class="formulaire" method="post" action="./signin">
            <div class="userMail">
                <label for="mail">Email</label>
                <input type="text" id="mail" name="email" />
            </div>
            <div class="password">
                <label for="password">Password</label>
                <input type="password" id="password"  name="password"/>
            </div>
            <input type="submit" value="Login" class="btn" />
        </form>
        <div class="forgot"><a href="#">Forgot account?</a></div>
    </div>
</header>
<div class="left">
    <h2 class="connect">Connect with friends and the
        <br>
        world around you on Facebook.</h2>
    <ul class="center_list">
        <li class="list">
            <b>See photos and updates from friends in News Feed.</b>
        </li>
        <li class="list">
           <b>Share what's new in your life on your Timeline.</b>
        </li>
        <li class="list">
            <b>Find more of what you're looking for with Facebook Search.</b>
        </li>
    </ul>
</div>
<div class="right">
    <h1 class="signUp">Sign Up</h1>
    <h4 class="signUpSub">It’s free and always will be.</h4>
<%--    form opening --%>
    <form method="post" action="./insert">
        <div class="inputs">
            <input type="text" class="input input_1" placeholder="First name" name="firstname" >
            <input type="text" class="input input_1" placeholder="Last name" name="lastname">
            <br>
            <input type="text" class="input input_2" placeholder="Email" name="email">
            <br>
            <input type="text" class="input input_2" placeholder="Re-enter email" name="email">
            <br>
            <input type="password" class="input input_2" placeholder="New password" name="password">
        </div>
        <div>
            <h4>Birthday</h4>
            <input type="date" name="dateOfBirth">
        </div>
        <div style="margin-top: 20px;">
            <input id="female" name="gender" type="radio" value="female">
            <label class="female" for="female">Female</label>
            <input id="male" name="gender" type="radio" value="male">
            <label class="male" for="male">Male</label>
        </div>
        <div class="terms">
            <p>By clicking Sign Up, you agree to our <a href="#" class="terms_a">Terms</a> and that you have read our <a href="#" class="terms_a">Data Policy</a>, including our <a href="#" class="terms_a">Cookie Use</a>.</p>
        </div>

        <div>
            <button type="submit"  class="signUpBtn">Create Account</button>
        </div>
    </form>

    <div class="formbox">
        <div class="create"><a href="">Create a Page</a> for a celebrity, band or business.</div>
    </div>
</div>
</body>
</html>
