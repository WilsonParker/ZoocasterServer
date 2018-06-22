/*
	// None Use
$.datepicker.regional['ko'] = {
  closeText: '닫기',
  prevText: '이전달',
  nextText: '다음달',
  currentText: '오늘',
  monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
  monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
  dayNames: ['일','월','화','수','목','금','토'],
  dayNamesShort: ['일','월','화','수','목','금','토'],
  dayNamesMin: ['일','월','화','수','목','금','토'],
  weekHeader: 'Wk',
  dateFormat: 'yy-mm-dd',
  firstDay: 0,
  isRTL: false,
  duration:200,
  showAnim:'show',
  showMonthAfterYear: true,
  yearSuffix:'년',
  showOn : "both",
  changeMonth: true,
  changeYear: true,
  showButtonPanel: true,
  currentText: "오늘",
  closeTest : "닫기"
 };
 
 $.datepicker.setDefaults($.datepicker.regional['ko']);
 $('#schDate').datepicker({
     defaultDate:$('#schDate').val()
 });
 
*/

/*$(function() {
  	// console.log(moment().endOf('day').fromNow().replace(/[^0-9]/g,''));
	// console.log(moment().add(1, "days").format("YYYY.MM.DD"));
	
    $('input[name="daterange"]').daterangepicker({
        timePicker: true,
        timePickerIncrement: 1,
        timePicker24Hour : true,
        alwaysShowCalendars : true,
        locale: {
            // format: 'MM/DD/YYYY h:mm A'
            format: 'YYYY.MM.DD HH:mm',
            minDate : moment(),
           	startDate : moment().add(14, 'days'),
            endDate : moment().add(14, 'days').add(2,'hours')
            // endDate : moment().add(14, 'days').add(2,'hours')
        }
    });
});*/

$(function() {
    $('input[name="daterange"]').daterangepicker({
        timePicker: true,
        timePickerIncrement: 1,
        timePicker24Hour : true,
        alwaysShowCalendars : true,
        minDate : moment(),
       	startDate : moment(),
        endDate : moment().add(1, "days").format("YYYY.MM.DD")+" 00:00",
        locale: {
            // format: 'MM/DD/YYYY h:mm A'
            format: 'YYYY.MM.DD HH:mm',
        }
    });
});

function setDaterangeTime(start, end){
	$('input[name="daterange"]').daterangepicker({
        timePicker: true,
        timePickerIncrement: 1,
        timePicker24Hour : true,
        alwaysShowCalendars : true,
       	startDate : start,
        endDate : end,
        locale: {
            format: 'YYYY.MM.DD HH:mm',
        }
    });
}

function getTimeStamp() {
	var d = new Date();

	var s = leadingZeros(d.getFullYear(), 4) + '-'
			+ leadingZeros(d.getMonth() + 1, 2) + '-'
			+ leadingZeros(d.getDate(), 2) + ' ' +

			leadingZeros(d.getHours(), 2) + ':'
			+ leadingZeros(d.getMinutes(), 2) + ':'
			+ leadingZeros(d.getSeconds(), 2);

	return s;
}

function leadingZeros(n, digits) {
	var zero = '';
	n = n.toString();

	if (n.length < digits) {
		for (i = 0; i < digits - n.length; i++)
			zero += '0';
	}
	return zero + n;
}
	
/*
 * $(function () { $("#schDate").daterangepicker({ timePicker: true,
 * timePickerIncrement: 30, locale: { format: 'YYYY/MM/DD h:mm A' }, startDate :
 * moment().add(14, 'days'), endDate : moment().add(14, 'days').add(2,'hours')
 * }); });
 */
// 출처: http://munak111.tistory.com/8 [munak]