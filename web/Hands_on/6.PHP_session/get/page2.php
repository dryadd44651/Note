<?php
session_start();

echo "username:".$_GET["username"].", password: ".$_GET["password"];

//if username and password is valid
$_SESSION["usr"] = $_GET["username"];


?>
