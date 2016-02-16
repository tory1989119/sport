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
        	
        	$('#strjoinstart').datetimepicker({
        		minView: "month", //选择日期后，不会再跳转去选择时分秒 
        		format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
        		language: 'zh-CN', //汉化 
        		autoclose:true //选择日期后自动关闭 
            });
        	$('#strjoinend').datetimepicker({
        		minView: "month", //选择日期后，不会再跳转去选择时分秒 
        		format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
        		language: 'zh-CN', //汉化 
        		autoclose:true //选择日期后自动关闭 
            });
        	
        	$('#strholdstart').datetimepicker({
        		minView: "month", //选择日期后，不会再跳转去选择时分秒 
        		format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
        		language: 'zh-CN', //汉化 
        		autoclose:true //选择日期后自动关闭 
            });
        	$('#strholdend').datetimepicker({
        		minView: "month", //选择日期后，不会再跳转去选择时分秒 
        		format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
        		language: 'zh-CN', //汉化 
        		autoclose:true //选择日期后自动关闭 
            });
        	
        	
        	$('#defaultForm1').bootstrapValidator({
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
        	
        	$('#defaultForm2').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                	act_name: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    },
                    act_title: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    }
                    
                    ,dstrjoinstart: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    }
                    
                    ,dstrjoinend: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    }
                    
                    ,dstrholdstart: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    }
                    
                    ,dstrholdend: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    }
                    
                    ,act_person: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    }
                    
                    ,act_person_mobile: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    }
                    
                    ,act_remark: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    }
                    
                    ,reward: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    }
                    
                    ,act_addr: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    }
                    
                    
                }
            });
        	
        	$('#defaultForm3').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                	com_logo: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    },
                    com_license_pic: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    },
                    com_authorize_pic: {
                        validators: {
                            notEmpty: {
                                message: '不能为空'
                            }
                        }
                    }
                }
            });
        });
        
        
        function regist(obj) {
        	$('#defaultForm1').bootstrapValidator('validate');
        	if($('#defaultForm1').data('bootstrapValidator').isValid()){
        		var url ="<%=request.getContextPath()%>/regist/toregist.do" ;
                $.ajax({
                	type: "post",
                    url:url ,
                    data: {
                        "username": $('#username').val(),
                        "password": $('#password').val(),
                        "acct_type": '2'
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
        
        function actbaseinfo(){
        	$('#defaultForm2').bootstrapValidator('validate');
        	if($('#defaultForm2').data('bootstrapValidator').isValid()){
        		var url ="<%=request.getContextPath()%>/actbaseinfo/toactbaseinfo.do" ;
                $.ajax({
                	type: "post",
                    url:url ,
                    data: {
                        "act_name": $('#act_name').val(),
                        "act_title": $('#act_title').val(),
                        "strjoinstart": $('#dstrjoinstart').val(),
                        "strjoinend": $('#dstrjoinend').val(),
                        "strholdstart": $('#dstrholdstart').val(),
                        "strholdend": $('#dstrholdend').val(),
                        "act_person": $('#act_person').val(),
                        "act_person_mobile": $('#act_person_mobile').val(),
                        "act_remark": $('#act_remark').val(),
                        "reward": $('#reward').val(),
                        "act_addr": $('#act_addr').val()
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
        
        function authorize(obj) {
        	$('#defaultForm3').bootstrapValidator('validate');
        	if($('#defaultForm3').data('bootstrapValidator').isValid()){
        		var url ="<%=request.getContextPath()%>/custcomapply/tocustcomapply.do" ;
                $.ajax({
                	type: "post",
                    url:url ,
                    data: {
                        "com_logo": $('#com_logo').val(),
                        "com_license_pic": $('#com_license_pic').val(),
                        "com_authorize_pic": $('#com_authorize_pic').val()
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
        
        function newmanager(){
        	$("#myModal1").modal({backdrop: 'static'});
        }
        
		function newactive(){
			$("#myModal2").modal({backdrop: 'static'});	
		}
        
		function newauthorize(){
			$("#myModal3").modal({backdrop: 'static'});
		}
		
		//关闭弹窗
        function closeDiv(grade){
        	if(grade == '1'){
        		$('#defaultForm1').data('bootstrapValidator').resetForm(true);
            	$("#myModal1").modal("hide");
        	}else if(grade == '2'){
        		$('#defaultForm2').data('bootstrapValidator').resetForm(true);
            	$("#myModal2").modal("hide");
        	}else{
        		$('#defaultForm3').data('bootstrapValidator').resetForm(true);
            	$("#myModal3").modal("hide");
        	}
        }
        
        </script>
</head>
<body><br><br>
      <div class="modal-dialog">
        <div class="modal-content">
            <form id="defaultForm"  class="form-horizontal">
	            <div class="modal-body">
                    <div class="form-group" align="center">
	                    <div class="col-lg-12">
	                    	<button type="button" class="btn btn-primary" onclick="newmanager();">新建管理员</button>
	                    </div>
                    </div>
                    <div class="form-group" align="center">
	                    <div class="col-lg-12">
	                    	<button type="button" class="btn btn-primary" onclick="newactive();">新建活动</button>
	                    </div>
                    </div>
                    <div class="form-group" align="center">
	                    <div class="col-lg-12">
	                    	<button type="button" class="btn btn-primary" onclick="newauthorize();">授权</button>
	                    </div>
                    </div>
	            </div>
            </form>
        </div>
    </div>
    
    
    <!-- Modal分类1 -->
			<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" onclick="closeDiv('1');"><span
			                        aria-hidden="true">&times;</span></button>
			                <h4 class="modal-title" id="myModalLabel1">新增</h4>
			            </div>
			            <form id="defaultForm1"  class="form-horizontal">
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
				            </div>
				          </form>
				          <div class="modal-footer">
			              	<button type="button" class="btn btn-default" onclick="closeDiv('1');">关闭</button>
			              	<button type="button" class="btn btn-primary" onclick="regist();">保存</button>
			              </div>
			        </div>
			    </div>
			</div>
			
			<!-- Modal分类2 -->
			<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" onclick="closeDiv('2');"><span
			                        aria-hidden="true">&times;</span></button>
			                <h4 class="modal-title" id="myModalLabel2">新增</h4>
			            </div>
			            <form id="defaultForm2"  class="form-horizontal">
				            <div class="modal-body">
								 <div class="form-group">
				                	<label class="col-lg-3 control-label">活动名称</label>
		                            <div class="col-lg-7">
				                    	<input type="text" class="form-control" id="act_name" name="act_name" maxlength="10" >
				                    </div>
					             </div>
					             <div class="form-group">
				                	<label class="col-lg-3 control-label">活动标题</label>
		                            <div class="col-lg-7">
				                    	<input type="text" class="form-control" id="act_title" name="act_title" maxlength="10" >
				                    </div>
					             </div>
					             
					             <div class="form-group">
				                	<label class="col-lg-3 control-label">活动联系人</label>
		                            <div class="col-lg-7">
				                    	<input type="text" class="form-control" id="act_person" name="act_person" maxlength="10" >
				                    </div>
					             </div>
					             
					             <div class="form-group">
				                	<label class="col-lg-3 control-label">联系人电话</label>
		                            <div class="col-lg-7">
				                    	<input type="text" class="form-control" id="act_person_mobile" name="act_person_mobile" maxlength="10" >
				                    </div>
					             </div>
					             
					             <div class="form-group">
				                	<label class="col-lg-3 control-label">比赛地方</label>
		                            <div class="col-lg-7">
				                    	<input type="text" class="form-control" id="act_addr" name="act_addr" maxlength="10" >
				                    </div>
					             </div>
					             
					             <div class="form-group">
				                	<label class="col-lg-3 control-label">报名开始时间</label>
		                            <div class="col-lg-7">
				                    	<div id="strjoinstart" class="input-group date form_datetime col-md-12">
						                    <input id="dstrjoinstart" name="dstrjoinstart" class="form-control" size="16" type="text" value="" readonly >
											<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
											<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
						                </div>
				                    </div>
					             </div>
					             <div class="form-group">
				                	<label class="col-lg-3 control-label">报名结束时间</label>
		                            <div class="col-lg-7">
				                    	<div id="strjoinend" class="input-group date form_datetime col-md-12">
						                    <input id="dstrjoinend" name="dstrjoinend" class="form-control" size="16" type="text" value="" readonly >
											<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
											<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
						                </div>
				                    </div>
					             </div>
					             
					             <div class="form-group">
				                	<label class="col-lg-3 control-label">活动开始时间</label>
		                            <div class="col-lg-7">
				                    	<div id="strholdstart" class="input-group date form_datetime col-md-12">
						                    <input id="dstrholdstart" name="dstrholdstart" class="form-control" size="16" type="text" value="" readonly >
											<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
											<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
						                </div>
				                    </div>
					             </div>
					             <div class="form-group">
				                	<label class="col-lg-3 control-label">活动结束时间</label>
		                            <div class="col-lg-7">
				                    	<div id="strholdend" class="input-group date form_datetime col-md-12">
						                    <input id="dstrholdend" name="dstrholdend" class="form-control" size="16" type="text" value="" readonly >
											<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
											<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
						                </div>
				                    </div>
					             </div>
					             
					             <div class="form-group">
		                            <label class="col-lg-3 control-label">奖励介绍</label>
		                            <div class="col-lg-7">
		                            	<textarea class="form-control" id="reward" name="reward" style="width: 400px" ></textarea>
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                            <label class="col-lg-3 control-label">活动介绍</label>
		                            <div class="col-lg-7">
		                            	<textarea class="form-control" id="act_remark" name="act_remark" style="width: 400px" ></textarea>
		                            </div>
		                        </div>
				            </div>
				          </form>
				          <div class="modal-footer">
			              	<button type="button" class="btn btn-default" onclick="closeDiv('2');">关闭</button>
			              	<button type="button" class="btn btn-primary" onclick="actbaseinfo();">保存</button>
			              </div>
			        </div>
			    </div>
			</div>
			
			<!-- Modal分类3 -->
			<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" onclick="closeDiv('3');"><span
			                        aria-hidden="true">&times;</span></button>
			                <h4 class="modal-title" id="myModalLabel3">新增</h4>
			            </div>
			            <form id="defaultForm3"  class="form-horizontal">
				            <div class="modal-body">
								 <div class="form-group">
				                	<label class="col-lg-2 control-label">公司logo</label>
		                            <div class="col-lg-5">
				                    	<input type="text" class="form-control" id="com_logo" name="com_logo" maxlength="10" >
				                    </div>
					             </div>
					             <div class="form-group">
				                	<label class="col-lg-2 control-label">公司执照</label>
		                            <div class="col-lg-5">
				                    	<input type="text" class="form-control" id="com_license_pic" name="com_license_pic" maxlength="10" >
				                    </div>
					             </div>
					             <div class="form-group">
				                	<label class="col-lg-2 control-label">授权图片</label>
		                            <div class="col-lg-5">
				                    	<input type="text" class="form-control" id="com_authorize_pic" name="com_authorize_pic" maxlength="10" >
				                    </div>
					             </div>
				            </div>
				          </form>
				          <div class="modal-footer">
			              	<button type="button" class="btn btn-default" onclick="closeDiv('3');">关闭</button>
			              	<button type="button" class="btn btn-primary" onclick="authorize();">保存</button>
			              </div>
			        </div>
			    </div>
			</div>
</body>
</html>