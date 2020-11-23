<h1>book</h1>

<?php
$books = array("In Search of Lost Time", "Ulysses", "Don Quixote","The Great Gatsby");

/* restful
$path=$_SERVER['PATH_INFO'];
$path=ltrim($path,'/');
$path_arr=explode('/', $path);
if ($path_arr[1] != null){
	$num = (int)$path_arr[1];
	echo $num;
	echo "<br>";
	if($num>=count($books))
		$num = count($books)-1;
	echo $books[$num];
}
else{
	foreach ($books as $book){
		echo "$book <br>";
	}
}*/
if($_POST["id"]){
	$num = (int)$_POST["id"];
	if($num>=count($books))
		$num = count($books)-1;
	echo "$books[$num] <br>";
	
}else{
	foreach ($books as $book){
		echo "$book <br>";
	}
}
		
?>
<a href="/Router/">Home</a>