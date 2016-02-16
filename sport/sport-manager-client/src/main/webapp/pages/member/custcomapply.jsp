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
                        d.acctId = $("#sacctId").val();
                        d.comId = $("#scomId").val();
                        d.startdate = $("#startdate").val();
                        d.enddate = $("#enddate").val();
                        $("#showdig").css("display","block");//遮罩层开启
                    },
                	"dataType": "json",
                    "url": '<%=request.getContextPath()%>/custcomapply/getlist.do'
                },
                "serverSide": true,
                "columns": [
                    {"data": "id"},
                    {"data": "comId"},
                    {"data": "acctId"},
                    {"data": "applyStatus"},
                    {"data": "applyDate"},
                    {"data": null},
                    {"data": "comLogo"},
                    {"data": "comLicensePic"},
                    {"data": "comAuthorizePic"},
                    {"data": "note"}
                ],
                "columnDefs": [
                    {
                        "targets": 5,
                        "render": function (a, b, c, d) {
                        	var html = "<button type=\"button\" class=\"btn btn-primary btn-smg\" onclick=\"detail('"+ c.id+"','"+c.acctId+"','"+c.comId+"','"+c.comLogo+"','"+c.applyDate+"','"+c.applyStatus+"','"+c.comLicensePic+"','"+c.comAuthorizePic+"','"+c.note +"')\">详情</button>";
                            if(c.applyStatus == '0'){
                            	html = html + " <button type=\"button\" class=\"btn btn-primary btn-smg\" onclick=\"check('"+ c.id +"','1')\">审核通过</button>";
                            	html = html + " <button type=\"button\" class=\"btn btn-primary btn-smg\" onclick=\"check('"+ c.id +"','2')\">审核不通过</button>";
                            }
                            return html;
                        }
                    },
                    {
            	          "targets": 3, //隐藏第六列，从第0列开始   
  	          	        "render": function (a, b, c, d) {
  	          	        	var name = '';
  	          	        	<c:forEach items="${statuslist}" var="status">
  	          	        		var statusid = '${status.dataid}';	          	        		
  	          	        		if(statusid == c.applyStatus){
  	          	        			name = '${status.dataname}';
  	          	        		}
  	            			</c:forEach>
  	                        return name;
  	                    }    
  	          	    },
                    {    
	          	          "targets": [ 6,7,8,9 ], //从第0列开始   
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
            
        });
        
        /**
         * 查找
         */
        function search(){
        	table.ajax.reload();
        }
        

        /**
         * 审核
         * @param name
         */
        function check(id,status) {
        	if(status == '1'){
        		var txt=  "确定要审核通过么？";
        	}else{
        		var txt=  "确定要审核不通过么？";
        	}
        	
    		var option = {
    			title: "提示",
    			btn: parseInt("0011",2),
    			onOk: function(){
    				$.ajax({
    					type: "post",
                        url: "<%=request.getContextPath()%>/custcomapply/edit.do",
                        data: {
                            "id": id,
                            "status":status
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
        /**
         * 详情
         */
        function detail(id,acctId,comId,comLogo,applyDate,applyStatus,comLicensePic,comAuthorizePic,note){
        	$("#comAuthorizePic").attr('src',comAuthorizePic).attr("disabled",true);
        	$("#comLicensePic").attr('src',comLicensePic).attr("disabled",true);
        	$("#comLogo").attr('src',comLogo).attr("disabled",true);
        	$("#applyDate").val(applyDate).attr("disabled",true);
        	$("#applyStatus").val(applyStatus).attr("disabled",true);
        	$("#note").val(note).attr("disabled",true);
            $("#myModal").modal({backdrop: 'static'});
        }
        
      //关闭弹出框
        function closeDiv(){
        	$("#myModal").modal("hide");
        }
        
        </script>
</head>
<body class="skin-blue">
           <aside class="right-side">
               <section class="content-header">
                   <h1>主办方授权审核</h1>
                   <ol class="breadcrumb">
                       <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 会员管理</a></li>
                       <li >主办方授权审核</li>
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
					                      <input type="text" class="form-control" id="sacctId" name="sacctId" placeholder="账号编号">
					                    </div>
					                    <div class="col-xs-2">
					                      <input type="text" class="form-control" id="scomId" name="scomId" placeholder="主办方编号">
					                    </div>
					                    <div class="col-xs-1">
						                   <button type="button" class="btn btn-primary" onclick="search();">查询</button>
						                </div>
				                  	</div>
				                </div><!-- /.box-body -->
                               
                               <div class="box-body table-responsive">
                                   <table id="example" class="table table-striped table-bordered">
							        <thead>
							        <tr>
							        	<th width="10%">申请编号</th>
							            <th width="20%">主办方编号</th>
							            <th width="20%">账号编号</th>
							            <th width="10%">审核状态</th>
							            <th width="20%">申请时间</th>
							            <th width="20%">操作</th>
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
			                <h4 class="modal-title" id="myModalLabel">详情</h4>
			            </div>
			            <form id="defaultForm"  class="form-horizontal">
				            <div class="modal-body">
		                        <div class="form-group">
		                            <label class="col-lg-2 control-label">审核状态</label>
		                            <div class="col-lg-4">
		                            	<select class="form-control" id="applyStatus" name="applyStatus">
		                            	<c:forEach items="${statuslist}" var="status">
					          	        	<option value="${status.dataid}">${status.dataname}</option>
				            			</c:forEach>
										</select>
		                            </div>
		                            
		                            <label class="col-lg-2 control-label">申请时间</label>
		                            <div class="col-lg-4">
			                    		<input type="text" class="form-control" id="applyDate" name="applyDate">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                            <label class="col-lg-2 control-label">备注</label>
		                            <div class="col-lg-10">
		                            	<textarea class="form-control" id="note" name="note" style="width: 400px" ></textarea>
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">    
		                            <label class="col-lg-3 control-label">营业执照图片</label>
		                            <div class="col-lg-9">
			                    		<img src="" class="img-thumbnail" id="comLicensePic" name="comLicensePic">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                        	<label class="col-lg-3 control-label">授权书图片</label>
		                            <div class="col-lg-9">
		                            	<img src="" class="img-thumbnail" id="comAuthorizePic" name="comAuthorizePic">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                        	<label class="col-lg-3 control-label">公司logo</label>
		                            <div class="col-lg-9">
		                            <img src="" class="img-thumbnail" id="comLogo" name="comLogo">
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