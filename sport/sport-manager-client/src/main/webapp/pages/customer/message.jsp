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
        <!-- font Awesome -->
        <link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="<%=request.getContextPath()%>/css/MyAdminLTE.css" rel="stylesheet" type="text/css" />
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
        <!-- DATA TABES SCRIPT -->
        <script src="<%=request.getContextPath()%>/js/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/js/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
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
        	$('#dstart').datetimepicker({
        		minView: "month", //选择日期后，不会再跳转去选择时分秒 
        		format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
        		language: 'zh-CN', //汉化 
        		autoclose:true //选择日期后自动关闭 
            });
        	$('#dend').datetimepicker({
        		minView: "month", //选择日期后，不会再跳转去选择时分秒 
        		format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
        		language: 'zh-CN', //汉化 
        		autoclose:true //选择日期后自动关闭 
            });
        	
            table = $('#example').DataTable({
            	"bLengthChange": false,
            	"bFilter": false,
            	"ordering": false,
                "ajax": {
                	"type": "POST",
                	"data": function ( d ) {
                        //添加额外的参数传给服务器
                        d.actId = $("#sactId").val();
                        d.personId = $("#spersonId").val();
                        d.customerId = $("#scustomerId").val();
                        d.startdate = $("#startdate").val();
                        d.enddate = $("#enddate").val();
                        $("#showdig").css("display","block");//遮罩层开启
                    },
                	"dataType": "json",
                    "url": '<%=request.getContextPath()%>/message/getlist.do'
                },
                "serverSide": true,
                "columns": [
                    {"data": "id"},
                    {"data": "actId"},
                    {"data": "personId"},
                    {"data": "personName"},
                    {"data": "customerId"},
                    {"data": "customerName"},
                    {"data": "mdate"},
                    {"data": "rdate"},
                    {"data": null},
                    {"data": "message"},
                    {"data": "reply"}
                ],
                "columnDefs": [
                    {
                        "targets": 8,
                        "render": function (a, b, c, d) {
                        	var html = "<button type=\"button\" class=\"btn btn-primary btn-smg\" onclick=\"edit('"+ c.id +"','"+ c.message +"','"+ c.reply +"')\">回复</button>";
                        	html = html + " <button type=\"button\" class=\"btn btn-danger btn-smg\" onclick=\"del('"+ c.id +"')\">删除</button>";
                            return html;
                        }
                    },
                    {
                        "targets": 4,
                        "render": function (a, b, c, d) {
                        	if(c.customerId == 0){
                        		return '';
                        	}
                            return c.customerId;
                        }
                    },
                    {    
            	      "targets": [ 9,10 ], //从第0列开始   
  	          		  "visible": false    
  	          	    }
                ],
                "language": {
                    "lengthMenu": "_MENU_ 条记录每页",
                    "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                    "zeroRecords": "没有找到记录",
                    "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
                    "infoEmpty": "无记录",
                    "infoFiltered": "(从 _MAX_ 条记录过滤)",
                    "paginate": {
                        "previous": "上一页",
                        "next": "下一页"
                    }
                },
                "preDrawCallback":function( oSettings ) {
                	$("#showdig").css("display","none");//遮罩层关闭
                } 
            });
            
            
            $('#defaultForm').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    reply: {
                        validators: {
                            notEmpty: {
                                message: '回复内容不能为空'
                            }
                        }
                    }
                }
            });
            
        });
        
        /**
         * 查找
         */
        function search(){
        	table.ajax.reload();
        }
        
        /**
         *编辑显示
         **/
        function edit(id,message,reply) {
            $("#myModalLabel").text("回复");
            $("#id").val(id);
            $("#message").val(message);
            if(reply != "null" && reply != null){
            	$("#reply").val(reply);
            }
            $("#myModal").modal({backdrop: 'static'});
        }
        
        /**
         * 修改数据
         **/
        function addoredit() {
            $('#defaultForm').bootstrapValidator('validate');
        	if($('#defaultForm').data('bootstrapValidator').isValid()){
        		var addJson = {
                        "id": $("#id").val(),
                        "reply": $("#reply").val()
                    };
                    ajax(addJson);
                    $('#defaultForm').data('bootstrapValidator').resetForm(true);
        	}
            
        }

        function ajax(obj) {
            url = "<%=request.getContextPath()%>/message/edit.do";
            $.ajax({
            	type: "post",
                url:url ,
                data: {
                    "id": obj.id,
                    "reply": obj.reply
                }, success: function (data) {
                	$("#myModal").modal("hide");
                	data = jQuery.parseJSON(data);
                	var txt=  data.msg;
                    if(data.success != true){
                    	window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                    }else{
                    	$("#example").dataTable().fnDraw(true);
                    	window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.success);
                    }
                }
            });
        }


        /**
         * 删除数据
         * @param name
         */
        function del(id) {
        	var txt=  "确定要删除么？";
    		var option = {
    			title: "提示",
    			btn: parseInt("0011",2),
    			onOk: function(){
    				$.ajax({
    					type: "post",
                        url: "<%=request.getContextPath()%>/message/delete.do",
                        data: {
                            "id": id
                        }, success: function (data) {
                            data = jQuery.parseJSON(data);
                            if(data.success != true){
                            	var txt=  data.msg;
                                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
                            }else{
                            	$("#example").dataTable().fnDraw(true);
                            }
                        }
                    });
    			}
    		}
    		window.wxc.xcConfirm(txt, "custom", option);
        }
        //关闭弹出框
        function closeDiv(){
        	$('#defaultForm').data('bootstrapValidator').resetForm(true);
        	$("#myModal").modal("hide");
        }
        
        </script>
</head>
<body class="skin-blue">
           <aside class="right-side">
               <section class="content-header">
                   <h1>留言管理</h1>
                   <ol class="breadcrumb">
                       <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 客服管理</a></li>
                       <li >留言管理</li>
                   </ol>
               </section>
               
               <section class="content">
                   <div class="row">
                       <div class="col-xs-12">
                           <div class="box">
	                           <div id="showdig" class="overlay" style="display: none">
								  <i class="fa fa-refresh fa-spin"></i>
								</div>
				                <div class="box-body">
				                  	<div class="row">
					                  	<div class="col-xs-3">
							                <div id="dstart" class="input-group date form_datetime col-md-12">
							                    <input id="startdate" name="startdate" class="form-control" size="16" type="text" value="" readonly placeholder="开始日期">
												<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
												<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							                </div>
							            </div>
							            <div class="col-xs-3">
							                <div id="dend" class="input-group date form_datetime col-md-12">
							                    <input id="enddate" name="enddate" class="form-control" size="16" type="text" value="" readonly placeholder="结束日期">
												<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
												<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							                </div>
							            </div>
					                    <div class="col-xs-2">
					                      <input type="text" class="form-control" id="sactId" name="sactId" placeholder="活动编号">
					                    </div>
					                    <div class="col-xs-2">
					                      <input type="text" class="form-control" id="spersonId" name="spersonId" placeholder="会员编号">
					                    </div>
					                    <div class="col-xs-2">
					                      <input type="text" class="form-control" id="scustomerId" name="scustomerId" placeholder="客服编号">
					                    </div>
				                  	</div>
				                  	<br>
				                  	<div class="row">
					                    <div class="col-xs-3">
						                   <button type="button" class="btn btn-primary" onclick="search();">查询</button>
						                </div>
				                  	</div>
				                </div><!-- /.box-body -->
                               
                               <div class="box-body table-responsive">
                                   <table id="example" class="table table-striped table-bordered">
							        <thead>
							        <tr>
							        	<th width="8%">留言编号</th>
							            <th width="7%">活动编号</th>
							            <th width="10%">会员编号</th>
							            <th width="10%">会员名称</th>
							            <th width="10%">客服编号</th>
							            <th width="10%">客服名称</th>
							            <th width="15%">留言时间</th>
							            <th width="15%">回复时间</th>
							            <th width="15%">操作</th>
							        </tr>
							        </thead>
							        <tbody></tbody>
							        <!-- tbody是必须的 -->
							    </table>
                               </div>
                           </div>
                       </div>
                   </div>
               </section>
           </aside>
            
            <!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" onclick="closeDiv();"><span aria-hidden="true">&times;</span></button>
			                <h4 class="modal-title" id="myModalLabel">回复</h4>
			            </div>
			            <form id="defaultForm"  class="form-horizontal">
				            <div class="modal-body">
				            	<input type="hidden" class="form-control" id="id">
		                        <div class="form-group">
		                            <label class="col-lg-2 control-label">留言</label>
		                            <div class="col-lg-10">
		                            	<textarea class="form-control" id="message" name="message" style="width: 400px" disabled="disabled"></textarea>
		                            </div>
		                        </div>
		                        <div class="form-group">
		                            <label class="col-lg-2 control-label">回复</label>
		                            <div class="col-lg-10">
		                            	<textarea class="form-control" id="reply" name="reply" style="width: 400px" ></textarea>
		                            </div>
		                        </div>
				            </div>
			            </form>
			            <div class="modal-footer">
			                <button type="button" class="btn btn-default" onclick="closeDiv();">关闭</button>
			                <button type="button" class="btn btn-primary" onclick="addoredit();">保存</button>
			            </div>
			        </div>
			    </div>
			</div>
    </body>
</html>