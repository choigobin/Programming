/**형변환
 * String() 문자형으로 변환
 * Number() 숫자형으로 변환
 *  Number(null) -> 0
 *  Number(undefined) -> NaN
 * Boolean() 논리형으로 변환
 *  flase -> 0, 빈 문자열, null, undefined, NaN
 *  이외에는 true
 */
//const mathScore = prompt("수학 몇점?"); 프롬프트 입력은 문자로 받음 ex)50
//const engScore = prompt("영어 몇점?"); ex)50
//const result = (mathScore + engScore) / 2; -> 5050/2 (자동형변환)
//console.log(result); -> 2525 출력

console.log(
    typeof String(3),
    typeof 3,
    Number(true)
)