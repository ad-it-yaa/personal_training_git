import React from 'react'
import './About.css'
export default function About() {
  return (
    <div>
    <main>
        <div class="main_container card">
            <div class="para0 card-body ">
                <h1 data-aos="fade-down-right">Who we are</h1>
                <br/>
                <h4 data-aos="zoom-out-left">NatWest Group is a relationship bank for a digital world. We champion potential; breaking down barriers and building financial confidence so the 19 million people, families and businesses we serve in communities throughout the UK and Ireland can rebuild and thrive. If our customers succeed, so will we.</h4>
                    <div class="main_content card">
                       
                    <div class="main_image" ></div>
                </div>
            </div>
            <div class="para1 flex ">
                <h3 className='color' data-aos="flip-up">Leadership & Governance</h3>
                <img src="https://www.natwestgroup.com/content/dam/natwestgroup_com/natwestgroup/images/single-article-445x275px/image.dim.480.nw-group-nature-sustainability-walking_445x275px.jpg" data-aos="slide-up" width="500px"/>
                <p class="p">Our priority is to maintain the highest standards of corporate governance, business integrity and professionalism. That’s how we drive long-term sustainable success.</p>
            </div>
            <div class="para1 flex card">
                <h3 data-aos="flip-up">Working at NatWest Group</h3>
    
                <img src="https://www.natwestgroup.com/content/dam/natwestgroup_com/natwestgroup/images/image.dim.480.working-at-natwest-group.jpeg" data-aos="slide-up" width="500px"/>
                <p class="p">Strong relationships with millions of customers are at the heart of our workforce. We are committed to having a motivated and inclusive workforce who are engaged and passionate about serving customers.</p>
            </div>
            <div class="para1 flex ">
                <h3 className='color' data-aos="flip-up">CareerSense</h3>
                <img src="https://www.natwestgroup.com/content/dam/natwestgroup_com/natwestgroup/images/image.dim.480.our-brands.jpeg" data-aos="slide-up" width="500px"/>
                <p class="p"> CareerSense is our employability education programme aimed at improving employability
                    prospects for young people aged 13-24 in the UK.
    
                    We're proud to be helping champion the potential and economic resilience of young people, and look
                    forward to growing this programme in partnership with schools across the UK.</p>
            </div>
            
        </div>
    </main>
    
    </div>
    )
}
