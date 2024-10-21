class Titulo extends HTMLElement{

    constructor(){
        super();

        //Criando uma arvore
        const shadow = this.attachShadow({mode:"open"});

        //Criando a base do componentes
        const raizComponente = document.createElement("h1");
        //Vamos deixar dinamico
        raizComponente.textContent = this.getAttribute("titulo");
        //Estilizando o componente
        const style = document.createElement("style");
        style.textContent = `
        h1{
            color:red;
        }
        `

        //enviar para shadow
        shadow.appendChild(raizComponente);
        shadow.appendChild(style);
    }
}

//Definindo uma nova tag
customElements.define('titulo-dinamico',Titulo);