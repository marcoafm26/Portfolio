function calcular(){
    var nasc = document.getElementById('nasc')
    var data = new Date();
    var ano = data.getFullYear()
    var sexMasc = document.getElementById('masc')
    var sexFem = document.getElementById('fem')
    var txtIdade= document.getElementById('txtIdade')
    var img = document.createElement('img')

    img.setAttribute('id','foto')

    if (nasc.value.length == 0 || nasc.value > ano){
        alert("Informe um ano de nascimento válido")
    }else{     
        var idade = ano - Number(nasc.value);
        var sexFem = document.getElementById('fem')
        var sexMasc = document.getElementById('masc')

        txtIdade.style.textAlign = 'center'

        if(sexFem.checked){
            txtIdade.innerHTML = `Você é do sexo femino e tem ${idade} anos de idade.`
        }else{
            txtIdade.innerHTML = `Você é do sexo masculino e tem ${idade} anos de idade.`
        }

        if (idade <= 10)
            img.setAttribute('src','img/crianca.png')
        else if (idade > 10 && idade <= 20)
            img.setAttribute('src','img/jovem.png')
        else if (idade > 20 && idade <= 40)
            img.setAttribute('src','img/adulto.png')
        else
            img.setAttribute('src','img/idoso.png')
            txtIdade.appendChild(img)
 
    }

    
}