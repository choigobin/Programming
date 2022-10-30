/**
 * alert(알림)
 * prompt(입력 받음)
 * confirm(확인 받음)
 * 
 * 단점
 *  1.스크립트 일시 정지
 *  2.스타일링 X(브라우저마다 모양이 다름)
 */
const name1 = prompt("이름을 입력하세요.", "초기값");
console.log(name1);
alert("환영합니다,  " + name1 + "님");
const quest = confirm("당신은 사람입니까?");
console.log(quest);