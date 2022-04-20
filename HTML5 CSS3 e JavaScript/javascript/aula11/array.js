var num = [1 , 2, 21,2]
console.log(num)
num.push(6)


num.sort()
console.log(num)

// metodo para achar a posicao do valor 2
num.indexOf(2) // retorna -1 se nao tiver o valor no vetor


for(let pos in num){
    console.log(num[pos])
}
