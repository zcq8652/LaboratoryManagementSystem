$(document).ready(function(){

	$(".selectBoxSon2").click(function(){
         $(".selectBoxSon1").toggle(500);
	});

    $(".selectBoxSon11").click(function(){
         $(".selected4Img").css("display","none");
	     $(".inputText").css("display","none");
	});
    
    $(".userBox").click(function(){
         $(".userSelectedBox").toggle(1);
    });

    var box1 = document.getElementsByClassName("box1")[0];
    var box2 = document.getElementsByClassName("box2")[0];

    box1.onmouseover = function(){
    	this.style.backgroundColor = "#fa7900";
    }
    box1.onmouseout = function(){
    	this.style.backgroundColor = "#fff";
    }
    box2.onmouseover = function(){
    	this.style.backgroundColor = "#fa7900";
    }
    box2.onmouseout = function(){
    	this.style.backgroundColor = "#fff";
    }

   $("dt").hover(function(){
      $(this).css("color","#263f52");
    },function(){
      $(this).css("color","#585858");
    });
    
    $(".item1").hover(function(){
    	$(this).css("color","#438eb9");
    },function(){
    	$(this).css("color","#757575");
    });

    $(".item").hover(function(){
    	$(this).css("color","#438eb9");
    },function(){
    	$(this).css("color","#757575");
    });
    
    $(".dt1").hover(function(){
    	$(".kaoqinImg").attr("src","images/kaoqin2.png");
    },function(){
    	$(".kaoqinImg").attr("src","images/kaoqin.png");
    });

    $(".dt2").hover(function(){
    	$(".anquanImg").attr("src","images/anquan2.png");
    },function(){
    	$(".anquanImg").attr("src","images/anquan.png");
    });

    $(".dt3").hover(function(){
    	$(".weishengImg").attr("src","images/weisheng2.png");
    },function(){
    	$(".weishengImg").attr("src","images/weisheng.png");
    });
    
    $(".dt4").hover(function(){
    	$(".shebeiImg").attr("src","images/shebei2.png");
    },function(){
    	$(".shebeiImg").attr("src","images/shebei.png");
    });
    $(".dt5").hover(function(){
        $(".classImg").attr("src","images/class2.png");
    },function(){
        $(".classImg").attr("src","images/class.png");
    });
    $(".dt6").hover(function(){
        $(".gonggaoImg").attr("src","images/gonggao2.png");
    },function(){
        $(".gonggaoImg").attr("src","images/gonggao.png");
    });
});