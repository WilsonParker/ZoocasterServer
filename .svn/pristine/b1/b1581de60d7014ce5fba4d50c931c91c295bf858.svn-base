var nowLocation;
var nowDebug = true;

function log(msg) {
	if(nowDebug)
		console.log(msg);
};

function movePage(page) {
	nowLocation = page;
	$.ajax({
		url : page,
		success : function(result){
			$("#content").html(result);
		}
	})
};

function moveLocation(page) {
	window.location.href = page;
};

function reload(){
	movePage(nowLocation);
};






/*
 * ############################################################################################################################################
 */


// input type="file" 에 upload 한 이미지를 미리 보기 할 수 있다
function readURL(input) {
    if (input.files && input.files[0]) {
    var reader = new FileReader();
    reader.onload = function (e) {
            $("img[name='"+input.name+"']").attr('src', e.target.result);
        }
      reader.readAsDataURL(input.files[0]);
    }
}

var imgMap = new Map();

// 이미지와 같은 영역에 이미지를 제거 시키는 X 버튼을 추가 시킨다
function addXButton(obj, onclick){
	var imgDeleteIcon = document.createElement( "i" );
    imgDeleteIcon.className = "fa fa-fw fa-times img-delete";
    imgDeleteIcon.style = "float:right";
    imgDeleteIcon.onclick = onclick;
    var par = $("img[name='"+obj.name+"']").parents()[0];
	deleteTag(par,"I");
	par.prepend(imgDeleteIcon);
    readURL(obj);
}

function deleteTag(par, tag){
	var idx = selectedRegions.findTagIndex(par, tag);
	if(idx != undefined)
		par.removeChild(par.childNodes[idx]);
}

//use this method when obj is input[type='file']
function deleteAll(obj){
    var imgTag = $("img[name='"+obj.name+"']");
    imgTag[0].src = "";
    deleteTag(imgTag.parents()[0],"I");
    imgMap.set(obj.name+"_index", 0)
    $("input[type='file'][name='"+obj.name+"']").val(null);
    /*log(imgMap.get(obj.name+"_index"));
    log("obj = ");
    log(obj);*/
}

// use this method when obj is this
function deleteOnITag(obj){
    var imgTag = obj.parentNode.childNodes[selectedRegions.findTagIndex(obj.parentNode, "IMG")];
    imgTag.src = "";
    deleteTag(imgTag.parentNode, "I");
    imgMap.set(imgTag.name+"_index", 0)
    $("input[type='file'][name='"+imgTag.name+"']").val(null);
    /*log(imgMap.get(imgTag.name+"_index"));
    log("imgTag = ");
    log(imgTag);*/
}

function reload_js(src) {
    $('script[src="' + src + '"]').remove();
    $('<script>').attr('src', src).appendTo('head');
}