
<form action="" method="POST">
<label>Enter Order ID:</label><br />
<input type="text" name="order_id" placeholder="Enter Order ID" required/>
<br /><br />
<button type="submit" name="submit">Submit</button>
</form>

<?php
if (isset($_POST['order_id']) && $_POST['order_id']!="") {
 $order_id = $_POST['order_id'];
 $url = "http://localhost/Router/book/".$order_id;
 
 $client = curl_init($url);
 curl_setopt($client,CURLOPT_RETURNTRANSFER,true);
 $response = curl_exec($client);
 
 $result = json_decode($response, true);
 
 echo "<table>";
 echo "<tr><td>ID:</td><td>$result[id]</td></tr>";
 echo "<tr><td>Name:</td><td>$result[name]</td></tr>";
 echo "</table>";

}
?>