$num = 60; 
$n = 10;

function local_var() 
{ 
	$num = 50; 
	echo "local num = $num \n"; 
    global $n;
    echo "global n = $n \n"; 
} 

local_var(); 

echo "Variable num outside local_var() is $num \n"; 
function static_var() 
{    
    // static variable 
    static $num = 5; 
    $num++;  
    echo $num, "\n";  
} 
  
// first function call 
static_var();   
// second function call 
static_var();

