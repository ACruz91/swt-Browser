function saludo(){
		var name=prompt("Introduce tu nombre, por favor.","nombre");
		var today = new Date ();
		var hrs = today.getHours();
		document.writeln("<b><font size=4 face='Comic Sans MS'>");
		document.writeln("<b>");
		if (hrs <= 12)
    	    document.write("Buenos días "+name+'!!!');
		else if (hrs <= 22)
        	document.write("Buenas tardes "+name+'!!!');
		else
     		document.write("Buenas noches "+name+'!!!'); 
 		document.writeln("<br>");
 }
