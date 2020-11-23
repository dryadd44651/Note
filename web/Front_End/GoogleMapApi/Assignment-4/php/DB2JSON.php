<?php
require("phpsqlajax_dbinfo.php");

function parseToXML($htmlStr)
{
$xmlStr=str_replace('<','&lt;',$htmlStr);
$xmlStr=str_replace('>','&gt;',$xmlStr);
$xmlStr=str_replace('"','&quot;',$xmlStr);
$xmlStr=str_replace("'",'&#39;',$xmlStr);
$xmlStr=str_replace("&",'&amp;',$xmlStr);
return $xmlStr;
}

// Opens a connection to a MySQL server
$connection=mysqli_connect("localhost", "root", "root", "SSA");
if (!$connection) {
  die('Not connected : ' . mysqli_error());
}

// Select all the rows in the markers table
$query = "SELECT * FROM markers";
$result = mysqli_query($connection, $query);
if (!$result) {
  die('Invalid query: ' . mysqli_error());
}


$rows = array();
// Iterate through the rows, printing XML nodes for each

while ($row = @mysqli_fetch_assoc($result)){
	
	$rows[] = $row;
}
print json_encode($rows);

?>
