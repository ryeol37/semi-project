<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
<meta charset="UTF-8">
<title>Charlie</title>
<link rel="stylesheet" type="text/css" href="style.css" media="all" />
<link rel="stylesheet" media="all" href="style/type/folks.css" />
<!--[if IE 7]>
<link rel="stylesheet" type="text/css" href="style/css/ie7.css" media="all" />
<![endif]-->
<script type="text/javascript" src="style/js/jquery-1.5.min.js"></script>
<script type="text/javascript" src="style/js/jquery.cycle.all.min.js"></script>
<script type="text/javascript" src="style/js/ddsmoothmenu.js"></script>
<script type="text/javascript" src="style/js/scripts.js"></script>
<script type="text/javascript">
$(function() {
         if ($('#sliderholder-cycle').length) {
         // timeouts per slide (in seconds) 
         var timeouts = [150,390,25]; 
         function calculateTimeout(currElement, nextElement, opts, isForward) { 
             var index = opts.currSlide; 
             return timeouts[index] * 1000;
         }
         jQuery('#sliderholder-cycle').cycle({
            fx: 'fade',
            pager: '.slidernav',
            prev:    '.sliderprev',
              next:    '.slidernext',
            speed: 1000,
            timeoutFn: calculateTimeout,
            pagerEvent: 'click',
             pauseOnPagerHover: true,
             cleartype: 1
});
         jQuery('#sliderholder-cycle').css("display", "block");
         jQuery('.slidernav').css("display", "block");
         
         }
});
</script>
</head>
<body>
<div class="line">
         </div>
   <div id="footer-wrapper">
  <div id="footer">
    <div id="footer-content"> 
      
      <!-- Begin Copyright -->
      <div id="copyright">
        <p><h5> ����ڵ�Ϲ�ȣ : 101-19-00112 &nbsp;&nbsp;&nbsp;����Ǹž��Ű��ȣ : �� 2017-���ﰭ��-33ȣ&nbsp;&nbsp;&nbsp; <br>
           ��ǥ : ������ &nbsp;&nbsp;&nbsp; ��ǥ��ȭ : 02-1588-5588 &nbsp;&nbsp;&nbsp; ��������å���� : �Ѽ���
             &nbsp;&nbsp;&nbsp;<br>
           �ּ� : ����� ������ ���ﵿ 33-33 ������ 3�� I�� &nbsp;&nbsp;&nbsp;<br> 
             Copyright CharlieBook Corp. All right reserved.</h5></p>
            <br><br>
      </div>
      <!-- End Copyright --> 
      
      <!-- Begin Social Icons -->
      <div id="socials">
       <img src="style/image/footer/footer.png">
      
      </div>
      <!-- End Social Icons --> 
      
    </div>
  </div>
</div>


</body>
</html>