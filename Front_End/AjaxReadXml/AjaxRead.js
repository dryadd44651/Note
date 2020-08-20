$(document).ready(function(){
	$("button").click(function(){
		$.ajax({
			//local file access will be blocked by chrome
			url:"books.xml",
			dataType:'xml',
			success: function(data){
				var tableheader='<tr><th>Title</th><th>Author</th><th>Year</th><th>Price</th><th>Category</th></tr>';
				$('table').append(tableheader);
				$(data).find('book').each(function(){
					var name=$(this).find('title').text();
					var authorr=$(this).find('author');
					var author=$.map(authorr,function(au){ return $(au).text()}).join(', ');
					var year=$(this).find('year').text();
					var price=$(this).find('price').text();
					var catergory=$(this).attr('category');
					console.log(catergory);
					var info='<tr><td>'+name+'</td><td>'+author+'</td><td>'+year+'</td><td>'+price+'</td><td>'+catergory+'</td></tr>';

					$('table').append(info);
				});
			},
			error: function(){alert('error loading file');}
		});
	});
});