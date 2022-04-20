let amigo = {
    nome: 'Jose', 
    sexo: 'M',
    peso: 50,

    engordar (p=0){
        console.log('engordou')
        this.peso += p
    }
}
amigo.engordar(5)
console.log(amigo.peso)