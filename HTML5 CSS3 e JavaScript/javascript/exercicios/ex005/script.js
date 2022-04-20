var vet = new Array();
let res = document.querySelector("div#res")

function add(){
    var txtnum = document.getElementById("txtnum")
    var txtvet = document.getElementById("txtvet")
    var sect = document.createElement("option")

    var num = Number(txtnum.value)

    if (txtnum.value.length > 0 && num >=1 && num <= 100){
        sect.text = `Valor ${num} foi adicionado.`
        txtvet.appendChild(sect)
        vet.push(num)
        res.innerHTML = ''
 
    }else
        alert("Insira um valor válido.")
    
        txtnum.value = ``
        txtnum.focus()
}

function end(){
    let min,max,soma = 0,media,tam
    tam = vet.length
    for (var i=0; i<tam; i++){
        pos = Number(vet[i])
        soma += pos
        if(i == 0){
            min = pos
            max = pos
        }else{
            if(pos < min)
                min = pos
            
            if(pos > max)
                max = pos        
        }
    }

    media = soma/vet.length

    res.innerHTML += `Ao todo, temos ${tam} números cadastrados.<br>`
    res.innerHTML += `O maior valor informado foi ${max}.<br>`
    res.innerHTML += `O menor valor informado foi ${min}.<br>`
    res.innerHTML += `Somando todos os valores, temos ${soma}.<br>`
    res.innerHTML += `A média dos valores digitados é ${media}.<br>`
}


function change(){
    let sect = document.getElementById("txtvet")
    if (sect.size <= 10)
    sect.setAttribute("size",`${sect.size +=1}`)
}