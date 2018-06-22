    var selectedRegions = {
        icon_checked : "fa-check-square-o",
        icon_unchecked : "fa-square-o",
        icon_children_selected : "fa-square",
        regionList : new Array(),
        distinctList : new Array(),
        itemClick : function(item){
            var target = item.parentNode;
            if(item.classList.contains(this.icon_checked) || item.classList.contains(this.icon_children_selected)){
                this.remove(target);
            }else if(item.classList.contains(this.icon_unchecked)){
                this.push(target);
            }
        },
        // Add item in Array
        push : function(item){
            if(this.find(item) == undefined){
                // li 태그 자식 span 의 class 변경
                // console.log(item);
                // console.log(item.children);
                this.regionList.push(item);
                // this.distinctList.push(item.getAttribute("region"));
                var child = item.childNodes[this.findTagIndex(item, "SPAN")];
                child.classList.remove(this.icon_children_selected);
                child.classList.remove(this.icon_unchecked);
                child.classList.add(this.icon_checked);
                this.checkParent(item);
                this.clickChild(item);
            }
        },
        // Remove item in Array
        remove : function(item){
            for(var i=0;i<this.regionList.length; i++){
                var thisItem = this.regionList[i];
                // Get attribute name of region by li
                // console.log(thisItem);
                // console.log(item);
                // console.log(thisItem.getAttribute("region"));
                if(thisItem.getAttribute("region").includes(item.getAttribute("region"))){
                    // li 태그 자식 span 의 class 변경
                    // 선택된 region 중 관계가 있는 (광역시 > 광주, 부산) 자식들 체크를 지움
                	// Clear the chldren of the selected region that have relationships
                    var child = this.regionList[i].children[this.findTagIndex(this.regionList[i], "SPAN")];
                    child.classList.remove(this.icon_checked);
                    child.classList.remove(this.icon_children_selected);
                    child.classList.add(this.icon_unchecked);
                    this.regionList.splice(i,1);
                    this.checkParent(thisItem);
                    i--;
                }
            }
            var itemChildNode = item.childNodes[this.findTagIndex(item, "SPAN")];
            itemChildNode.classList.remove(this.icon_checked);
            itemChildNode.classList.remove(this.icon_children_selected);
            itemChildNode.classList.add(this.icon_unchecked);
        },
        // Find the item with val in array 
        find : function(item){
            return this.regionList.find(function(val){
                return val == item;
            });
        },
        // 배열안에 tagName 을 가진 TAG를 찾아 index 를 return
        // Find tag with tagName in array and return index
        findTagIndex : function(obj, tagName){
            for (var i = 0; i < obj.childNodes.length; i++) {
                // console.log(obj.childNodes[i].tagName);      
                if(obj.childNodes[i].tagName == tagName){
                    return i;
                }
            }
        },
        // 배열안에 tagName 을 가진 TAG를 찾아 배열 을 return
        // Find tag with tagName in array and return array
        findTags : function(arr, tagName){
            var children = new Array();
            for (var i = 0; i < arr.childNodes.length; i++) {
                // console.log(arr.childNodes[i].tagName);      
                if(arr.childNodes[i].tagName == tagName){
                    children.push(arr.childNodes[i]);
                }
            }
            // console.log(children);
            return children;
        },
        // 클릭 했을 때 부모에도 체크
        // Also check child when clicked
        checkParent : function(item){
            // 선택한 노드의 모든 부모를 체크 한다
        	// Check all parents of the selected node
            var parent = item.parentNode.parentNode;
            if(parent.getAttribute("region") != null){
            	// parent 의 UL 태그 중 LI 테그 리스트
            	// LI tag list among parent UL tag
            	var arrLI = this.findTags(parent.childNodes[this.findTagIndex(parent, "UL")], "LI");
            	// unselected count
            	var unSelectedCound = 0;
                // console.log(parent.getAttribute("region"));
                // console.log(parent.childNodes);
                for(var i=0; i<arrLI.length; i++){
                    var childSpan = arrLI[i].childNodes[this.findTagIndex(arrLI[i], "SPAN")];
                    if(childSpan.classList.contains(this.icon_unchecked)){
                        unSelectedCound++;
                    }else if(childSpan.classList.contains(this.icon_children_selected)){
                    	unSelectedCound+=0.5;
                    }
                }
                var childSpan = parent.childNodes[this.findTagIndex(parent, "SPAN")];
                childSpan.classList.remove(this.icon_unchecked);
                childSpan.classList.remove(this.icon_checked);
                childSpan.classList.remove(this.icon_children_selected);
                // is selected All?
                if(unSelectedCound == 0){
                	childSpan.classList.add(this.icon_checked);
                	this.regionList.push(parent);
                	// this.distinctList.push(childSpan.parentNode.getAttribute("region"));
                // is unselected All?
                }else if(unSelectedCound == arrLI.length){
                	childSpan.classList.add(this.icon_unchecked);
                	// this.distinct(parent);
                // If more than on child is selected
                }else{
                	childSpan.classList.add(this.icon_children_selected);
                }
                this.checkParent(parent);
            }
        },
        // 클릭 했을 때 모든 자식 클릭
        // Clicks all chilldren when cliked
        clickChild : function(item){
            // console.log(item);
            // console.log(item.children);
            // console.log(this.findTagIndex(item, "UL"));
            // item 에 자식 UL 이 있을 경우 (하위 자식이 있을 경우)
        	// If item has a child UL (if there is a child)
            if(this.findTagIndex(item, "UL") != undefined){
                var children = item.childNodes[this.findTagIndex(item, "UL")];
                // item.childNodes[this.findTagIndex(item, "UL")];
                // console.log(children);
                // console.log(children.childNodes);
                // console.log("children findTags li");
                // console.log(this.findTags(children, "LI"));
                // UL에서 LI 들만 가져옴
                // get LI tags in UL tag
                var liArr = this.findTags(children, "LI");
                for(var i=0;i<liArr.length;i++){
                    // console.log("liArr findTagIndex span");
                    // console.log(liArr[i].childNodes[this.findTagIndex(liArr[i], "SPAN")].classList);
                    var childSpan = liArr[i].childNodes[this.findTagIndex(liArr[i], "SPAN")];
                    // console.log("childSpan parent");
                    // console.log(childSpan.parentNode);
                    if(childSpan.classList.contains(this.icon_unchecked)){
                        childSpan.classList.remove(this.icon_unchecked);
                        childSpan.classList.remove(this.icon_children_selected);
                        childSpan.classList.add(this.icon_checked);
                        this.regionList.push(childSpan.parentNode);
                        // this.distinctList.push(childSpan.parentNode.getAttribute("region"));
                        this.clickChild(childSpan.parentNode);
                    }
                }
            }
        },
        // Region 을 최적화 : 부모가 선택 될 경우 자식들까지 distinctList 에 존재할 필요가 없다
       /* distinct : function(){
        	for(var i=0; i<this.distinctList.length; i++){
        		if(this.distinctList[i] != undefined){
	        		var compareRegion = this.distinctList[i].getAttribute("region");
	        		for(var j=0; j<this.distinctList.length; j++){
	        			var disRegion = this.distinctList[j].getAttribute("region");
	        			// console.log("region : "+compareRegion+" / "+disRegion);
	        			if(compareRegion != disRegion && disRegion.includes(compareRegion)){
	        				this.distinctList.splice(j,1);
	        				i--;
	        				j--;
	        			}
	        		}
        		}
        	}
        }*/
        distinct : function(item){
        	this.distinctList = new Array();
        	for(var i=0; i<this.regionList.length; i++){
                if(this.regionList[i].childNodes[this.findTagIndex(this.regionList[i], "SPAN")].classList.contains(this.icon_checked)){
                	this.distinctList.push(this.regionList[i].getAttribute("region"));
                }
            }
        	for(var i=0; i<this.distinctList.length; i++){
	            for(var j=0; j<this.distinctList.length; j++){
	                var item1 = this.distinctList[i];
	                var item2 = this.distinctList[j];
	                if(item1 != undefined && item1 != item2 && item2.includes(item1)){
	                	this.distinctList.splice(j,1);
	                    j--;
	                }       
	            }
        	}
            // console.log("this.distinctList");
            // console.log(this.distinctList);
        }
    };
	$(".sp-checkable").on("click",function(){
		selectedRegions.itemClick(this);
        /*console.log("selectedRegions before")
        console.log(selectedRegions.regionList);
        selectedRegions.itemClick(this);
        console.log("selectedRegions after");
        console.log(selectedRegions.regionList);
        console.log("selectedRegions after length : "+selectedRegions.regionList.length);*/
	});		

$.fn.extend({
	    treed: function (o) {
	      
	      var openedClass = 'fa fa-fw fa-minus-circle';
	      var closedClass = 'fa fa-fw fa-plus-circle';
	      
	      if (typeof o != 'undefined'){
	        if (typeof o.openedClass != 'undefined'){
	        openedClass = o.openedClass;
	        }
	        if (typeof o.closedClass != 'undefined'){
	        closedClass = o.closedClass;
	        }
	      };
	      
	        //initialize each of the top levels
	        var tree = $(this);
	        tree.addClass("tree");
	        tree.find('li').has("ul").each(function () {
	            var branch = $(this); //li with children ul
	            branch.prepend("<i class='indicator " + closedClass + "'></i>");
	            branch.addClass('branch');
	            branch.on('click', function (e) {
	                if (this == e.target) {
	                    var icon = $(this).children('i:first');
	                    icon.toggleClass(openedClass + " " + closedClass);
	                    $(this).children().children().toggle();
	                }
	            })
	            branch.children().children().toggle();
	        });
	        //fire event from the dynamically added icon
	      tree.find('.branch .indicator').each(function(){
	        $(this).on('click', function () {
	            $(this).closest('li').click();
	        });
	      });
	        //fire event to open branch if the li contains an anchor instead of text
	        tree.find('.branch>a').each(function () {
	            $(this).on('click', function (e) {
	                $(this).closest('li').click();
	                e.preventDefault();
	            });
	        });
	        //fire event to open branch if the li contains a button instead of text
	        tree.find('.branch>button').each(function () {
	            $(this).on('click', function (e) {
	                $(this).closest('li').click();
	                e.preventDefault();
	            });
	        });
	    }
	});

	//Initialization of treeviews

	$('#tree1').treed();

	//$('#tree2').treed({openedClass:'glyphicon-folder-open', closedClass:'glyphicon-folder-close'});
	$('#tree2').treed({openedClass:'fa fa-fw fa-minus-circle', closedClass:'fa fa-fw fa-plus-circle'});

	//$('#tree3').treed({openedClass:'glyphicon-chevron-right', closedClass:'glyphicon-chevron-down'});
	$('#tree3').treed({openedClass:'glyphicon-chevron-right', closedClass:'glyphicon-chevron-down'});
