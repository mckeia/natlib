//https://github.com/mckeia/natlib

function home() {
	console.log('in home');
	$('body').empty();
	//$('body').append($('<h3>').append('Demo Book database for National Library Job') );
	//var mainDiv = $('<div id="mainDiv">')
	//	.css({'margin-bottom':'10px','margin-top':'10px'})
	
	var mainDiv = $('<div id="mainDiv" class="panel panel-default">');
	mainDiv.append( $('<div class="panel-heading">').append('Current Books') );
	var bt = $('<table class="table">');//.css({'border':'1px solid blue','border-collapse': 'collapse'});
	bt.append( $('<tr>') 
			.append( $('<th>').append('ID') )
			.append( $('<th>').append('Author') )
			.append( $('<th>').append('Title') )
			.append( $('<th>').append('ISBN') )
			);
	mainDiv.append(bt);

	$('body').append(mainDiv);	

	$.ajax({
		type: 'POST',
        url : getContextPath()+'/getAllBooks',
        success: function(data) {
        	for (var i=0;i<data.length;i++) {
        		
        		var row = $('<tr>');
        		row.append($('<td class="bkid">').append( data[i].id ));
        		row.append($('<td>').append( data[i].author ));
        		row.append($('<td>').append( data[i].title ));
        		row.append($('<td>').append( data[i].isbn ));
        		row.append($('<span class="glyphicon glyphicon-trash">')
    					.click( function() {
    						var bkID = $(this).parent().parent().find('.bkid').text()
    						$.ajax({
    							type: 'POST',
    					        url : getContextPath()+'/deleteBook',
    					        data: { bookID: bkID   	},
    					        success: function(data) {
    					        	home();  	
    					        },
    					        error: function(err) {
    					        	alert('error: '+err[0]);
    					        }
    						});
    					})
    				);
        		if ( i == data.length - 1) {
        			row.append( $('<span class="glyphicon glyphicon-plus">')
        					.css('margin-left','10px')
        					.click( function() {
        						addBook();
        					})
        			);
        		}
        		bt.append(row);
        	}        	
        },
        error: function(err) {
        	alert('error: '+err[0]);
        }
	});
};

function addBook() {
	$('body').empty();
	var mainDiv = $('<div id="mainDiv" class="panel panel-default">');
	mainDiv.append( $('<div class="panel-heading">').append('Add a New Book') );
	var saveBtn = $('<button type="button" class="btn btn-default btn-lg">')
		.append( $('<span class="glyphicon glyphicon-floppy-disk">') )
		.css({'margin-left':'20px','margin-top':'5px'})
		.click( function() {
			$.ajax({
				type: 'POST',
		        url : getContextPath()+'/saveBook',
		        data: { author: $('#author').val(),
		        		title: $('#title').val(),
		        		isbn: $('#isbn').val()      	
		        },
		        success: function(data) {
		        	home();  	
		        },
		        error: function(err) {
		        	alert('error: '+err[0]);
		        }
			});
		});	
	
	var homeBtn = $('<button type="button" class="btn btn-default btn-lg">')
		.append( $('<span class="glyphicon glyphicon-home">') )
		.css({'margin-left':'10px','margin-top':'5px'})
		.click( function() {
			home();
		});
	
	mainDiv
		.append(
			$('<div class="input-group">')
			.append( $('<span class="input-group-addon">').width(100).append('Author') )
			.append( $('<input id="author" type="text" class="form-control" size="50">') ) 			
		)
		.append(
			$('<div class="input-group">')
			.append( $('<span class="input-group-addon">').width(100).append('Title') )
			.append( $('<input id="title" type="text" class="form-control" size="80">') ) 			
		)		
		.append(
			$('<div class="input-group">')
			.append( $('<span class="input-group-addon">').width(100).append('ISBN') )
			.append( $('<input id="isbn" type="text" class="form-control">') ) 			
		)
		.append( saveBtn )
		.append( homeBtn )
		$('body').append(mainDiv);
}

function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
};