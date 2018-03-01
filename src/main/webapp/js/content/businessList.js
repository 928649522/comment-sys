
$(function() {
	common.showMessage($("#message").val());
});
function remove(id) {
	if(confirm("确定要删除吗？")){
	$("#mainForm").attr("action",$("#basePath").val() + "/businesses/" + id);
	$("#mainForm").submit();
	}
}

function search() {
	$("#mainForm").atrr("method","GET");
	$("#mainForm").atrr("action",$("#basePath").val()+"/businesses");
	$("#mainForm").submit();
}

function modifyInit(id) {
	location.href = $("#basePath").val() + "/businesses/" + id;
}