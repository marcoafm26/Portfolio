function contador(){
    var inicio = document.getElementById("txtinicio");
    var fim = document.getElementById("txtfim");
    var passo = document.getElementById("txtpasso");
    var res = document.getElementById("res");



    if (inicio.value.length == 0 || fim.value.length == 0 || passo.value.length == 0){

        alert("Impossível realizar a contagem. Confira os dados!")

    }else{
        
        var cont = Number(inicio.value)
        var fimNumber = Number(fim.value)
        var pas = Number(passo.value)
        var txt='Contando: <br>';

        if(cont > fimNumber|| pas <= 0 || cont < 0 || fimNumber < 0)
        alert("Impossível realizar a contagem. Confira os valores!")
        else{
            do{
                txt += `${cont} ${String.fromCodePoint(0x1F449)}`
                cont += pas
              } while (cont <= Number(fim.value))
              res.innerHTML = `${txt} ${String.fromCodePoint(0x1F3C1)}` ; // pode usar \u{code}
        }
     
    }
}