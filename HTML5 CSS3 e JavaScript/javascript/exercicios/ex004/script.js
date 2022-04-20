function tabuada(){
    var num = Number(document.getElementById("txtnum").value)
    var res = document.getElementById("res")
    var tabsel = document.getElementById("tabsel")

    if(num == 0)
    alert("Digite um valor válido.")
    else{
        tabsel.innerHTML = ''
        for(var i = 1; i <= 10; i++){
            let tab = document.createElement('option')
            tab.text =  `${num} X ${i} = ${num * i}`
            tab.value = `tab${i}`
            tabsel.appendChild(tab)
        }
    }
}