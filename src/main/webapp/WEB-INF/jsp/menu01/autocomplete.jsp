<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<%@ include file="../inc/resource.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flights List.</title>
  <style>
  .ui-autocomplete-loading {
    background: white url("${ctx}/js/jquery/images/ui-anim_basic_16x16.gif") right center no-repeat;
  }
  #city { width: 25em; }
  </style>
</head>
<script type="text/javascript">
	$(function() {
	    function log( message ) {
	      $( "<div>" ).text( message ).prependTo( "#log" );
	      $( "#log" ).scrollTop( 0 );
	    }
	 
	    $( "#username" ).autocomplete({
	      source: function( request, response ) {
	        $.ajax({
	          url: "${ctx}/user/getDynamicUsers",
	          dataType: "json",
	          data: {
	            q: request.term
	          },
	          success: function( data ) {
	            response( data );
	          }
	        });
	      },
	      minLength: 2,
	      select: function( event, ui ) {
	        log( ui.item ?
	          "Selected: " + ui.item.label :
	          "Nothing selected, input was " + this.value);
	      },
	      open: function() {
	        $( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
	      },
	      close: function() {
	        $( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
	      }
	    });
	  });
</script>
<body>
	<div class="ui-widget">
 	 <label for="username">Your city: </label>
		<input id="username">
	</div>

<div class="ui-widget" style="margin-top:2em; font-family:Arial">
  Result:
  <div id="log" style="height: 200px; width: 300px; overflow: auto;" class="ui-widget-content"></div>
</div>
</body>
</html>