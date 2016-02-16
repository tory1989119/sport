<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>报名俱乐部</title>
    <!-- bootstrap 3.0.2 -->
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="<%=request.getContextPath()%>/css/MyAdminLTE.css" rel="stylesheet" type="text/css" />
        <!-- xcConfirm -->
        <link href="<%=request.getContextPath()%>/css/xcConfirm/xcConfirm.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap-treeview -->
        <link href="<%=request.getContextPath()%>/css/bootstrap-treeview/bootstrap-treeview.min.css" rel="stylesheet" type="text/css" />
        
         <!-- jQuery 2.0.2 -->
        <script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
    	<!-- AdminLTE App -->
        <script src="<%=request.getContextPath()%>/js/AdminLTE/app.js" type="text/javascript"></script>
        <!-- xcConfirm -->
    	<script src="<%=request.getContextPath()%>/js/plugins/xcConfirm/xcConfirm.js" type="text/javascript"></script>
    	<!-- xcConfirm -->
    	<script src="<%=request.getContextPath()%>/js/plugins/bootstrap-treeview/bootstrap-treeview.min.js" type="text/javascript"></script>
    
        <!-- page script -->
        <script type="text/javascript">
        	function add(){
        			var chk_value =[];
        			
        			for(var i = 0 ; i < $('#treeview-checkable').treeview('getChecked').length ; i++ ){
        				var id = $('#treeview-checkable').treeview('getChecked')[i].id;
                		if(id != null && id != ""){
                			chk_value.push(id);
                		}
                	}
        			var austr = chk_value.join(",");
        			
        			$.ajax({
        				type: "post",
                        url: "<%=request.getContextPath()%>/role/setauthority.do",
                        data: {
                            "id": $("#roleid").val(),
                            "austr": austr
                        }, success: function (data) {
                            data = jQuery.parseJSON(data);
                            var txt=  data.msg;
                            if(data.success != true){
                            	window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                            }else{
                            	window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.success);
                            }
                        }
                    });
        	}
        	$(function() {
                var $checkableTree = $('#treeview-checkable').treeview({
                  data: '${str}',
                  showIcon: false,
                  showCheckbox: true,
                  onNodeChecked: function(event, node) {
                  	if(node.nodes){
                  		for(var i = 0 ; i < node.nodes.length ; i++ ){
                  			$('#treeview-checkable').treeview('checkNode', [ node.nodes[i].nodeId, { silent: true } ]);
                  		}
                  	}
                  	var ischeck =true;
                  	for(var i = 0 ; i < $('#treeview-checkable').treeview('getSiblings', node).length ; i++ ){
                		if($('#treeview-checkable').treeview('getSiblings', node)[i].state.checked == false){
                			ischeck =false;
                		}		
                  	}
                  	
                  	if(ischeck){
                  		if($('#treeview-checkable').treeview('getParent', node).id != "" && $('#treeview-checkable').treeview('getParent', node).id != null){
                  			$('#treeview-checkable').treeview('checkNode', [ $('#treeview-checkable').treeview('getParent', node).nodeId, { silent: true } ]);
                  		}
                  	}
                  },
                  onNodeUnchecked: function (event, node) {
                    if(node.nodes){
                  		for(var i = 0 ; i < node.nodes.length ; i++ ){
                  			$('#treeview-checkable').treeview('uncheckNode', [ node.nodes[i].nodeId, { silent: true } ]);
                  		}
                  	}
                    if($('#treeview-checkable').treeview('getParent', node).id != "" && $('#treeview-checkable').treeview('getParent', node).id != null){
                    	$('#treeview-checkable').treeview('uncheckNode', [ $('#treeview-checkable').treeview('getParent', node).nodeId, { silent: true } ]);
                    }
                  }
                });
          	});
        	
        </script>
</head>
<body class="skin-blue">
           <aside class="right-side">
               <section class="content-header">
                   <h1>角色权限设置</h1>
                   <ol class="breadcrumb">
                       <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 基础管理</a></li>
                       <li >角色管理</li>
                   </ol>
               </section>

               <section class="content">
                   <div class="row">
                       <div class="col-xs-12">
                           <div class="box">
				                <div class="box-body">
				                  <div class="row">
					                   <div class="box-body">
					                   	   <input type="hidden" id="roleid" name="roleid" value="${roleid}">
						                   <div id="treeview-checkable" class=""></div>
		                                </div>
				                    <div class="col-xs-3">
					                	<button type="submit" class="btn btn-primary" onclick="add();">确定</button>
					                </div>
				                  </div>
				                </div>
                           </div>
                       </div>
                   </div>
               </section>
           </aside>
    </body>
</html>