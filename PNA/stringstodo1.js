function removeBlanks(str) {
    let newStr = ''
    for (let i=0; i<str.length; i++){
        if(str[i] != ''){
            newStr += str[i]
        }

    }
    return newStr
}
console.log(removeBlanks(" Pl ayTha tF u nkyM usi c ") )
console.log(removeBlanks("I can not BELIEVE it's not BUTTER"))

function getDigits(str){
    let newNumStr = "";
    for (let char in str){
        if (!isNaN(str[char])){
            newNumStr += str[char]
        }
    }
    return newNumStr


return Number(newNumStr)
}

console.log(getDigits("abc8c0d1ngd0j0!8"))
console.log(getDigits("0s1a3y5w7h9a2t4?6!8?0") )

function acronym(str){
    let wordsArray = str.split('')
    let acronymStr = ""
    for (let word in wordsArray){
        if (wordsArray[word].length > 0){
            acronymStr += wordsArray[word][0].toUpperCase();
        }
    }
    return acronymStr
}
console.log(acronym(" there's no free lunch - gotta pay yer way. ") )

console.log(acronym("Live from New York, it's Saturday Night!"))

function countNonSpaces(str){
    let counter = 0
    for (let char in str){
        if(str[char] != ""){
            counter ++
        }
    }
    return counter
}
console.log(countNonSpaces("Honey pie, you are driving me crazy") )
console.log(countNonSpaces("Hello world !") )


function removeShorterStrings(arr,len){
    let newStrings = []
    let nextIndex = 0
    for (let value in arr){
        if(arr[value].length >= len){
            newStrings[nextIndex ++ ] = arr[value] 
        }
    }
    return newStrings
}
console.log(removeShorterStrings(['Good morning', 'sunshine', 'the', 'Earth', 'says', 'hello'], 4) )
console.log(removeShorterStrings(['There', 'is', 'a', 'bug', 'in', 'the', 'system'], 3))