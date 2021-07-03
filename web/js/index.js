// 获取到类名叫nav的元素
var nav = document.querySelector('.nav');
//获取到所有的div
var div_list = nav.querySelectorAll('div');
//添加onclick事件
//获取所有的list
var lists = document.querySelectorAll('.list');
for(var i=0; i<div_list.length; i++){
	//给标签加下标属性
	div_list[i].index = i;
	//添加点击事件
	div_list[i].onclick = function(){
		//点击事件清空样式
		for(var j=0; j<div_list.length;j++){
			div_list[j].className = '';
		}
		//点击事件获取样式
		this.className = 'actived';
		//切换内容 先隐藏所有内容在显示新内容
		for(var x=0; x<lists.length; x++){
			lists[x].style.display = 'none';
		}
		lists[this.index].style.display = 'flex';
	}
}