<?php
$year= $_POST["year"];
$gender= $_POST["gender"];
//$year = "all";
//$gender="both";
if(!empty($year) && !empty($gender)){

	//echo "Year: " . $year ." Gender: " . $gender . "<br>";
	$con = mysqli_connect("localhost", "root", "root", "SSA");
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
	echo "</table>";
	
}
?>
