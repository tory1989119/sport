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
        <!-- DATA TABLES -->
        <link href="<%=request.getContextPath()%>/css/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
        <!-- daterangepicker -->
        <link href="<%=request.getContextPath()%>/css/daterangepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
        <!-- xcConfirm -->
        <link href="<%=request.getContextPath()%>/css/xcConfirm/xcConfirm.css" rel="stylesheet" type="text/css" />
        <!-- bootstrapValidator -->
        <link href="<%=request.getContextPath()%>/css/bootstrapValidator/bootstrapValidator.min.css" rel="stylesheet" type="text/css" />
        
         <!-- jQuery 2.0.2 -->
        <script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
    	<!-- daterangepicker -->
    	<script src="<%=request.getContextPath()%>/js/plugins/daterangepicker/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    	<script src="<%=request.getContextPath()%>/js/plugins/daterangepicker/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    	<!-- xcConfirm -->
    	<script src="<%=request.getContextPath()%>/js/plugins/xcConfirm/xcConfirm.js" type="text/javascript"></script>
    	<!-- bootstrapValidator -->
    	<script src="<%=request.getContextPath()%>/js/plugins/bootstrapValidator/bootstrapValidator.min.js" type="text/javascript"></script>
    	<script src="<%=request.getContextPath()%>/js/plugins/bootstrapValidator/zh_CN.js" type="text/javascript"></script>
    
        <!-- page script -->
        <script type="text/javascript">
        var table;
        $(function () {
        	
        	
        	$('#defaultForm').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    loginname: {
                        validators: {
                            notEmpty: {
                                message: '登录名不能为空'
                            }
                        }
                    },
                    password: {
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            }
                        }
                    }
                }
            });
        });
        
        
        function regist(obj) {
        	$('#defaultForm').bootstrapValidator('validate');
        	if($('#defaultForm').data('bootstrapValidator').isValid()){
        		var url ="<%=request.getContextPath()%>/regist/toregist.do" ;
                $.ajax({
                	type: "post",
                    url:url ,
                    data: {
                        "username": $('#username').val(),
                        "password": $('#password').val(),
                        "acct_type": '0'
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
        }
        
        </script>
</head>
<body><br><br>
      <div class="modal-dialog">
        <div class="modal-content">
            <form id="defaultForm"  class="form-horizontal">
	            <div class="modal-body">
	                <div class="form-group">
	                	<label class="col-lg-2 control-label">用户名</label>
                           <div class="col-lg-5">
	                    	<input type="text" class="form-control" id="username" name="username" maxlength="20" >
	                    </div>
	                </div>
	                <div class="form-group">
	                	<label class="col-lg-2 control-label">密码</label>
                           <div class="col-lg-5">
	                    	<input type="password" class="form-control" id="password" name="password" maxlength="12" >
	                    </div>
	                </div>
                    <div class="form-group" align="center">
	                    <div class="col-lg-12">
	                    	<button type="button" class="btn btn-primary" onclick="regist();">保存</button>
	                    </div>
                    </div>
	            </div>
            </form>
        </div>
    </div>
</body>
</html>