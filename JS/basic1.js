/**변수
 * let 변할 수 있는 변수
 * const 변할 수 없는 변수(상수)
 * 변수명으로 예약어는 사용금지
 * 상수는 변수명을 가급적 대문자로
 */

/**자료형
 * 문자열은 "",''로 감싸줘야함
 * 숫자형은 사칙연산이 가능
 *  +(더하기),-(빼기),*(곱하기),/(나누기),%(나머지)
 *  문자열을 숫자로 나누면 NaN이 나옴(Not a Number)
 * 논리형 Boolean(true,false)
 * null(존재하지 않는 값),undefined(값이 할당되지 않음을 의미)
 * typeof 연산자는 자료형을 확인할 수 있음
 *  null = object(JS의 초기오류로 사실상 null은 오브젝트가 아님 하위호환을 위해 수정안하는 중)
 * 이외에 객체형,심볼형이 존재
 */
const name1 = "Mike";
console.log("I'm a boy");
console.log('I\'m a boy');
console.log(`My name is ${name1}`);// 따옴표(',")가 아닌 `(Single quotation)으로 문자열을 감싸면 문자열 내부에 변수를 표현가능

const x = 1/0;
console.log(x);
console.log("aa"/0);
console.log(typeof x);
