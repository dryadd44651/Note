# Add New Todo
```
//html + icon
<span id="toggle-form"><i class="fa fa-plus"></i></span>
//js
$("#toggle-form").click(function(){
	$("#newtodo").fadeToggle();
});

```

# input newtodo
```
//html
<input type="text" id="newtodo" placeholder="Add New Todo">
//css
#newtodo {
	display:none;
}
//js
$("#newtodo").keypress(function(event){
	//value 13: enter
	if(event.which === 13){
		//grabbing new todo text from input
		var todoText = $(this).val();
		$(this).val("");
		//create a new li and add to ul
		$("ul").append("<li><span><i class='fa fa-trash'></i></span> " + todoText + "</li>")
	}
});
```
# to do hover and delete
```
//html
<ul>
		<li><span><i class="fa fa-trash"></i></span> Go To Potions Class</li>
		<li><span><i class="fa fa-trash"></i></span> Buy New Robes</li>
		<li><span><i class="fa fa-trash"></i></span> Visit Hagrid</li>
</ul>
//css
//hide the trash icon
li span {
	width: 0;
	opacity: 0;
}
//show trash icon
li:hover span {
	width: 40px;
	opacity: 1.0;
}
//show cross line
.completed {
	color: gray;
	text-decoration: line-through;
}
//js
//show cross line
$("ul").on("click", "li", function(){
	$(this).toggleClass("completed");
});
//click trash icon ul->span
//Click on X to delete Todo
$("ul").on("click", "span", function(event){
	$(this).parent().fadeOut(500,function(){
		$(this).remove();
	});
	event.stopPropagation();
});
```
