function hide()
{
		var img1 = document.getElementById("img1");
		var frame=window.top.frame;
		
		if(frame.cols=="188,7,*"){
			frame.cols="0,7,*";
			img1.src="background/image/p_right.gif";
			img1.title="µã»÷ÏÔÊ¾²Ëµ¥À¸";
		}else{
	   		frame.cols="188,7,*";
			img1.src="background/image/p_left.gif";
			img1.title="µã»÷Òþ²Ø²Ëµ¥À¸";
		}
}