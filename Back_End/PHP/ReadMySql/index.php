	<html>
	<head>
	<style type="text/css">
		table {
		  border-collapse: collapse;
		  width: 75%;
		}

		table, th, td {
		  border: 1px solid black;
		  text-align:center;
		}
		tr:hover {background-color:#f5f5f5;}		
	</style>
	</head>
	<body>
		<form action="index.php" method="POST">
			<select name="year">
				<option value="all">All years</option>
				<option value="2005">2005</option>
				<option value="2006">2006</option>
				<option value="2007">2007</option>
				<option value="2008">2008</option>
				<option value="2009">2009</option>
				<option value="2010">2010</option>
				<option value="2010">2011</option>
				<option value="2010">2012</option>
				<option value="2010">2013</option>
				<option value="2010">2014</option>
				<option value="2010">2015</option>
			</select>

			<select name="gender">
				<option value="both">Both</option>
				<option value="m">Male</option>
				<option value="f">Female</option>
			</select>

			<input type="submit" value="Submit">
		</form>



<?php
$year= $_POST["year"];
$gender= $_POST["gender"];
if(!empty($year) && !empty($gender)){
	
	
	//echo "Year: " . $year ." Gender: " . $gender . "<br>";
	$con = mysqli_connect("localhost", "root", "root", "SSA");
	//Nested query 
	$sql = "SELECT * FROM babynames";// WHERE year='$year' AND gender='$gender' ";
	
	if ($year!="all")
		$sql = "SELECT * FROM (" . $sql . ") as a WHERE year='$year'";

	if ($gender!="both")
		$sql = "SELECT * FROM (" . $sql . ") as b WHERE gender='$gender'";
	
	
	$sql = "SELECT * FROM (" . $sql . ") as d ORDER BY year, gender, ranking";
	//$sql = $sql . " ORDER BY year, gender, ranking";
	
	//echo $sql . "<br>";
	
	$result = mysqli_query($con, $sql);
	echo "<table><tr><th>Name</th><th>Year</th><th>Gender</th><th>Ranking</th></tr>";
	while ($row=mysqli_fetch_array($result)) {
		//echo $row[name] . "<br>";
		//echo "Name: ". $row[name] . " Year: ". $row[year] . " Ranking: ". $row[ranking] . " Gender: ". $row[gender] . "<br>";
		echo "<tr><td >";
		echo $row['name'] . "</td><td >";
		echo $row['year'] . "</td><td >";
		echo $row['gender'] . "</td><td >";
		echo $row['ranking'] . "</td></tr>" ;

	}
	
	echo "</body>";
	echo "</html>";
	
}
?>
