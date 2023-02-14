import React from 'react';


export default function Card(props) {

    const saveNews = () => {
        const newCard = {
            description: props.description,
            url: props.url
        }
        props.readLater(newCard);
    };
    return (
        <div className="card" data-testid="NewsCard">
            <div className="card-body">
                <div className="cardsContainer img" ><img className="image" alt='' src={props.urlToImage} width={200} /> </div>
                <br />
                <p className="card-title" >{props.title}</p>
                <p className="author"><b>{props.author}</b></p>
                <button type="submit" className="btn btn-primary" onClick={() => {
                    saveNews();
                }}>
                    Read Later
                </button>
            </div>
        </div >
    )
}