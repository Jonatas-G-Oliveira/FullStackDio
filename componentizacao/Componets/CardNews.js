class CardNews extends HTMLElement{

    constructor(){
        super();
    

    //criando a raiz
    const elementoCard = this.attachShadow({ mode: "open" });
    elementoCard.appendChild(this.build());
    elementoCard.appendChild(this.styles());
    
    }


    build(){
        //componente raiz
        const card = document.createElement("div");
        card.setAttribute("class", "card");

        const card_left = document.createElement("div");
        card_left.setAttribute("class","card_left");
        
        //Conteudo principal
        const autor = document.createElement("span");
        autor.setAttribute("span","autor");
        autor.textContent = "By " + (this.getAttribute("autor") || " Anonymous");
        
        const linkTitle = document.createElement("a");
        linkTitle.textContent = this.getAttribute("titulo");
        linkTitle.href = this.getAttribute("link-url");

        const newsContent = document.createElement("p");
        newsContent.textContent = this.getAttribute("conteudo");

        const rodape = document.createElement("p");
        
        rodape.textContent = this.getAttribute("rodape") || "";

        card_left.appendChild(autor);
        card_left.appendChild(linkTitle);
        card_left.appendChild(newsContent);
        card_left.appendChild(rodape);

        //Imagem
        const card_right = document.createElement("div");
        card_right.setAttribute("class","card_right");
        const newsImage = document.createElement("img");
        card_right.appendChild(newsImage);
        newsImage.src = this.getAttribute("imagem") || "assets/imagem-padrao.webp";
        newsImage.alt = "Foto da noticia";


        //Adicionando as divs ao componente principal
        card.appendChild(card_left);
        card.appendChild(card_right);

        return card;
    }

    styles(){
        const estilo = document.createElement("style");
        estilo.textContent = `
            .card{
                width: 720px;
                display: flex;
                flex-direction: row;
                box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
            }

            .card_left{
                display: flex;
                flex-direction: column;
                justify-content: center;
                padding-left: 10px;
            }
            .card_left > span{
                font-weight:400;
            }

            .card_left > a{
                margin-top: 10px;
                font-size: 25px;
                text-decoration: none;
                color:black;
                font-weight: 400;
            }

            .card_left > p{
                color:gray;
                font-size:14px;
                text-align: justify;
            }

            .card_right{
                margin-left: 10px;
                
            }
            .card_right > img{
                width: 300px; 
                height: 200px;
            }

            .card_left > p{
                margin-top: 10px;
            }
             `

        return estilo;
    }
}

customElements.define('card-news', CardNews);