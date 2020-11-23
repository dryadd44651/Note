<html>
<body>

<form method="post" action="<?php echo $_SERVER['PHP_SELF'];?>">
  Name: <input type="text" name="fname">
  <input type="submit">
</form>
<form method="get" action="<?php echo $_SERVER['PHP_SELF']; ?>">
  num: <input type="number" name="num">
  <input type="submit">
</form>


<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  // collect value of input field
  $name = $_POST['fname'];
  if (empty($name)) {
    echo "Name is empty";
  } else {
    echo $name;
  }
}
if ($_SERVER["REQUEST_METHOD"] == "GET") {
  // collect value of input field
  $num = $_GET['num'];
  if (empty($num)) {
    echo "num is empty";
  } else {
    echo $num;
  }
}
?>

</body>
</html>