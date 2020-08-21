<?php
$request = $_SERVER['REQUEST_URI'];
//echo $request;
//echo "<br>";
//echo substr($request,0,12);
switch ($request) {
    case '/Router/' :
        require __DIR__ . '/views/index.php';
        break;
    case '/Router/about' :
        require __DIR__ . '/views/about.php';
        break;
	case '/Router/book' :
        require __DIR__ . '/views/book.php';
        break;
    default:
		if (substr($request,0,12) == '/Router/book'){
			require __DIR__ . '/views/book.php';
			break;
		}
        http_response_code(404);
        require __DIR__ . '/views/404.php';
        break;
}
?>