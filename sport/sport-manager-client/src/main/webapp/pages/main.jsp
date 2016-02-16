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
        <!-- font Awesome -->
        <link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="<%=request.getContextPath()%>/css/AdminLTE.css" rel="stylesheet" type="text/css" />
        <!-- xcConfirm -->
        <link href="<%=request.getContextPath()%>/css/xcConfirm/xcConfirm.css" rel="stylesheet" type="text/css" />
        <!-- bootstrapValidator -->
        <link href="<%=request.getContextPath()%>/css/bootstrapValidator/bootstrapValidator.min.css" rel="stylesheet" type="text/css" />
        <!-- layer -->
        <link href="<%=request.getContextPath()%>/css/layer/layer.css" rel="stylesheet" type="text/css" />
        
         <!-- jQuery 2.0.2 -->
        <script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="<%=request.getContextPath()%>/js/AdminLTE/app.js" type="text/javascript"></script>
        <!-- xcConfirm -->
    	<script src="<%=request.getContextPath()%>/js/plugins/xcConfirm/xcConfirm.js" type="text/javascript"></script>
    	<!-- bootstrapValidator -->
    	<script src="<%=request.getContextPath()%>/js/plugins/bootstrapValidator/bootstrapValidator.min.js" type="text/javascript"></script>
    	<script src="<%=request.getContextPath()%>/js/plugins/bootstrapValidator/zh_CN.js" type="text/javascript"></script>
    	<!-- layer -->
        <script src="<%=request.getContextPath()%>/js/plugins/layer/layer.js" type="text/javascript"></script>
        <!-- page script -->
        <script type="text/javascript">
            function getMenu(url){
            	document.getElementById("iframeid").src="<%=request.getContextPath()%>" + url; 
            }
            
            function showeditpwd(){
            	$("#myModal").modal({backdrop: 'static'});
            }
            
            $(function () {
	            $('#defaultForm').bootstrapValidator({
	                feedbackIcons: {
	                    valid: 'glyphicon glyphicon-ok',
	                    invalid: 'glyphicon glyphicon-remove',
	                    validating: 'glyphicon glyphicon-refresh'
	                },
	                fields: {
	                    oldpassword: {
	                        validators: {
	                            notEmpty: {
	                                message: '当前不能为空'
	                            }
	                        }
	                    },
	                    newpassword: {
	                        validators: {
	                            notEmpty: {
	                                message: '新密码不能为空'
	                            },
	                            identical: {
	                                field: 'newpassword1',
	                                message: '新密码与确认新密码不同'
	                            }
	                        }
	                    },
	                    newpassword1: {
	                        validators: {
	                            notEmpty: {
	                                message: '确认新密码不能为空'
	                            },
	                            identical: {
	                                field: 'newpassword',
	                                message: '确认新密码与新密码不同'
	                            }
	                        }
	                    }
	                }
	            });
	        });
	        //修改密码
        	function editpwd(){
        		$('#defaultForm').bootstrapValidator('validate');
            	if($('#defaultForm').data('bootstrapValidator').isValid()){
            		$("#myModal").modal("hide");
            		$.ajax({
            			type: "post",
                        url:"<%=request.getContextPath()%>/operator/editpwd.do" ,
                        data: {
                            "oldpassword": $('#oldpassword').val(),
                            "newpassword": $('#newpassword').val(),
                            "operatorid": '${operator.id}'
                        }, success: function (data) {
                        	data = jQuery.parseJSON(data);
                        	var txt=  data.msg;
                        	$('#defaultForm').data('bootstrapValidator').resetForm(true);
                            if(data.success != true){
                            	window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                            }else{
                            	layer.msg("修改密码成功，3秒后请重新登录系统", function(){window.location.href='<%=request.getContextPath()%>/login/loginout.do';});
                            }
                        }
                    });
            	}
        	}
	        
        	//关闭弹出框
            function closeDivpwd(){
            	$('#defaultForm').data('bootstrapValidator').resetForm(true);
            	$("#myModal").modal("hide");
            }
        	
            function iFrameHeight() {
                var ifm= document.getElementById("iframeid");
                ifm.height = window.screen.height;
            } 
        </script>
</head>
<body class="skin-blue">
        <header class="header">
            <a href="javascript:void(0)" class="logo">
                AdminLTE
            </a>
            <nav class="navbar navbar-static-top" role="navigation">
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        <li class="dropdown user user-menu">
                            <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="glyphicon glyphicon-user"></i>
                                <span>${operator.name}<i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="user-header bg-light-blue">
                                    <img src="<%=request.getContextPath()%>/img/avatar5.png" class="img-circle" alt="User Image" />
                                    <p>
                                        ${operator.name}
                                        <small>操作员编号：${operator.id}</small>
                                    </p>
                                </li>
                                
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a href="javascript:void(0)" class="btn btn-default btn-flat" onclick="showeditpwd();">修改密码</a>
                                    </div>
                                    <div class="pull-right">
                                        <a href="<%=request.getContextPath()%>/login/loginout.do" class="btn btn-default btn-flat">登出</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <aside class="left-side sidebar-offcanvas">
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="<%=request.getContextPath()%>/img/avatar5.png" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello, ${operator.name}</p>
                            <a href="javascript:void(0)"><i class="fa fa-circle text-success"></i> 在线</a>
                        </div>
                    </div>
                    <ul class="sidebar-menu">${barstr}</ul>
                </section>
            </aside>
            <iframe id="iframeid" name="iframename" width="100%" height="100%" src="<%=request.getContextPath()%>/pages/sy.jsp" frameborder="no" onLoad="iFrameHeight()"></iframe>
            
            
            <!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" onclick="closeDivpwd();"><span aria-hidden="true">&times;</span></button>
			                <h4 class="modal-title" id="myModalLabel">修改密码</h4>
			            </div>
			            <form id="defaultForm"  class="form-horizontal">
				            <div class="modal-body">
								<div class="form-group">
			                            <label class="col-lg-3 control-label">当前密码</label>
			                            <div class="col-lg-5">
			                                <input type="password" class="form-control" id="oldpassword" name="oldpassword" maxlength="12">
			                            </div>
			                        </div>
			                        <div class="form-group">
			                            <label class="col-lg-3 control-label">新密码</label>
			                            <div class="col-lg-5">
			                                <input type="password" class="form-control" id="newpassword" name="newpassword" maxlength="12">
			                            </div>
			                        </div>
			                        <div class="form-group">
			                            <label class="col-lg-3 control-label">确认新密码</label>
			                            <div class="col-lg-5">
			                                <input type="password" class="form-control" id="newpassword1" name="newpassword1" maxlength="12">
			                            </div>
			                        </div>		                        
				            </div>
			            </form>
			            <div class="modal-footer">
			                <button type="button" class="btn btn-default" onclick="closeDivpwd();">关闭</button>
			                <button type="button" class="btn btn-primary" onclick="editpwd();">保存</button>
			            </div>
			        </div>
			    </div>
			</div>
        </div>
    </body>
</html>