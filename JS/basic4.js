/**연산자(Operators)
 * +(더하기),-(빼기),*(곱하기),/(나누기),%(나머지)
 * **(거듭제곱)
 * 우선순위
 *  *,/ > +,- 수학과 같음
 */
let num = 10;
num = num + 5;
num += 5;
num %= 5;
num++;//지금은 num을 쓰고 그 다음부터 1 증가
++num;//지금부터 num에 1을 증가
num--;

/**비교 연산자
 * <,>,<=,>=,==,!=,===
 *  반환값은 boolean형
 *  1 == "1" -> true(동등 연산자)
 *  1 === "1" -> false(일치 연산자)
 */

console.log(1 == "1");
console.log(1 === "1");

/**조건문(if,else,else if)
 * if(조건){
 *  조건이 맞을 때 실행될 구문
 * }else if(조건){
 *  if조건이 아니고 위 조건이 맞을 때 실행될 구문
 * }else{
 *  위 모든 조건이 아닐 때 실행될 구문
 * }
 */
const num1 = 1;
if(1==num1){
    console.log("num1 is 1");
}else if(2==num1){
    console.log("num1 is 2");
}else{
    console.log("num1 is not in 1,2");
}

/**논리연산자
 * ||(OR), && (AND), !(NOT)
 * ||(OR)은 True를 발견하면 멈춤
 * && (AND)은 False를 발견하면 멈춤
 * 조건의 순서에 따라 로직의 속도가 달라짐
 */
const name1 = "Mike";
const age = 30;

if(name1 === 'Tom' || age > 19){
    console.log("통과1");
}
if(name1 === 'Mike' && age > 19){
    console.log("통과2");
}
if(!age < 19){
    console.log("통과3");
}
if(name1 == "Mike" && age == 30 || !age <19){
    //name1 == "Mike" && age == 30 || !age <19는
    //(name1 == "Mike" && age == 30) || !age <19과
    //같기 때문에 !age <19로 True가 됨 생각과 다르게 동작할 가능성 다분
    console.log("통과4");
}