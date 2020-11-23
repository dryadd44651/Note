<?php
//session_save_path('/tmp');
session_start();

echo "username:".$_POST["username"].", password: ".$_POST["password"];

//if username and password is valid
$_SESSION["usr"] = $_POST["username"];
echo "SESSION: " . $_SESSION["usr"];

?>
