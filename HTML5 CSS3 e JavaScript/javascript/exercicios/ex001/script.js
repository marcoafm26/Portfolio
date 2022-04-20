function carregar(){    
var hora =document.getElementById('hora')
var image = document.querySelector('#imagem')
var data = new Date();
var horario = data.getHours();
horario = 10
hora.innerHTML =`Agora são ${horario} horas.`;
if (horario> 6 && horario < 12){
    // imagem dia
    image.src = 'img/fotomanha.png'
    document.body.style.background = '#a7ba83';   
} else if(horario >= 12 && horario < 18){
    // imagem tarde
    image.src = 'img/fototarde.png'
    document.body.style.background = '#957c6f';

}else{
    // imagem noite
    image.src = 'img/fotonoite.png'
    document.body.style.background = '#221a29';
}
}