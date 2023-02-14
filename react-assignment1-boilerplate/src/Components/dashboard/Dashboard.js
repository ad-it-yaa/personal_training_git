import React, { useState, useEffect } from 'react';
import Card from '../card/Card';


export default function Dashboard() {

    const [trending, setTrending] = useState([]);
    const [readlaterdb, setReadlaterdb] = useState([]);


    useEffect(() => {
        fetch("https://newsapi.org/v2/everything?q=apple&from=2022-11-23&to=2022-11-23&sortBy=popularity&apiKey=521c7e0bef574d289c18f97a371e9348")
            .then((res) => res.json())
            .then((data)=>{
                setTrending(data.articles);
            })
            })

    const readLater = (newCard) => {
        fetch("http://localhost:3001/readlater", {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(readLater)
            })
            .then(function (response) {
                if (response.status === 201) {
                    setReadlaterdb([...readlaterdb, response.data]);
                    alert('News Saved for Reading Later')
                }
            })
            .catch(function (error) {
                console.log(error);
            });
    };
    return (
        <div className='container'  style={{ width: "max", paddingTop: "90px", paddingBottom: "80px" }}>
            <h1 style={{ textAlign: "center" }}>News</h1>
            <div className='row' style={{ width: "max", paddingTop: "8 px" }}>
                {trending.map((news) => (
                    <Card
                        urlToImage={news.urlToImage}
                        title={news.title}
                        author={news.author}
                        description={news.description}
                        url={news.url}
                        readLater={readLater}
                    />
                ))
                }
            </div>
        </div>
    );
};