<?php
$books = array("In Search of Lost Time", "Ulysses", "Don Quixote","The Great Gatsby");


$path=$_SERVER['PATH_INFO'];
$path=ltrim($path,'/');
$path_arr=explode('/', $path);
if ($path_arr[1] != null){
	$num = (int)$path_arr[1];
	
	
	if($num>=count($books))
		$num = count($books)-1;
	echo '{"id":"'.$num.'","name":"'.$books[$num].'"}';
}
else{
	foreach ($books as $book){
		echo "$book <br>";
	}
}

		
?>
